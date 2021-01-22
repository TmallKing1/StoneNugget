package com.xzzz.stonenugget.item;

import com.xzzz.stonenugget.Main;
import com.xzzz.stonenugget.Registries;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;


public class StoneNugget extends Item {
    public static final FoodComponent food_stone_nugget = new FoodComponent.Builder()
            .alwaysEdible()
            .hunger(8)
            .saturationModifier(20)
            .build();
    public StoneNugget(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.stonenugget.stone_nugget.tooltip.1").setStyle(Main.style));
        tooltip.add(new TranslatableText("item.stonenugget.stone_nugget.tooltip.2").setStyle(Main.style));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.addStatusEffect(new StatusEffectInstance(Registries.stone_nugget_wait,1));
        return this.isFood() ? user.eatFood(world, stack) : stack;
    }
}
