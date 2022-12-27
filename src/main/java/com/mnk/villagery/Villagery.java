package com.mnk.villagery;

import java.util.Optional;

import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.language.IModInfo;
import software.bernie.geckolib.GeckoLib;

@Mod(Villagery.MODID)
public class Villagery {
	public static final String MODNAME = "Villagery";
    public static final String MODID = "villagery";
    public static Villagery INSTANCE;
	public static ArtifactVersion VERSION = null;
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
    	
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus =  MinecraftForge.EVENT_BUS;
        
        forgeBus.register(this);
    }
}
