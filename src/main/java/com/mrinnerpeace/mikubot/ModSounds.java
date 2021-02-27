package com.mrinnerpeace.mikubot;

import com.mrinnerpeace.mikubot.item.CarEggItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MikuBotMod.MOD_ID);
    public static final RegistryObject<SoundEvent> CAR_SOUND  = SOUNDS.register("car_sound", () -> new SoundEvent(new ResourceLocation(MikuBotMod.MOD_ID, "car_sound")));
}
