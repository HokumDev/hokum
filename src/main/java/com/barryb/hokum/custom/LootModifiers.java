package com.barryb.hokum.custom;

import com.barryb.hokum.Hokum;
import com.barryb.hokum.custom.AutoSmeltModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModifiers {

    private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Hokum.MODID);

    public static final RegistryObject<Codec<AutoSmeltModifier>> SMELT = GLM.register("smelt", () -> AutoSmeltModifier.CODEC);

    public static void create(IEventBus bus) {
        GLM.register(bus);
    }

}