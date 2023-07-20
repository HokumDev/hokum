package com.barryb.hokum.entity.effects;

import com.barryb.hokum.Hokum;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Hokum.MODID);

    public static final RegistryObject<MobEffect> VULNERABLE = MOB_EFFECTS.register("vulnerable",
            () -> new VulnerableEffect(MobEffectCategory.HARMFUL, 15976192));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}


