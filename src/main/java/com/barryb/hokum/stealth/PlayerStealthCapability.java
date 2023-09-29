package com.barryb.hokum.stealth;

import net.minecraft.nbt.CompoundTag;

public class PlayerStealthCapability {
    private int stealth;
    private final int MAX_STEALTH = 0;
    private final int MIN_STEALTH = 0;

    public int getStealth(){
        return stealth;
    }

    public void setStealth(int newStealth){
        stealth = newStealth;
        return;
    }
    public void addStealth(int addStealth){
        stealth = Math.min(stealth + addStealth, MAX_STEALTH);
        return;
    }
    public void removeStealth(int subStealth){
        stealth = Math.max(stealth + subStealth, MIN_STEALTH);
        return;
    }

    public void copyFrom(PlayerStealthCapability stealthSource){
        this.stealth = stealthSource.stealth;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("stealth", stealth);
    }

    public void loadNBTData(CompoundTag nbt){
        stealth = nbt.getInt("stealth");
    }

}
