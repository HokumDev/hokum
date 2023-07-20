package com.barryb.hokum.custom;

import com.barryb.hokum.Hokum;
import com.barryb.hokum.custom.AutoSmeltModifier;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class LootModifiers {

    private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> REGISTER = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Hokum.MODID);

    public static final RegistryObject<Codec<AutoSmeltModifier>> SMELT = REGISTER.register("smelt", () -> AutoSmeltModifier.CODEC);

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }

}

class AutoSmeltModifier extends LootModifier {
    public static final Codec<AutoSmeltModifier> CODEC = RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, AutoSmeltModifier::new));

    public AutoSmeltModifier(LootItemCondition[] conditions) {
        super(conditions);
    }
    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        return generatedLoot.stream().map(stack -> {
            var smeltedLoot = context.getLevel().getRecipeManager()
                    .getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), context.getLevel())
                    .map(SmeltingRecipe::getResultItem)
                    .filter(itemStack -> !itemStack.isEmpty())
                    .map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
                    .orElse(stack);
            if (smeltedLoot != stack) {
                ExperienceOrb.award(context.getLevel(), context.getParam(LootContextParams.ORIGIN), context.getRandom().nextInt(3) + 1);
            }
            return smeltedLoot;
        }).collect(ObjectArrayList.toList());
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return LootModifiers.SMELT.get();
    }
}