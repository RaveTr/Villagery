package com.msnk.villagery;

import java.util.Optional;

import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.msnk.villagery.manager.VillageryEventsManager;
import com.msnk.villagery.manager.VillageryRegistryManager;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.language.IModInfo;
import software.bernie.geckolib.GeckoLib;

@Mod(Villagery.MODID)
public class Villagery {
	public static final String MODNAME = "Villagery";
    public static final String MODID = "villagery";
    public static ArtifactVersion VERSION = null;
    public static Villagery INSTANCE;
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public Villagery() {
    	GeckoLib.initialize();
    	INSTANCE = this;
    	
		Optional<? extends ModContainer> villageryMod = ModList.get().getModContainerById(MODID);
		if (villageryMod.isPresent()) {
			IModInfo modInfo = villageryMod.get().getModInfo();
			VERSION = modInfo.getVersion();
		} else {
			LOGGER.warn("Couldn't get mod version from mod info..");
		}
		
		VillageryEventsManager.registerEvents();
		VillageryRegistryManager.registerRegistries();
		
		IEventBus forgeBus =  MinecraftForge.EVENT_BUS;
        forgeBus.register(this);
    }
}
