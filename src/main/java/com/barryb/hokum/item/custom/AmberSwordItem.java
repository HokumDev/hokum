package com.barryb.hokum.item.custom;

import com.barryb.hokum.custom.ModDamageSources;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class AmberSwordItem extends SwordItem {

    public AmberSwordItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {
        super(tier, attackMod, attackSpeedMod, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack iStack, LivingEntity target, LivingEntity attacker){
        if(target.hasEffect(MobEffects.GLOWING))
        {
            target.hurt(DamageSource.ANVIL, 4);
        }
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 140, 0), attacker);
        return super.hurtEnemy(iStack, target, attacker);

    }
}
