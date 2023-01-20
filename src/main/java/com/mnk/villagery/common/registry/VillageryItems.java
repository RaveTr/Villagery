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
	
	public static RegistryObject<Item> TEST_ITEM = registerVillageryItem("test_item_blah", () -> new Item(new Properties()));
	
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
