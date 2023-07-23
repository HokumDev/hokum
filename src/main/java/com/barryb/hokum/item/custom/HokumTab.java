package com.barryb.hokum.item.custom;

import com.barryb.hokum.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class HokumTab {
    public static final CreativeModeTab HOKUM_TAB = new CreativeModeTab("hokumtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CELESTINE_CHESTPLATE.get());
        }
    };
}

