package com.msnk.villagery.common.events;

import com.msnk.villagery.common.network.VillageryNetworkManager;
import com.msnk.villagery.data.VillageryLanguageProvider;

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
