package com.barryb.hokum.item.custom;

import com.barryb.hokum.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class PendulumOfDoomItem extends AxeItem {

    public static int ticksSinceSwing = 10000;
    public static int workaround = 0;

    public PendulumOfDoomItem(Tier tier, int attackMod, float attackSpeedMod, Properties props) {

        super(tier, attackMod, attackSpeedMod, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack iStack, LivingEntity target, LivingEntity attacker){
        boolean canAttack = ticksSinceSwing >= 80;
        ticksSinceSwing = 0;
        attacker.sendSystemMessage(Component.literal("Time Since Last Swing: " + ticksSinceSwing));
        if(canAttack){
            attacker.sendSystemMessage(Component.literal("Can attack"));
            int dmg = (int) (Math.random() * 4) + 13;
            int randomNumber = (int) (Math.random() * 5) + 1;
            if(randomNumber == 4){
                dmg = 30;
                target.level.playSound(null, target.getX(), target.getY(), target.getZ(), ModSounds.WOW_CRIT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);

            }
            attacker.sendSystemMessage(Component.literal("Dealing damage for : " + dmg));
            target.hurt(DamageSource.mobAttack(attacker), dmg);




        }
        return super.hurtEnemy(iStack, target, attacker);

    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if(workaround <= 5){
            workaround++;
            entity.sendSystemMessage(Component.literal("workaround incremented to " + workaround));

        }
        return super.onEntitySwing(stack, entity);
    }

    @Override
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity entity, int p_41407_, boolean p_41408_) {
        if(workaround > 0){workaround++;}
        if(workaround > 5)
        {
            ticksSinceSwing = 5;
            workaround = 0;
            entity.sendSystemMessage(Component.literal("workaround reset"));
        }
        if(ticksSinceSwing < 81){
            ticksSinceSwing++;
        }

        super.inventoryTick(p_41404_, p_41405_, entity, p_41407_, p_41408_);
    }
}
