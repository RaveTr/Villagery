package com.mnk.villagery.common.registry;

import com.google.common.base.Supplier;
import com.mnk.villagery.Villagery;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VillageryBlocks {
	public static final DeferredRegister<Block> VILLAGERY_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Villagery.MODID);
	public static final DeferredRegister<Item> VILLAGERY_BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Villagery.MODID);
	
	// Base Material Blocks
	public static final RegistryObject<Block> ELECTRUM_BLOCK = registerVillageryBlock("block_of_electrum", () -> new Block(Properties.of(Material.METAL)));
    public static final RegistryObject<Block> NICKEL_INGOT  = registerVillageryBlock("block_of_nickel", () -> new Block(Properties.of(Material.METAL)));
    public static final RegistryObject<Block> PLUTONIUM_INGOT = registerVillageryBlock("block_of_plutonium", () -> new Block(Properties.of(Material.METAL)));
    public static final RegistryObject<Block> RADIUM_INGOT = registerVillageryBlock("block_of_raidum", () -> new Block(Properties.of(Material.METAL)));
    public static final RegistryObject<Block> SILVER_INGOT = registerVillageryBlock("block_of_silver", () -> new Block(Properties.of(Material.METAL)));
    public static final RegistryObject<Block> STEEL_INGOT = registerVillageryBlock("block_of_steel", () -> new Block(Properties.of(Material.METAL)));
    public static final RegistryObject<Block> TIN_INGOT = registerVillageryBlock("block_of_tin", () -> new Block(Properties.of(Material.METAL)));
    public static final RegistryObject<Block> TITANIUM_INGOT = registerVillageryBlock("block_of_titanium", () -> new Block(Properties.of(Material.HEAVY_METAL)));
    public static final RegistryObject<Block> URANIUM_INGOT = registerVillageryBlock("block_of_uranium", () -> new Block(Properties.of(Material.HEAVY_METAL)));
	
	private static <B extends Block> RegistryObject<B> registerVillageryBlock(String name, Supplier<? extends B> blockSupplier) {
		return registerVillageryBlock(name, blockSupplier, 64, true);
	}
	
	private static <B extends Block> RegistryObject<B> registerVillageryBlock(String name, Supplier<? extends B> blockSupplier, int stackSize, boolean generateItem) {
		RegistryObject<B> block = VILLAGERY_BLOCKS.register(name, blockSupplier);
		if (generateItem) VILLAGERY_BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(stackSize)));
		return block;
	}
}
