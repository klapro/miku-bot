package com.mrinnerpeace.mikubot.renderer;

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
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.data.EmptyModelData;

import java.awt.*;

abstract public class Renderer3DObject<Being extends Entity> extends EntityRenderer<Being> {

    private RenderRequest request = null;

    abstract RenderRequest setRenderRequest();
    abstract void animate(Being entity, MatrixStack matrix, float partialTicks);

    protected Renderer3DObject(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public ResourceLocation getEntityTexture(Being entity) {
        return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
    }

    @Override
    public void render(Being entity, float entityYaw, float partialTicks,
                       MatrixStack matrixStack, IRenderTypeBuffer renderBuffers, int packedLightIn) {

        if (request == null) {
            request = setRenderRequest();
        }

        IBakedModel bakedModel = Minecraft.getInstance().getModelManager().getModel(request.modelLocation);

        matrixStack.push();
        MatrixStack.Entry currentMatrix = matrixStack.getLast();

        Color blendColour = Color.WHITE;
        float red = blendColour.getRed() / 255.0F;
        float green = blendColour.getGreen() / 255.0F;
        float blue = blendColour.getBlue() / 255.0F;

        matrixStack.scale(request.scale, request.scale, request.scale);

        animate(entity, matrixStack, partialTicks);
        BlockRendererDispatcher dispatcher = Minecraft.getInstance().getBlockRendererDispatcher();

        IVertexBuilder vertexBuffer = renderBuffers.getBuffer(RenderType.getSolid());
        dispatcher.getBlockModelRenderer().renderModel(currentMatrix, vertexBuffer, null, bakedModel,
                red, green, blue, packedLightIn, OverlayTexture.NO_OVERLAY, EmptyModelData.INSTANCE);

        matrixStack.pop();

        super.render(entity, entityYaw, partialTicks, matrixStack, renderBuffers, packedLightIn);
    }

    public class RenderRequest {

        ResourceLocation modelLocation;
        float scale;

        public RenderRequest setModelLocation(ResourceLocation modelLocation) {
            this.modelLocation = modelLocation;
            return this;
        }

        public RenderRequest setScale(float scale) {
            this.scale = scale;
            return this;
        }
    }

}
