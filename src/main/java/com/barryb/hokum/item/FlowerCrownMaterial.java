package com.barryb.hokum.item;

import com.barryb.hokum.Hokum;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public record FlowerCrownMaterial(String name, Supplier<Ingredient> repairMaterial) implements ArmorMaterial {

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return 3;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return 1;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.MOSS_PLACE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return Hokum.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }

}

