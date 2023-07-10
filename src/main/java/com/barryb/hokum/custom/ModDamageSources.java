package com.barryb.hokum.custom;

import com.barryb.hokum.Hokum;
import com.barryb.hokum.custom.ArmorMaterials;
import com.barryb.hokum.item.FlowerCrownMaterial;
import com.barryb.hokum.item.custom.*;
import com.barryb.hokum.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModDamageSources {
    public static DamageSource doomHit (LivingEntity player) {
        return new EntityDamageSource("doomHit", player);
    }
    public static DamageSource doomCrit (LivingEntity player) {
        return new EntityDamageSource("doomCrit", player);
    }

    public static DamageSource marked (LivingEntity player) {
        return new EntityDamageSource("marked", player);
    }

}

