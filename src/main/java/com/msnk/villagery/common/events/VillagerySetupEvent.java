package com.msnk.villagery.common.events;

import com.msnk.villagery.common.network.VillageryNetworkManager;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class VillagerySetupEvent {
	
	public static void onFMLCommonSetup(final FMLCommonSetupEvent event) {
		VillageryNetworkManager.register();
		
		event.enqueueWork(() -> {
			
		});
	}

}
