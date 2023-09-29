package com.barryb.hokum.entity;

import com.barryb.hokum.Hokum;
import com.barryb.hokum.custom.ArmorMaterials;
import com.barryb.hokum.item.FlowerCrownMaterial;
import com.barryb.hokum.item.custom.*;
import com.barryb.hokum.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModMobs {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Hokum.MODID);

    //REMBER: SET ATTRIBUTES!
    //AND ALSO ON CLIENT STARTUP IN HOKUM

    public static final RegistryObject<EntityType<Widow>> WIDOW =
            ENTITY_TYPES.register("widow",
                    () -> EntityType.Builder.of(Widow::new, MobCategory.MONSTER)
                            .sized(0.6f, 0.8f)
                            .build(new ResourceLocation(Hokum.MODID,  "widow").toString()));

    public static final RegistryObject<EntityType<MommyLongFangs>> MOMMY =
            ENTITY_TYPES.register("mommy_long_fangs",
                    () -> EntityType.Builder.of(MommyLongFangs::new, MobCategory.MONSTER)
                            .sized(2.6f, 2.2f)
                            .build(new ResourceLocation(Hokum.MODID, "mommy_long_fangs").toString()));

     public static final RegistryObject<EntityType<Sludgeon>> SLUDGEON =
            ENTITY_TYPES.register("sludgeon",
                    () -> EntityType.Builder.of(Sludgeon::new, MobCategory.MONSTER)
                            .sized(3f, 3f)
                            .build(new ResourceLocation(Hokum.MODID, "sludgeon").toString()));
    /*
        public static final RegistryObject<EntityType<LivingArmor>> LIVING_ARMOR =
                ENTITY_TYPES.register("living_armor",
                        () -> EntityType.Builder.of(LivingArmor::new, MobCategory.MONSTER)
                                .sized(3f, 3f)
                                .build(new ResourceLocation(Hokum.MODID, "living_armor").toString()));

    */
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }


}

