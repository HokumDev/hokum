package com.barryb.hokum.item.custom;

import com.barryb.hokum.item.ModItems;
import com.google.common.collect.ImmutableMap;
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
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class LuniteStaffItem extends StaffItem {

    public LuniteStaffItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {
        super(tier, attackMod, attackSpeedMod, props);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            var validTP1 = getValidTP(level, player, ClipContext.Fluid.NONE, 10);
            var posit = validTP1.getBlockPos();
            int ly = (int) level.clip(new ClipContext(Vec3.atBottomCenterOf(posit).add(0, 3, 0), Vec3.atBottomCenterOf(posit), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, null)).getLocation().y;
            Vec3 bo = player.getForward().normalize().multiply(player.getBbWidth() / 3, 0, player.getBbHeight() / 3);
            Vec3 bii = validTP1.getLocation().subtract(bo);
            Vec3 correctedPos = new Vec3(posit.getX(), ly, posit.getZ());
            boolean isnotblock = level.getBlockState(new BlockPos(correctedPos)).isAir();
            boolean hasLineOfSight = level.clip(new ClipContext(bii, bii.add(0, ly - posit.getY(), 0), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getType() == HitResult.Type.MISS;
            Vec3 validTP = null;
            if (isnotblock && hasLineOfSight && Math.abs(ly - posit.getY()) <= 3) {
                validTP = correctedPos.add(0.5, 0.076, 0.5);
            } else {
                validTP = level.clip(new ClipContext(bii, bii.add(0, -player.getEyeHeight(), 0), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player)).getLocation().add(0, 0.076, 0);
            }
            if (player.isPassenger()) {
                player.stopRiding();
            }
            player.teleportTo(validTP.x, validTP.y, validTP.z);
            player.level.playSound(null, validTP.x, validTP.y, validTP.z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0f, 1.0f);
            player.resetFallDistance();
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 2), player);
            player.getCooldowns().addCooldown(this, 100);
            player.awardStat(Stats.ITEM_USED.get(this));





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
