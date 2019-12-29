package io.github.haykam821.hollowlogs;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.block.FabricBlockSettings;

public class Main implements ModInitializer {
	public static final Block OAK_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.WOOD, FabricBlockSettings.copy(Blocks.OAK_LOG).build());
	public static final Block SPRUCE_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.SPRUCE, FabricBlockSettings.copy(Blocks.SPRUCE_LOG).build());
	public static final Block BIRCH_HOLLOW_LOG =  new HollowPillarBlock(MaterialColor.SAND, FabricBlockSettings.copy(Blocks.BIRCH_LOG).build());
	public static final Block JUNGLE_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.DIRT, FabricBlockSettings.copy(Blocks.JUNGLE_LOG).build());
	public static final Block ACACIA_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.ORANGE, FabricBlockSettings.copy(Blocks.ACACIA_LOG).build());
	public static final Block DARK_OAK_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.BROWN, FabricBlockSettings.copy(Blocks.DARK_OAK_LOG).build());

	public static final Block REDWOOD_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.RED_TERRACOTTA, FabricBlockSettings.copy(Blocks.OAK_LOG).build());
	public static final Block HEMLOCK_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.BROWN, FabricBlockSettings.copy(Blocks.OAK_LOG).build());
	public static final Block RUBBER_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.WHITE_TERRACOTTA, FabricBlockSettings.copy(Blocks.OAK_LOG).build());
	public static final Block CYPRESS_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.WHITE_TERRACOTTA, FabricBlockSettings.copy(Blocks.OAK_LOG).build());
	public static final Block WILLOW_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.WHITE_TERRACOTTA, FabricBlockSettings.copy(Blocks.OAK_LOG).build());
	public static final Block JAPANESE_MAPLE_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.BROWN, FabricBlockSettings.copy(Blocks.OAK_LOG).build());
	public static final Block RAINBOW_EUCALYPTUS_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.BLUE, FabricBlockSettings.copy(Blocks.OAK_LOG).build());

	public static final Block FIR_HOLLOW_LOG = new HollowPillarBlock(MaterialColor.BROWN, FabricBlockSettings.copy(Blocks.OAK_LOG).build());

	static <T extends Block> T registerHollowLog(String name, T block) {
		T registered = Registry.register(Registry.BLOCK, new Identifier("hollowlogs", name), block);
		Registry.register(Registry.ITEM, new Identifier("hollowlogs", name), new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		
		return registered;
	}

	@Override
	public void onInitialize() {
		registerHollowLog("oak_hollow_log", OAK_HOLLOW_LOG);
		registerHollowLog("spruce_hollow_log", SPRUCE_HOLLOW_LOG);
		registerHollowLog("birch_hollow_log", BIRCH_HOLLOW_LOG);
		registerHollowLog("jungle_hollow_log", JUNGLE_HOLLOW_LOG);
		registerHollowLog("acacia_hollow_log", ACACIA_HOLLOW_LOG);
		registerHollowLog("dark_oak_hollow_log", DARK_OAK_HOLLOW_LOG);

		FabricLoader loader = FabricLoader.getInstance();

		// Terrestria integration
		if (loader.isModLoaded("terrestria")) {
			registerHollowLog("redwood_hollow_log", REDWOOD_HOLLOW_LOG);
			registerHollowLog("hemlock_hollow_log", HEMLOCK_HOLLOW_LOG);
			registerHollowLog("rubber_hollow_log", RUBBER_HOLLOW_LOG);
			registerHollowLog("cypress_hollow_log", CYPRESS_HOLLOW_LOG);
			registerHollowLog("willow_hollow_log", WILLOW_HOLLOW_LOG);
			registerHollowLog("japanese_maple_hollow_log", JAPANESE_MAPLE_HOLLOW_LOG);
			registerHollowLog("rainbow_eucalyptus_hollow_log", RAINBOW_EUCALYPTUS_HOLLOW_LOG);
		}
		
		// Traverse integration
		if (loader.isModLoaded("traverse")) {
			registerHollowLog("fir_hollow_log", FIR_HOLLOW_LOG);
		}
	}
}