package com.xzzz.stonenugget;

import com.xzzz.stonenugget.block.BlockAbsolutelySmoothStone;
import com.xzzz.stonenugget.block.BlockStoneDustOre;
import com.xzzz.stonenugget.item.StoneDust;
import com.xzzz.stonenugget.item.StoneNugget;
import com.xzzz.stonenugget.statuseffect.StoneNuggetWait;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class Registries {
    //Item
    public static final StoneNugget stone_nugget = new StoneNugget(new FabricItemSettings().food(StoneNugget.food_stone_nugget));
    public static final StoneDust stone_dust = new StoneDust(new FabricItemSettings());
    public static final Item stonetherite_ingot = new Item(new FabricItemSettings().fireproof());
    public static final Item stone_ingot = new Item(new FabricItemSettings());
    //Block
    public static final BlockStoneDustOre stone_dust_ore = new BlockStoneDustOre(FabricBlockSettings.of(Material.STONE).strength(4.0f).breakByTool(FabricToolTags.PICKAXES,4).requiresTool());
    public static final BlockAbsolutelySmoothStone absolutely_smooth_stone = new BlockAbsolutelySmoothStone(FabricBlockSettings.of(Material.STONE).strength(1.0f).breakByTool(FabricToolTags.PICKAXES,0).requiresTool().slipperiness(1.1f));
    //Status Effect
    public static final StatusEffect stone_nugget_wait = new StoneNuggetWait();
    private static final ConfiguredFeature<?, ?> ORE_STONE_DUST_END = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    stone_dust_ore.getDefaultState(),
                    4))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    64)))
            .spreadHorizontally()
            .repeat(4);


    public static void Register(){
        Registry.register(Registry.ITEM, new Identifier("stonenugget","stone_dust"),stone_dust);
        Registry.register(Registry.ITEM, new Identifier("stonenugget","stone_nugget"),stone_nugget);
        Registry.register(Registry.ITEM, new Identifier("stonenugget","stone_ingot"),stone_ingot);

        Registry.register(Registry.BLOCK, new Identifier("stonenugget","stone_dust_ore"),stone_dust_ore);
        Registry.register(Registry.BLOCK, new Identifier("stonenugget","absolutely_smooth_stone"),absolutely_smooth_stone);

        Registry.register(Registry.ITEM, new Identifier("stonenugget", "stone_dust_ore"), new BlockItem(stone_dust_ore, new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("stonenugget", "absolutely_smooth_stone"), new BlockItem(absolutely_smooth_stone, new Item.Settings()));

        Registry.register(Registry.STATUS_EFFECT, new Identifier("stonenugget", "stone_nugget_wait"), stone_nugget_wait);
        RegistryKey<ConfiguredFeature<?, ?>> oreWoolEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("stonenugget", "ore_stone_dust_end"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreWoolEnd.getValue(), ORE_STONE_DUST_END);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreWoolEnd);
    }
}
