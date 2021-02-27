package com.mrinnerpeace.mikubot;

import com.mrinnerpeace.mikubot.item.CarEggItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MikuBotMod.MOD_ID);
    public static final RegistryObject<CarEggItem> CAR = ITEMS.register("car", () -> new CarEggItem());

}
