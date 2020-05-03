package io.github.haykam821.hollowlogs;

import io.github.haykam821.hollowlogs.block.LogTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class Main implements ModInitializer {
	public static final String MOD_ID = "hollowlogs";
	public static final FabricLoader LOADER = FabricLoader.getInstance();
	
	@Override
	public void onInitialize() {
		LogTypes.initialize();
	}
}