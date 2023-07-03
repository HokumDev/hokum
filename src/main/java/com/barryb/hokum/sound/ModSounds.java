package com.barryb.hokum.sound;

import com.barryb.hokum.Hokum;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds extends SoundEvent{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Hokum.MODID);

    public static RegistryObject<SoundEvent> RECORD_CHIRP =
            registerSoundEvent("record_chirp");

    public static RegistryObject<SoundEvent> CELESTINE_FALL =
            registerSoundEvent("celestine_fall");

    public ModSounds(ResourceLocation p_11659_) {
        super(p_11659_);
    }

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Hokum.MODID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
