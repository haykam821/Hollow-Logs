package io.github.haykam821.hollowlogs.block;

import io.github.haykam821.hollowlogs.Main;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum LogTypes {
	OAK("minecraft", "oak", Blocks.OAK_LOG, MaterialColor.WOOD),
	SPRUCE("minecraft", "spruce", Blocks.SPRUCE_LOG, MaterialColor.SPRUCE),
	BIRCH("minecraft", "birch", Blocks.BIRCH_LOG, MaterialColor.SAND),
	JUNGLE("minecraft", "jungle", Blocks.JUNGLE_LOG, MaterialColor.DIRT),
	ACACIA("minecraft", "acacia", Blocks.ACACIA_LOG, MaterialColor.ORANGE),
	DARK_OAK("minecraft", "dark_oak", Blocks.DARK_OAK_LOG, MaterialColor.BROWN),

	WARPED("minecraft", "warped", Blocks.WARPED_STEM, MaterialColor.LIGHT_BLUE, true),
	CRIMSON("minecraft", "crimson", Blocks.CRIMSON_STEM, MaterialColor.ORANGE, true),

	REDWOOD("terrestria", "redwood", Blocks.OAK_LOG, MaterialColor.RED_TERRACOTTA),
	HEMLOCK("terrestria", "hemlock", Blocks.OAK_LOG, MaterialColor.BROWN),
	RUBBER("terrestria", "rubber", Blocks.OAK_LOG, MaterialColor.WHITE_TERRACOTTA),
	CYPRESS("terrestria", "cypress", Blocks.OAK_LOG, MaterialColor.WHITE_TERRACOTTA),
	WILLOW("terrestria", "willow", Blocks.OAK_LOG, MaterialColor.WHITE_TERRACOTTA),
	JAPANESE_MAPLE("terrestria", "japanese_maple", Blocks.OAK_LOG, MaterialColor.BROWN),
	RAINBOW_EUCALYPTUS("terrestria", "rainbow_eucalyptus", Blocks.OAK_LOG, MaterialColor.BLUE),

	DEADWOOD("thehallow", "deadwood", Blocks.OAK_LOG, MaterialColor.PURPLE),

	FIR("traverse", "fir", Blocks.OAK_LOG, MaterialColor.BROWN);

	private LogTypes(String mod, String type, Block base, MaterialColor endColor, boolean isStem) {
		if (!FabricLoader.getInstance().isModLoaded(mod)) return;

		Identifier id = new Identifier(Main.MOD_ID, type + "_hollow_" + (isStem ? "stem" : "log"));
		Block block = new HollowPillarBlock(endColor, FabricBlockSettings.copy(base).build());

		Registry.register(Registry.BLOCK, id, block);
		Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}

	private LogTypes(String mod, String type, Block base, MaterialColor endColor) {
		this(mod, type, base, endColor, false);
	}

	public static LogTypes initialize() {
		return null;
	}
}