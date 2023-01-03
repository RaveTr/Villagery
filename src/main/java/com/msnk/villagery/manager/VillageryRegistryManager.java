package com.msnk.villagery.manager;

import com.mnk.villagery.Villagery;
import com.msnk.villagery.common.registry.VillageryBlocks;
import com.msnk.villagery.common.registry.VillageryItems;

public class VillageryRegistryManager {
	
	public static void registerRegistries() {
		VillageryItems.VILLAGERY_GEAR.register(Villagery.MOD_BUS);
		VillageryItems.VILLAGERY_ITEMS.register(Villagery.MOD_BUS);
		VillageryBlocks.VILLAGERY_BLOCK_ITEMS.register(Villagery.MOD_BUS);
		VillageryBlocks.VILLAGERY_BLOCKS.register(Villagery.MOD_BUS);
	}
}
