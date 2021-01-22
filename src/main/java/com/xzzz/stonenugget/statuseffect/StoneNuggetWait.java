package com.xzzz.stonenugget.statuseffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class StoneNuggetWait extends StatusEffect {
    public StoneNuggetWait() {
        super(
                StatusEffectType.BENEFICIAL,
                0xADD8E6
        );
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        Iterator var4 = this.getAttributeModifiers().entrySet().iterator();
        Random r = new Random();
        int effect = r.nextInt(28) + 1;
        switch (effect) {
            case 1: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,1200, 4));break;
            case 2: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,400, 0));break;
            case 3: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,3600, 0));break;
            case 4: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,7200, 0));break;
            case 5: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,1200, 2));break;
            case 6: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,1200, 2));break;
            case 7: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER,600, 2));break;
            case 8: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,1, 5));break;
            case 9: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,1, 5));break;
            case 10: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY,3600, 0));break;
            case 11: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,1200, 2));break;
            case 12: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,600, 9));break;
            case 13: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK,3600, 2));break;
            case 14: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE,1200, 2));break;
            case 15: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,3600, 0));break;
            case 16: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,3600, 0));break;
            case 17: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,600, 2));break;
            case 18: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,600, 2));break;
            case 19: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,1200, 3));break;
            case 20: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION,600, 2));break;
            case 21: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,1200, 0));break;
            case 22: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,1200, 2));break;
            case 23: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,1200, 2));break;
            case 24: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,2400, 1));break;
            case 25: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK,3600, 2));break;
            case 26: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,3600, 0));break;
            case 27: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,2400, 1));break;
            case 28: entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,300, 1));break;
        }


        while(var4.hasNext()) {
            Map.Entry<EntityAttribute, EntityAttributeModifier> entry = (Map.Entry)var4.next();
            EntityAttributeInstance entityAttributeInstance = attributes.getCustomInstance((EntityAttribute)entry.getKey());
            if (entityAttributeInstance != null) {
                entityAttributeInstance.removeModifier((EntityAttributeModifier)entry.getValue());
            }
        }

    }
}
