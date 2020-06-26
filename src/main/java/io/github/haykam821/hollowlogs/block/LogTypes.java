package io.github.haykam821.hollowlogs.block;

import io.github.haykam821.hollowlogs.Main;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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
	OAK("minecraft", "oak", Blocks.OAK_LOG),
	SPRUCE("minecraft", "spruce", Blocks.SPRUCE_LOG),
	BIRCH("minecraft", "birch", Blocks.BIRCH_LOG),
	JUNGLE("minecraft", "jungle", Blocks.JUNGLE_LOG),
	ACACIA("minecraft", "acacia", Blocks.ACACIA_LOG),
	DARK_OAK("minecraft", "dark_oak", Blocks.DARK_OAK_LOG),

	WARPED("minecraft", "warped", Blocks.WARPED_STEM, true),
	CRIMSON("minecraft", "crimson", Blocks.CRIMSON_STEM, true),

	REDWOOD("terrestria", "redwood", Blocks.OAK_LOG),
	HEMLOCK("terrestria", "hemlock", Blocks.OAK_LOG),
	RUBBER("terrestria", "rubber", Blocks.OAK_LOG),
	CYPRESS("terrestria", "cypress", Blocks.OAK_LOG),
	WILLOW("terrestria", "willow", Blocks.OAK_LOG),
	JAPANESE_MAPLE("terrestria", "japanese_maple", Blocks.OAK_LOG),
	RAINBOW_EUCALYPTUS("terrestria", "rainbow_eucalyptus", Blocks.OAK_LOG),

	DEADWOOD("thehallow", "deadwood", Blocks.OAK_LOG),

	FIR("traverse", "fir", Blocks.OAK_LOG),

	WHITE_OAK("blockus", "white_oak", Blocks.BIRCH_LOG),

	SCORCHED("cinderscapes", "scorched", FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.LIGHT_GRAY), true),
	UMBRAL("cinderscapes", "umbral", FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.BLUE), true),

	PINE("woods_and_mires", "pine", Blocks.OAK_LOG);

	private LogTypes(String mod, String type, Block.Settings blockSettings, boolean isStem) {
		if (!FabricLoader.getInstance().isModLoaded(mod)) return;

		Identifier id = new Identifier(Main.MOD_ID, type + "_hollow_" + (isStem ? "stem" : "log"));
		Block block = new HollowPillarBlock(blockSettings);

		Registry.register(Registry.BLOCK, id, block);
		Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}

	private LogTypes(String mod, String type, Block.Settings blockSettings) {
		this(mod, type, blockSettings, false);
	}

	private LogTypes(String mod, String type, Block base, boolean isStem) {
		this(mod, type, FabricBlockSettings.copy(base), isStem);
	}

	private LogTypes(String mod, String type, Block base) {
		this(mod, type, base, false);
	}

	public static LogTypes initialize() {
		return null;
	}
}