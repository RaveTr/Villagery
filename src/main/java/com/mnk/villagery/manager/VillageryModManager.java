package com.mnk.villagery.manager;

import com.mnk.villagery.Villagery;

public class VillageryModManager {
	
	public static void registerAll() {
		VillageryEventsManager.registerEvents();
		VillageryRegistryManager.registerRegistries();
		VillageryModIntegrationManager.registerModIntegration();
		Villagery.FORGE_BUS.register(Villagery.INSTANCE);
	}

}
