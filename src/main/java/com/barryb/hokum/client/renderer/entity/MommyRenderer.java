package com.barryb.hokum.client.renderer.entity;


import com.barryb.hokum.Hokum;
import com.barryb.hokum.entity.MommyLongFangs;
import com.barryb.hokum.entity.Widow;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MommyRenderer extends SpiderRenderer<MommyLongFangs> {
    private static final ResourceLocation MOMMY_TEXTURES = new ResourceLocation(Hokum.MODID, "textures/entity/widow/widow.png");

    public MommyRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= 2.6F;
    }



    @Override
    protected void scale(MommyLongFangs entity, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(2.6F, 2.6F, 2.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(MommyLongFangs entity) {
        return MOMMY_TEXTURES;
    }
}