package com.barryb.hokum.block.custom;

import com.barryb.hokum.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class CelestineBlock extends Block {
    public CelestineBlock(Properties props) {
        super(props);

    }

    @Override
    public void fallOn(Level p_152426_, BlockState p_152427_, BlockPos p_152428_, Entity entity, float p_152430_) {
        entity.causeFallDamage(p_152430_, 0, DamageSource.FALL);
        if(p_152430_ > 5){
            entity.level.playSound(null,
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    SoundEvents.GENERIC_BIG_FALL,
                    SoundSource.BLOCKS,
                    1.0f,
                    1.0f);
            entity.level.playSound(null,
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    ModSounds.CELESTINE_FALL.get(),
                    SoundSource.BLOCKS,
                    1.0f,
                    1.0f);

        }

    }

}
