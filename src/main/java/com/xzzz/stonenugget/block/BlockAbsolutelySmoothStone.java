package com.xzzz.stonenugget.block;

import com.xzzz.stonenugget.Main;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class BlockAbsolutelySmoothStone extends OreBlock {

    public BlockAbsolutelySmoothStone(Settings settings) {
        super(settings);
    }
}
