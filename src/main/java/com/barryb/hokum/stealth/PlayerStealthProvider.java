package com.barryb.hokum.stealth;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerStealthProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerStealthCapability> PLAYER_STEALTH = CapabilityManager.get(new CapabilityToken<PlayerStealthCapability>() {
        @Override
        public String toString() {
            return super.toString();
        }
    });

    private PlayerStealthCapability stealth = null;
    private LazyOptional<PlayerStealthCapability> optional = LazyOptional.of(this::createPlayerStealth);

    private PlayerStealthCapability createPlayerStealth() {
        if(this.stealth == null){
            this.stealth = new PlayerStealthCapability();
        }
        return this.stealth;
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_STEALTH){
            return optional.cast();
        }
        return null;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerStealth().saveNBTData(nbt);
        return null;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerStealth().loadNBTData(nbt);

    }

}
