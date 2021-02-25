package com.mrinnerpeace.mikubot;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MikuBotMod.MOD_ID);
    public static final RegistryObject<MikuEggItem> MIKU = ITEMS.register("miku", () -> new MikuEggItem());

}
