package com.barryb.hokum.event;

import com.barryb.hokum.Hokum;
import com.barryb.hokum.entity.*;
import com.barryb.hokum.item.custom.AssassinArmorItem;
import com.barryb.hokum.stealth.PlayerStealthCapability;
import com.barryb.hokum.stealth.PlayerStealthProvider;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity player = (LivingEntity) event.getEntity();



        }
    }


    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerStealthProvider.PLAYER_STEALTH).isPresent()) {
                event.addCapability(new ResourceLocation(Hokum.MODID, "properties"), new PlayerStealthProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerStealthProvider.PLAYER_STEALTH).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerStealthProvider.PLAYER_STEALTH).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerStealthCapability.class);
    }


    @SubscribeEvent
    public void existingEntityAttributes(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, ModAttributes.STEALTH.get(), ModAttributes.STEALTH.get().getDefaultValue());

    }

    @SubscribeEvent
    public static void livingRender(RenderLivingEvent.Pre<?, ?> event) {
            event.setCanceled(true);
    }



    //bumper

    @Mod.EventBusSubscriber(modid = Hokum.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

    public static class ModEventBusEvents{
        @SubscribeEvent
        public static void entityAttrbiuteEvent(EntityAttributeCreationEvent event){
            event.put(ModMobs.WIDOW.get(), Widow.setAttributes());
            event.put(ModMobs.MOMMY.get(), MommyLongFangs.setAttributes());
            //event.put(ModMobs.SLUDGEON.get(), Sludgeon.setAttributes());

        }
    }


}
