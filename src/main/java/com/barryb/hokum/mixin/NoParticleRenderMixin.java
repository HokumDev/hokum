package com.barryb.hokum.mixin;

import com.barryb.hokum.entity.effects.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class NoParticleRenderMixin<T extends LivingEntity> {
    @Shadow @Final private Map<MobEffect, MobEffectInstance> activeEffects;

    @Shadow protected abstract void removeEffectParticles();

    @Shadow public abstract boolean hasEffect(MobEffect p_21024_);


    @Shadow public abstract boolean addEffect(MobEffectInstance p_21165_);

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/entity/LivingEntity;updateInvisibilityStatus()V", cancellable = true)
    protected void updateInvisibilityStatus(CallbackInfo ci) {
        if(this.hasEffect(ModEffects.STEALTH.get())){
            this.removeEffectParticles();
            ci.cancel();
        }

    }

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", cancellable = true)
    public void hurt(DamageSource p_21016_, float p_21017_, CallbackInfoReturnable<Boolean> cir){
        if(this.hasEffect(ModEffects.STEALTH.get())){
            this.addEffect(new MobEffectInstance(ModEffects.REVEALED.get(), 400, 0));
        }
    }
}


