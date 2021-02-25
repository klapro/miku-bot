package com.mrinnerpeace.mikubot;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import java.awt.*;

public class MikuRenderer extends EntityRenderer<MikuEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation("mikubot:entity/miku_wrapper");

    public MikuRenderer(EntityRendererManager manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getEntityTexture(MikuEntity entity) {
        return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
    }

    @Override
    public void render(MikuEntity entity, float entityYaw, float partialTicks,
                       MatrixStack matrixStack, IRenderTypeBuffer renderBuffers, int packedLightIn) {

        IBakedModel mikuModel = Minecraft.getInstance().getModelManager().getModel(MODEL_RESOURCE_LOCATION);

        matrixStack.push();
        MatrixStack.Entry currentMatrix = matrixStack.getLast();

        Color blendColour = Color.CYAN;
        float red = blendColour.getRed() / 255.0F;
        float green = blendColour.getGreen() / 255.0F;
        float blue = blendColour.getBlue() / 255.0F;

        final float MODEL_SIZE_IN_ORIGINAL_COORDINATES = 10.0F;  // size of the wavefront model
        final float TARGET_SIZE_WHEN_RENDERED = 1F;  // desired size when rendered (in metres)

        final float SCALE_FACTOR = TARGET_SIZE_WHEN_RENDERED / MODEL_SIZE_IN_ORIGINAL_COORDINATES;
        matrixStack.scale(SCALE_FACTOR, SCALE_FACTOR, SCALE_FACTOR);

        BlockRendererDispatcher dispatcher = Minecraft.getInstance().getBlockRendererDispatcher();

        IVertexBuilder vertexBuffer = renderBuffers.getBuffer(RenderType.getSolid());
        dispatcher.getBlockModelRenderer().renderModel(currentMatrix, vertexBuffer, null, mikuModel,
                red, green, blue, packedLightIn, OverlayTexture.NO_OVERLAY, EmptyModelData.INSTANCE);

        matrixStack.pop();

        super.render(entity, entityYaw, partialTicks, matrixStack, renderBuffers, packedLightIn);
    }

    public static class RenderFactory implements IRenderFactory<MikuEntity> {

        @Override
        public EntityRenderer<? super MikuEntity> createRenderFor(EntityRendererManager manager) {
            // TODO Auto-generated method stub
            return new MikuRenderer(manager);
        }

    }
}
