package com.mrinnerpeace.mikubot.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.entity.PartEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

abstract public class SpawnEggThrowableEntity<Being extends Entity> extends ThrowableEntity {

    private Being entity;

    protected SpawnEggThrowableEntity(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    abstract Being spawnEntity(EntityType<Being> reference, World world);
    abstract EntityType<Being> entityType();

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!world.isRemote()) // never spawn entity on client side
        {
             Vector3d vector = result.getHitVec();
             Being being = spawnEntity(entityType(), world);
             being.setLocationAndAngles(vector.x, vector.y, vector.z, rotationYaw, 0.0F);
             world.addEntity(being);
             setDead();
        }
    }

    @Override
    protected void registerData() { }
    @Override
    public Entity getEntity() {
        return null;
    }
    @Override
    public void deserializeNBT(CompoundNBT nbt) {}
    @Override
    public CompoundNBT serializeNBT() {
        return null;
    }
    @Override
    public boolean shouldRiderSit() {
        return false;
    }
    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return null;
    }
    @Override
    public boolean canRiderInteract() {
        return false;
    }
    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return false;
    }
    @Override
    public EntityClassification getClassification(boolean forSpawnCount) {
        return null;
    }
    @Override
    public boolean isMultipartEntity() {
        return false;
    }
    @Nullable
    @Override
    public PartEntity<?>[] getParts() {
        return new PartEntity[0];
    }
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        return null;
    }
}
