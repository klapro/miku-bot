package com.mrinnerpeace.mikubot.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mrinnerpeace.mikubot.entities.CarEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CarRenderer extends Renderer3DObject<CarEntity> {

    public static ResourceLocation ressourceLocation = new ResourceLocation("mikubot:entity/car/car_wrapper");

    protected CarRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    RenderRequest setRenderRequest() {
        return new RenderRequest()
                .setModelLocation(ressourceLocation)
                .setScale(3);
    }

    @Override
    void animate(CarEntity entity, MatrixStack matrixStack, float partialTicks) {
        float directionOfMotion = MathHelper.lerp(partialTicks, entity.prevRotationYaw, entity.rotationYaw);
        matrixStack.rotate(Vector3f.YP.rotationDegrees((-1 * directionOfMotion) + 90));
    }

    public static class RenderFactory implements IRenderFactory<CarEntity> {

        @Override
        public EntityRenderer<? super CarEntity> createRenderFor(EntityRendererManager manager) {
            // TODO Auto-generated method stub
            return new CarRenderer(manager);
        }

    }
}
