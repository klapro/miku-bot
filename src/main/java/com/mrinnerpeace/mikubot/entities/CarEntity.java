package com.mrinnerpeace.mikubot.entities;

import com.mrinnerpeace.mikubot.ModEntities;
import com.mrinnerpeace.mikubot.ModSounds;
import net.minecraft.block.SoundType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

public class CarEntity extends HorseEntity  {
    public CarEntity(EntityType<? extends HorseEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static void setAttributes(EntityAttributeCreationEvent event) {
        AttributeModifierMap attributes = MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 200)
                .createMutableAttribute(Attributes.MAX_HEALTH, 200000.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D)
                .createMutableAttribute(Attributes.HORSE_JUMP_STRENGTH, 0)
                .create();
        event.put(ModEntities.CAR.get(), attributes);
    }

    @Override
    protected void playGallopSound(SoundType p_190680_1_) {
        if (this.rand.nextInt(2) == 0) {
            this.playSound(ModSounds.CAR_SOUND.get(),p_190680_1_.getVolume() * 1.5F, p_190680_1_.getPitch());
        }
    }
}
