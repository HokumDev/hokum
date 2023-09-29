package com.barryb.hokum.entity;

import com.barryb.hokum.Hokum;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, Hokum.MODID);
    public static final RegistryObject<Attribute> STEALTH = ATTRIBUTES.register("stealth", () -> (Attribute) new RangedAttribute("Stealth", 0.0D, 0.0D, 24.0D).setSyncable(true));

    public static void register(IEventBus eventBus){
        ATTRIBUTES.register(eventBus);
    }


}
