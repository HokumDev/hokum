package com.barryb.hokum.item;

import com.barryb.hokum.Hokum;
import com.barryb.hokum.entity.effects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, Hokum.MODID);

    public static final RegistryObject<Potion> WIDOW_POTION = POTIONS.register("widow_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.POISON, 200, 2)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
