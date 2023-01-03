package com.msnk.villagery.common.registry;

import com.google.common.base.Supplier;
import com.mnk.villagery.Villagery;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VillageryBlocks {
	public static final DeferredRegister<Block> VILLAGERY_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Villagery.MODID);
	public static final DeferredRegister<Item> VILLAGERY_BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Villagery.MODID);
	
	
	
	
	public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier) {
		return registerBlock(name, supplier, 64, true);
	}
	
	public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, int stackSize, boolean generateItem) {
		RegistryObject<B> block = VILLAGERY_BLOCKS.register(name, supplier);
		if (generateItem) VILLAGERY_BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(stackSize)));
		return block;
	}
}
