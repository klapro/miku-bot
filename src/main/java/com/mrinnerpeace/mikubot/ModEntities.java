package com.mrinnerpeace.mikubot;

import com.mrinnerpeace.mikubot.MikuBotMod;
import com.mrinnerpeace.mikubot.MikuEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MikuBotMod.MOD_ID);

    public static final String MIKU_NAME = "miku";
    public static final RegistryObject<EntityType<MikuEntity>> MIKU = ENTITIES.register(MIKU_NAME, () ->
            EntityType.Builder.<MikuEntity>create(MikuEntity::new, EntityClassification.CREATURE)
                    .size(EntityType.PLAYER.getWidth(), EntityType.PLAYER.getHeight())
                    .build(new ResourceLocation(MikuBotMod.MOD_ID, MIKU_NAME).toString())
    );

}
