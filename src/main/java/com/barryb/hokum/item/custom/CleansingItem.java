package com.barryb.hokum.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class CleansingItem extends Item {
    private static final int USE_DURATION = 10;

    public CleansingItem(Item.Properties p_42921_) {
        super(p_42921_);
    }

    public ItemStack finishUsingItem(ItemStack p_42923_, Level p_42924_, LivingEntity p_42925_) {
        if (!p_42924_.isClientSide) p_42925_.curePotionEffects(p_42923_); // FORGE - move up so stack.shrink does not turn stack into air
        if (p_42925_ instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, p_42923_);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (p_42925_ instanceof Player && !((Player)p_42925_).getAbilities().instabuild) {
            p_42923_.shrink(1);
        }

        return p_42923_.isEmpty() ? new ItemStack(Items.AIR) : p_42923_;
    }

    public int getUseDuration(ItemStack p_42933_) {
        return 10;
    }

    public UseAnim getUseAnimation(ItemStack p_42931_) {
        return UseAnim.BLOCK;
    }

    public InteractionResultHolder<ItemStack> use(Level p_42927_, Player p_42928_, InteractionHand p_42929_) {
        return ItemUtils.startUsingInstantly(p_42927_, p_42928_, p_42929_);
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @org.jetbrains.annotations.Nullable net.minecraft.nbt.CompoundTag nbt) {
        return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
    }
}
