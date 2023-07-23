package com.barryb.hokum.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class CelestineStaffItem extends StaffItem {

    public CelestineStaffItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {
        super(tier, attackMod, attackSpeedMod, props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            if (player.isOnGround()) {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 15, 15), player);
                player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0), player);
                player.level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_DRAGON_FLAP, SoundSource.PLAYERS, 1.0f, 1.0f);
                player.getCooldowns().addCooldown(this, 50);
                player.awardStat(Stats.ITEM_USED.get(this));
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 10), player);
                player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 85, 0), player);
                player.level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_DRAGON_FLAP, SoundSource.PLAYERS, 1.0f, 1.0f);
                player.getCooldowns().addCooldown(this, 60);
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }

        return super.use(level, player, hand);
    }

    //getItemInHand

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("While on the ground, you'll gain a bigger boost than in the air. Also grants Slow Falling").withStyle(ChatFormatting.WHITE));
        } else {
            components.add(Component.literal("Right click for a boost up!").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
            components.add(Component.literal("Shift for more details").withStyle(ChatFormatting.DARK_GRAY).withStyle(ChatFormatting.ITALIC));

        }
    }



}
