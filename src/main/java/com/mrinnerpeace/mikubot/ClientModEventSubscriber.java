package com.mrinnerpeace.mikubot;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MikuBotMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MIKU.get(), new MikuRenderer.RenderFactory());
    }

    @SubscribeEvent
    public static void attributes(final EntityAttributeCreationEvent event) {
        AttributeModifierMap attributes = MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.2F).createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D).create();
        event.put(ModEntities.MIKU.get(), attributes);
    }

    @SubscribeEvent
    public static void onModelRegistryEvent(ModelRegistryEvent event) {
        ModelLoader.addSpecialModel(MikuRenderer.MODEL_RESOURCE_LOCATION);
    }

}
