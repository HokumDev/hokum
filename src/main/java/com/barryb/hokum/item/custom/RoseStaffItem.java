package com.barryb.hokum.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class RoseStaffItem extends StaffItem {

    public RoseStaffItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {
        super(tier, attackMod, attackSpeedMod, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack iStack, LivingEntity target, LivingEntity attacker){
        if(!target.isInvertedHealAndHarm()){
            target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 2), attacker);
        }

        return super.hurtEnemy(iStack, target, attacker);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity target, InteractionHand interactionHand) {
        if(!target.isInvertedHealAndHarm() && !player.getCooldowns().isOnCooldown(itemStack.getItem())){
            target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 2), player);
            player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            player.level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
            player.getCooldowns().addCooldown(this, 15);

        }

        return InteractionResult.PASS;
    }



}
