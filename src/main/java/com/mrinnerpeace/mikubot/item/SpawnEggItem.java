package com.mrinnerpeace.mikubot.item;

import com.mrinnerpeace.mikubot.entities.SpawnEggThrowableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

abstract public class SpawnEggItem<Being extends SpawnEggThrowableEntity> extends Item {

    abstract Being spawnEntity(World world);

    public SpawnEggItem(Properties properties) {
        super(new Item.Properties().maxStackSize(64).group(ItemGroup.MISC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        System.out.println("IM CLICKED");
        Vector3d look = playerIn.getLookVec().mul(new Vector3d(0.5, 1.5, 0.5));
        Vector3d result = playerIn.getPositionVec().add(look);

        if (!worldIn.isRemote()) {
            System.out.println("SPAWNING");
            Being egg = spawnEntity(worldIn);
            egg.setPosition(result.x , result.y, result.z);
            worldIn.addEntity(egg);
        }

        if (playerIn.isCreative()) {
            return new ActionResult(ActionResultType.PASS, new ItemStack(this));
        }

        ItemStack hand = playerIn.inventory.getItemStack();
        hand.setCount(hand.getCount() - 1);
        return new ActionResult(ActionResultType.SUCCESS, hand);
    }
}
