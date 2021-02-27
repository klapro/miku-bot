package com.mrinnerpeace.mikubot;

import com.mrinnerpeace.mikubot.entities.CarEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MikuBotMod.MOD_ID)
public class PlayerEventSubscriber {


    @SubscribeEvent
    public static void onMountEvent(final EntityMountEvent event) {
        Entity mountingEntity = event.getEntityMounting();
        Entity mountedEntity = event.getEntityBeingMounted();

        if (!(mountingEntity instanceof PlayerEntity)) return;

        PlayerEntity player = (PlayerEntity) mountingEntity;

        if (mountedEntity instanceof CarEntity) {
            if (event.isMounting()) {
                Minecraft.getInstance().gameSettings.fov = 120;
                Minecraft.getInstance().gameSettings.setPointOfView(PointOfView.THIRD_PERSON_BACK);
                player.setInvisible(true);
            }

            if (event.isDismounting()) {
                Minecraft.getInstance().gameSettings.setPointOfView(PointOfView.FIRST_PERSON);
                Minecraft.getInstance().gameSettings.fov = 70;
                player.setInvisible(false);
            }
        }
    }

}
