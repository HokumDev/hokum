package com.barryb.hokum.mixin;

import com.barryb.hokum.entity.effects.ModEffects;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LightLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public class NoRenderMixin<T extends Entity> {
    @Inject(at = @At("RETURN"), method = "Lnet/minecraft/client/renderer/entity/EntityRenderer;shouldRender(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/client/renderer/culling/Frustum;DDD)Z", cancellable = true)
    public void shouldRender(T player, Frustum p_114492_, double p_114493_, double p_114494_, double p_114495_, CallbackInfoReturnable<Boolean> callback) {
        if(player instanceof Player){
            if(((Player) player).hasEffect(ModEffects.STEALTH.get()) && !((Player) player).hasEffect(ModEffects.REVEALED.get())){

                int blockLight = player.getLevel().getBrightness(LightLayer.BLOCK,player.blockPosition());
                int skyLight = player.getLevel().getBrightness(LightLayer.SKY,player.blockPosition());
                //int stealthLevel = ((Player) player).getEffect(ModEffects.REVEALED.get()).getAmplifier();
                int avgLight;
                float sunAngle = player.getLevel().getSunAngle(1);
                if(sunAngle > 1.5 && sunAngle < 4.5){
                    avgLight = blockLight;
                }else{
                    avgLight = Math.max(blockLight,skyLight);
                }



                if(avgLight < 7){
                    callback.setReturnValue(false);
                }


            }
        }
    }
}

