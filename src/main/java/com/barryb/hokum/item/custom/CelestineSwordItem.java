package com.barryb.hokum.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class CelestineSwordItem extends SwordItem {

    public CelestineSwordItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {
        super(tier, attackMod, attackSpeedMod, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack iStack, LivingEntity target, LivingEntity attacker){
        attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1), attacker);
        return super.hurtEnemy(iStack, target, attacker);

    }
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        components.add(Component.literal("Hit an enemy for a speed boost!").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));

    }

}
