package com.barryb.hokum.item.custom;

import com.barryb.hokum.entity.effects.ModEffects;
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
import net.minecraft.world.item.Tier;

public class NetheriteStaffItem extends StaffItem {

    public NetheriteStaffItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {
        super(tier, attackMod, attackSpeedMod, props);
    }


    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity target, InteractionHand interactionHand) {
        if (!player.getCooldowns().isOnCooldown(itemStack.getItem())) {
            target.addEffect(new MobEffectInstance(ModEffects.VULNERABLE.get(), 120, 2), player);
            player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            player.level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0f, 1.0f);
            player.getCooldowns().addCooldown(this, 300);

        }

        return InteractionResult.PASS;
    }



}
