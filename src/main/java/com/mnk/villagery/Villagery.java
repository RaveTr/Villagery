package com.mnk.villagery;

import java.util.Optional;

import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.slf4j.Logger;

import com.mnk.villagery.manager.VillageryModManager;
import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.language.IModInfo;

@Mod(Villagery.MODID)
public class Villagery {
	public static final String MODNAME = "Villagery";
    public static final String MODID = "villagery";
    public static ArtifactVersion VERSION = null;
    public static Villagery INSTANCE;
    private static final Logger LOGGER = LogUtils.getLogger();
    public static IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();
    public static IEventBus FORGE_BUS = MinecraftForge.EVENT_BUS;
    
    public Villagery() {
    	INSTANCE = this;
    	
		Optional<? extends ModContainer> villageryMod = ModList.get().getModContainerById(MODID);
		if (villageryMod.isPresent()) {
			IModInfo modInfo = villageryMod.get().getModInfo();
			VERSION = modInfo.getVersion();
		} else {
			LOGGER.warn("Couldn't get mod version from mod info..");
		}
		
		if (MOD_BUS != null && FORGE_BUS != null) VillageryModManager.registerAll();
		
    }
    
    public static ResourceLocation prefix(String entry) {
    	return new ResourceLocation(Villagery.MODID, entry);
    }
    
    public static Logger getLogger() {
    	return LOGGER;
    }
}
