package com.msnk.villagery.manager;

import com.msnk.villagery.common.events.VillagerySetupEvent;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class VillageryEventsManager {
	
	public static void registerEvents() {
		IEventBus modBus =  FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeBus =  MinecraftForge.EVENT_BUS;
		
		registerClientEvents(modBus, forgeBus);
		registerCommonEvents(modBus, forgeBus);
		registerServerEvents(modBus, forgeBus);
	}
	
	private static void registerClientEvents(IEventBus modBus, IEventBus forgeBus) {
		if (FMLEnvironment.dist.equals(Dist.CLIENT)) {
			
		}
	}
	
	private static void registerCommonEvents(IEventBus modBus, IEventBus forgeBus) {
		modBus.addListener(VillagerySetupEvent::onFMLCommonSetup);
	}
	
	private static void registerServerEvents(IEventBus modBus, IEventBus forgeBus) {
		if (FMLEnvironment.dist.equals(Dist.DEDICATED_SERVER)) {
			
		}
	}

}
