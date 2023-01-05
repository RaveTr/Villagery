package com.msnk.villagery.manager;

import com.mnk.villagery.Villagery;
import com.msnk.villagery.common.events.VillageryMiscEvents;
import com.msnk.villagery.common.events.VillagerySetupEvent;
import com.msnk.villagery.common.registry.VillageryCreativeTabs;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class VillageryEventsManager {
	
	public static void registerEvents() {		
		registerClientEvents(Villagery.MOD_BUS, Villagery.FORGE_BUS);
		registerCommonEvents(Villagery.MOD_BUS, Villagery.FORGE_BUS);
		registerServerEvents(Villagery.MOD_BUS, Villagery.FORGE_BUS);
	}
	
	private static void registerClientEvents(IEventBus modBus, IEventBus forgeBus) {
		if (FMLEnvironment.dist.equals(Dist.CLIENT)) {
			
		}
	}
	
	private static void registerCommonEvents(IEventBus modBus, IEventBus forgeBus) {
		modBus.addListener(VillagerySetupEvent::onFMLCommonSetup);
		modBus.addListener(VillagerySetupEvent::onDataGen);
		modBus.addListener(VillageryCreativeTabs::registerTabs);
		modBus.addListener(VillageryCreativeTabs::registerTabContents);
		forgeBus.addListener(VillageryMiscEvents::onWorldTick);
		forgeBus.addListener(VillageryMiscEvents::onLivingHurt);
	}
	
	private static void registerServerEvents(IEventBus modBus, IEventBus forgeBus) {
		if (FMLEnvironment.dist.equals(Dist.DEDICATED_SERVER)) {
			
		}
	}

}
