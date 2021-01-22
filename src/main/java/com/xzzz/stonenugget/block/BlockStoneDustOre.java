package com.xzzz.stonenugget.block;

import com.xzzz.stonenugget.Main;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;

import java.util.List;
import java.util.Random;

public class BlockStoneDustOre extends OreBlock {

    public BlockStoneDustOre(Settings settings) {
        super(settings);
    }

    @Override
    protected int getExperienceWhenMined(Random random) {
        return MathHelper.nextInt(random, 5, 10);
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new TranslatableText("block.stonenugget.stone_dust_ore.tooltip").setStyle(Main.style));
    }
}
