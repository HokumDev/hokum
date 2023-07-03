package com.barryb.hokum.client.renderer.entity;


import com.barryb.hokum.Hokum;
import com.mojang.blaze3d.vertex.PoseStack;
import com.barryb.hokum.entity.Widow;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WidowRenderer extends SpiderRenderer<Widow> {
    private static final ResourceLocation WIDOW_TEXTURES = new ResourceLocation(Hokum.MODID, "textures/entity/widow/widow.png");

    public WidowRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= 0.5F;
    }



    @Override
    protected void scale(Widow entity, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Widow entity) {
        return WIDOW_TEXTURES;
    }
}