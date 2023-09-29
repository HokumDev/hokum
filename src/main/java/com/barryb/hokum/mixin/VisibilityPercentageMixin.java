package com.barryb.hokum.mixin;

import com.barryb.hokum.entity.effects.ModEffects;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LightLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(LivingEntity.class)
public abstract class VisibilityPercentageMixin<T extends LivingEntity> {
    @Shadow public abstract boolean hasEffect(MobEffect p_21024_);



    @Inject(at = @At("RETURN"), method = "Lnet/minecraft/world/entity/LivingEntity;getVisibilityPercent(Lnet/minecraft/world/entity/Entity;)D", cancellable = true)
    public void getVisibilityPercent(Entity player, CallbackInfoReturnable<Double> cir) {
            if(this.hasEffect(ModEffects.STEALTH.get())){
                int blockLight = player.getLevel().getBrightness(LightLayer.BLOCK,player.blockPosition());
                int skyLight = player.getLevel().getBrightness(LightLayer.SKY,player.blockPosition());
                int avgLight;
                float sunAngle = player.getLevel().getSunAngle(1);
                if(sunAngle > 1.5 && sunAngle < 4.5){
                    player.sendSystemMessage(Component.literal("In theory, its night."));
                    avgLight = blockLight;
                }else{
                    avgLight = Math.max(blockLight,skyLight);
                    player.sendSystemMessage(Component.literal(String.valueOf(player.getLevel().getSunAngle(1))));

                }

                if(avgLight < 7){
                    cir.setReturnValue(0.07);
                }


            }

    }


}

