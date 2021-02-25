package com.mrinnerpeace.mikubot;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class MikuEggItem extends Item {

    public MikuEggItem() {
        super(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        Vector3d look = playerIn.getLookVec().mul(new Vector3d(0.5, 1.5, 0.5));
        Vector3d result = playerIn.getPositionVec().add(look);

        if (!worldIn.isRemote()) {
            MikuEggThrowableEntity egg = new MikuEggThrowableEntity(EntityType.SNOWBALL, worldIn);
            egg.setVelocity(1, 1 ,1);
            egg.setPosition(result.x , result.y, result.z);
            worldIn.addEntity(egg);
        }

        if (playerIn.isCreative()) {
            return new ActionResult(ActionResultType.PASS, new ItemStack(this));
        }

        return new ActionResult(ActionResultType.CONSUME, ItemStack.EMPTY);
    }
}