package com.mnk.villagery.common.registry;

import javax.annotation.Nonnull;

import com.google.common.base.Supplier;
import com.mnk.villagery.Villagery;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VillageryItems {	
	public static final DeferredRegister<Item> VILLAGERY_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Villagery.MODID);
	public static final DeferredRegister<Item> VILLAGERY_GEAR = DeferredRegister.create(ForgeRegistries.ITEMS, Villagery.MODID);
	
	// Nuggets
	public static final RegistryObject<Item> ELECTRUM_NUGGET = registerVillageryItem("electrum_nugget", () -> new Item(new Properties()));
    public static final RegistryObject<Item> NICKEL_NUGGET  = registerVillageryItem("nickel_nugget", () -> new Item(new Properties()));
    public static final RegistryObject<Item> PLUTONIUM_NUGGET = registerVillageryItem("plutonium_nugget", () -> new Item(new Properties()));
    public static final RegistryObject<Item> RADIUM_NUGGET = registerVillageryItem("raidum_nugget", () -> new Item(new Properties()));
    public static final RegistryObject<Item> SILVER_NUGGET = registerVillageryItem("silver_nugget", () -> new Item(new Properties()));
    public static final RegistryObject<Item> STEEL_NUGGET = registerVillageryItem("steel_nugget", () -> new Item(new Properties()));
    public static final RegistryObject<Item> TIN_NUGGET = registerVillageryItem("tin_nugget", () -> new Item(new Properties()));
    public static final RegistryObject<Item> TITANIUM_NUGGET = registerVillageryItem("titanium_nugget", () -> new Item(new Properties()));
    public static final RegistryObject<Item> URANIUM_NUGGET = registerVillageryItem("uranium_nugget", () -> new Item(new Properties()));
	
	// Ingots
	public static final RegistryObject<Item> ELECTRUM_INGOT = registerVillageryItem("electrum_ingot", () -> new Item(new Properties()));
    public static final RegistryObject<Item> NICKEL_INGOT  = registerVillageryItem("nickel_ingot", () -> new Item(new Properties()));
    public static final RegistryObject<Item> PLUTONIUM_INGOT = registerVillageryItem("plutonium_ingot", () -> new Item(new Properties()));
    public static final RegistryObject<Item> RADIUM_INGOT = registerVillageryItem("raidum_ingot", () -> new Item(new Properties()));
    public static final RegistryObject<Item> SILVER_INGOT = registerVillageryItem("silver_ingot", () -> new Item(new Properties()));
    public static final RegistryObject<Item> STEEL_INGOT = registerVillageryItem("steel_ingot", () -> new Item(new Properties()));
    public static final RegistryObject<Item> TIN_INGOT = registerVillageryItem("tin_ingot", () -> new Item(new Properties()));
    public static final RegistryObject<Item> TITANIUM_INGOT = registerVillageryItem("titanium_ingot", () -> new Item(new Properties()));
    public static final RegistryObject<Item> URANIUM_INGOT = registerVillageryItem("uranium_ingot", () -> new Item(new Properties()));
    
    // Electrum Gear
    
    
    // Nickel Gear
    
    // Plutonium Gear
    
    // Radium Gear
    
    // Silver Gear
    
    // Steel Gear
    
    // Tin Gear
    
    // Titanium Gear
    
    // Uranium Gear
	
	private static <I extends Item> RegistryObject<I> registerItem(String name, Supplier<? extends I> itemSupplier, @Nonnull DeferredRegister<Item> registry) {
		RegistryObject<I> itemEntry = registry.register(name, itemSupplier);
		return itemEntry;
	}
	
	private static <I extends Item> RegistryObject<I> registerVillageryItem(String name, Supplier<? extends I> itemSupplier) {
		return registerItem(name, itemSupplier, VILLAGERY_ITEMS);
	}
	
	private static <I extends Item> RegistryObject<I> registerVillageryGearItem(String name, Supplier<? extends I> itemSupplier) {
		return registerItem(name, itemSupplier, VILLAGERY_GEAR);
	}
}
