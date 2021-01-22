package com.xzzz.stonenugget;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;


public class Main implements ModInitializer {
	public static final String MODID = "stonenugget";
	public static final Style style = Style.EMPTY.withColor(Formatting.GRAY);
	public static final ItemGroup STONE_NUGGET = FabricItemGroupBuilder.create(
			new Identifier("stonenugget","stone_nugget"))
			.icon(() -> new ItemStack(Registries.stone_nugget))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(Registries.stone_dust_ore));
				stacks.add(new ItemStack(Registries.stone_dust));
				stacks.add(new ItemStack(Registries.stone_nugget));
				stacks.add(new ItemStack(Registries.stone_ingot));
				stacks.add(new ItemStack(Registries.absolutely_smooth_stone));
			})
			.build();

	@Override
	public void onInitialize() {
		Registries.Register();
	}
}
