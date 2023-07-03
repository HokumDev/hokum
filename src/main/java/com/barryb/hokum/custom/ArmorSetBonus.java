package com.barryb.hokum.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class ArmorSetBonus {
    private Set<Item> requiredItems;
    private int requiredSetSize;
    private Runnable setBonusAction;

    public ArmorSetBonus(int requiredSetSize, Runnable setBonusAction) {
        this.requiredItems = new HashSet<>();
        this.requiredSetSize = requiredSetSize;
        this.setBonusAction = setBonusAction;
    }

    public void addRequiredItem(Item item) {
        this.requiredItems.add(item);
    }

    public boolean hasFullSetEquipped(LivingEntity player) {
        int count = 0;
        for (ItemStack itemStack : player.getArmorSlots()) {
            if (itemStack.getItem() instanceof ArmorItem) {
                ArmorItem armorItem = (ArmorItem) itemStack.getItem();
                if (requiredItems.contains(armorItem)) {
                    count++;
                }
            }
        }
        return count >= requiredSetSize;
    }

    public void applySetBonus(LivingEntity player) {
        if (hasFullSetEquipped(player)) {
            setBonusAction.run();
        }
    }

}
