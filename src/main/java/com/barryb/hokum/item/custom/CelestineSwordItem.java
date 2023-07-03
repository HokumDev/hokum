package com.barryb.hokum.item.custom;

import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class CelestineSwordItem extends SwordItem {

    public CelestineSwordItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {
        super(tier, attackMod, attackSpeedMod, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack iStack, LivingEntity target, LivingEntity attacker){
        attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1), attacker);
        return super.hurtEnemy(iStack, target, attacker);

    }
}
