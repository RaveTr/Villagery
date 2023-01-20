package com.mnk.villagery.common.events;

import com.mnk.villagery.common.network.VillageryNetworkManager;
import com.mnk.villagery.data.VillageryLanguageProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class VillagerySetupEvent {
	
	public static void onFMLCommonSetup(final FMLCommonSetupEvent event) {
		VillageryNetworkManager.register();
		
		event.enqueueWork(() -> {
			
		});
	}
	
	public static void onDataGen(final GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		final ExistingFileHelper existing = event.getExistingFileHelper();
		if (event.includeClient()) {
		}
		dataGenerator.addProvider(true, new VillageryLanguageProvider(dataGenerator.getPackOutput()));
		if (event.includeServer()) {
		}
	}

}
