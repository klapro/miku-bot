package com.mrinnerpeace.mikubot.entities;

import com.mrinnerpeace.mikubot.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.ThrowableEntity;

public class CarSpawnEggEntity extends SpawnEggThrowableEntity
{
    public CarSpawnEggEntity(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    Entity spawnEntity(EntityType reference, World world) {
        return new CarSpawnEggEntity(reference, world);
    }

    @Override
    EntityType entityType() {
        return ModEntities.CAR.get();
    }


}