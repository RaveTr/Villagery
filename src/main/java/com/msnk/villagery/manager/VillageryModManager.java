package com.msnk.villagery.manager;

public class VillageryModManager {
	
	public static void registerAll() {
		VillageryEventsManager.registerEvents();
		VillageryRegistryManager.registerRegistries();
		VillageryModIntegrationManager.registerModIntegration();
	}

}
