package com.barryb.hokum.item.custom;

import com.barryb.hokum.custom.ModDamageSources;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
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

public class AmberSwordItem extends SwordItem {

    public AmberSwordItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {
        super(tier, attackMod, attackSpeedMod, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack iStack, LivingEntity target, LivingEntity attacker){
        if(target.hasEffect(MobEffects.GLOWING))
        {
            target.hurt(ModDamageSources.marked(attacker), 8);
        }


        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 140, 0), attacker);
        return super.hurtEnemy(iStack, target, attacker);

    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        components.add(Component.literal("Hit an enemy to inflict Glowing.").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        components.add(Component.literal("Deals double damage to Glowing enemies").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));

    }


}
