package com.mrinnerpeace.mikubot.item;

import com.mrinnerpeace.mikubot.entities.CarSpawnEggEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.World;

public class CarEggItem extends SpawnEggItem<CarSpawnEggEntity> {

    public CarEggItem() {
        super(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC));
    }

    @Override
    CarSpawnEggEntity spawnEntity(World world) {
        return new CarSpawnEggEntity(EntityType.SNOWBALL, world);
    }

}