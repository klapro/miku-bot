package com.mrinnerpeace.mikubot;

import com.mrinnerpeace.mikubot.entities.CarEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MikuBotMod.MOD_ID);

    public static final String CAR_NAME = "car";
    public static final RegistryObject<EntityType<CarEntity>> CAR = ENTITIES.register(CAR_NAME, () ->
            EntityType.Builder.<CarEntity>create(CarEntity::new, EntityClassification.CREATURE)
                    .size(EntityType.PLAYER.getWidth(), EntityType.PLAYER.getHeight())
                    .build(new ResourceLocation(MikuBotMod.MOD_ID, CAR_NAME).toString())
    );

}
