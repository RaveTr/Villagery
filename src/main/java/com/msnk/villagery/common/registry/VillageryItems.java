package com.msnk.villagery.common.registry;

import com.mnk.villagery.Villagery;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VillageryItems {	
	public static final DeferredRegister<Item> VILLAGERY_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Villagery.MODID);
	public static final DeferredRegister<Item> VILLAGERY_GEAR = DeferredRegister.create(ForgeRegistries.ITEMS, Villagery.MODID);
	
	
}
