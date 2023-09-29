package com.barryb.hokum.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public class SundialTestingItem extends StaffItem {

    public SundialTestingItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {
        super(tier, attackMod, attackSpeedMod, props);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.sendSystemMessage(Component.literal(String.valueOf(level.getTimeOfDay(1))));
            player.sendSystemMessage(Component.literal(String.valueOf(level.isRaining())));
            player.sendSystemMessage(Component.literal(String.valueOf(level.isNight())));


        }

        return super.use(level, player, hand);
    }

    //getItemInHand


    public static BlockHitResult getValidTP(Level level, LivingEntity player, ClipContext.Fluid clipContext, double maxDist) {
        var rotation = player.getLookAngle().normalize().scale(maxDist);
        var position = player.getEyePosition();
        var destination = rotation.add(position);
        return level.clip(new ClipContext(position, destination, ClipContext.Block.COLLIDER, clipContext, player));
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        components.add(Component.literal("Right click to teleport forward").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));

    }
}
