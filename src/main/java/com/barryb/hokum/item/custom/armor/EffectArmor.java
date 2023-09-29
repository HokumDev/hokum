package com.barryb.hokum.item.custom.armor;

import com.barryb.hokum.item.custom.ModArmorItem;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class EffectArmor extends ModArmorItem {
    public MobEffect crouchEffect;
    public MobEffect standardEffect;
    public EffectArmor(ArmorMaterial material, EquipmentSlot slot, Properties props, MobEffect crouchEffect, MobEffect standardEffect) {
        super(material, slot, 0, 0, props);
        this.crouchEffect = crouchEffect;
        this.standardEffect = standardEffect;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player){
        if(player.isCrouching()){
            player.addEffect(new MobEffectInstance(crouchEffect, 3, 0));

        }else{
            player.addEffect(new MobEffectInstance(standardEffect, 3, 0));
        }

    }

}
