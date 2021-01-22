package com.xzzz.stonenugget.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class StonetheriteMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 2501;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11.0F;
    }

    @Override
    public float getAttackDamage() {
        return 5.0F;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
