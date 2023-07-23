package com.barryb.hokum.event;

import com.barryb.hokum.Hokum;
import com.barryb.hokum.entity.ModMobs;
import com.barryb.hokum.entity.MommyLongFangs;
import com.barryb.hokum.entity.Widow;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity player = (LivingEntity) event.getEntity();



        }
    }

    @Mod.EventBusSubscriber(modid = Hokum.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

    public static class ModEventBusEvents{
        @SubscribeEvent
        public static void entityAttrbiuteEvent(EntityAttributeCreationEvent event){
            event.put(ModMobs.WIDOW.get(), Widow.setAttributes());
            event.put(ModMobs.MOMMY.get(), MommyLongFangs.setAttributes());

        }
    }

}
