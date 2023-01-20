package com.mnk.villagery.common.registry;

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
	
	
	
	private static <B extends Block> RegistryObject<B> registerVillageryBlock(String name, Supplier<? extends B> blockSupplier) {
		return registerVillageryBlock(name, blockSupplier, 64, true);
	}
	
	private static <B extends Block> RegistryObject<B> registerVillageryBlock(String name, Supplier<? extends B> blockSupplier, int stackSize, boolean generateItem) {
		RegistryObject<B> block = VILLAGERY_BLOCKS.register(name, blockSupplier);
		if (generateItem) VILLAGERY_BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(stackSize)));
		return block;
	}
}
