package com.barryb.hokum.mixin;

import com.barryb.hokum.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LightLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Animal.class)
public abstract class LuckyBoneMixin<T extends Animal> {



    @Inject(at = @At("RETURN"), method = "Lnet/minecraft/world/entity/animal/Animal;mobInteract(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResult;", cancellable = true)
    public void mobInteract(Player p_30412_, InteractionHand p_30413_, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
        Item item = itemstack.getItem();

        Animal animal = (Animal)(Object) this;
        if(animal instanceof Wolf){
            if (itemstack.is(ModItems.LUCKY_BONE.get())) {
                if (!p_30412_.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                if(((Wolf) animal).isTame()) {
                    animal.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0));
                    animal.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 2));
                    animal.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1));
                }
                else {
                    ((Wolf) animal).tame(p_30412_);
                    animal.setTarget((LivingEntity) null);
                    ((Wolf) animal).setOrderedToSit(true);
                    animal.level.broadcastEntityEvent(animal, (byte)7);
                }

            }
        }
    }




}

