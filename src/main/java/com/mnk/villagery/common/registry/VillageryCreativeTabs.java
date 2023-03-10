package com.mnk.villagery.common.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.mnk.villagery.Villagery;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.RegistryObject;

public class VillageryCreativeTabs {
	public static CreativeModeTab VILLAGERY_BLOCKS;
	public static CreativeModeTab VILLAGERY_GEAR;
	public static CreativeModeTab VILLAGERY_ITEMS;
	// Allow for more versatility when registering an item to a tab
	public static final HashMap<CreativeModeTab, Item> TAB_MAP = new HashMap<CreativeModeTab, Item>();
	
	public static void registerTabs(CreativeModeTabEvent.Register event) {
		VILLAGERY_BLOCKS = registerTabInOrder(event, "villagery_blocks", Blocks.ACACIA_BUTTON.asItem(), VILLAGERY_BLOCKS, CreativeModeTabs.BUILDING_BLOCKS, getItemsFromRegistryToTab(VillageryBlocks.VILLAGERY_BLOCK_ITEMS.getEntries()));
		VILLAGERY_GEAR = registerTabInOrder(event, "villagery_gear", Blocks.ACACIA_SIGN.asItem(), VILLAGERY_GEAR, VILLAGERY_BLOCKS, getItemsFromRegistryToTab(VillageryItems.VILLAGERY_GEAR.getEntries()));
		VILLAGERY_ITEMS = registerTabInOrder(event, "villagery_items", Blocks.ACACIA_LOG.asItem(), VILLAGERY_ITEMS, VILLAGERY_GEAR, getItemsFromRegistryToTab(VillageryItems.VILLAGERY_ITEMS.getEntries()));
	}
	
	public static void registerTabContents(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab().equals(VILLAGERY_BLOCKS)) event.acceptAll(getItemsFromRegistryToTab(VillageryBlocks.VILLAGERY_BLOCK_ITEMS.getEntries()));
		if (event.getTab().equals(VILLAGERY_GEAR)) event.acceptAll(getItemsFromRegistryToTab(VillageryItems.VILLAGERY_GEAR.getEntries()));
		if (event.getTab().equals(VILLAGERY_ITEMS)) event.acceptAll(getItemsFromRegistryToTab(VillageryItems.VILLAGERY_ITEMS.getEntries()));
	}
	
	private static CreativeModeTab registerTabInOrder(final CreativeModeTabEvent.Register event, String registryName, Item iconItem, CreativeModeTab regTab, CreativeModeTab followingTab, Collection<ItemStack> content) {
		CreativeModeTab tab = event.registerCreativeModeTab(Villagery.prefix(registryName), List.of(), List.of(followingTab), b -> {
			b.title(getTranslatableComponent("itemGroup.".concat(Villagery.MODID).concat(".").concat(registryName)))
			 .icon(() -> new ItemStack(iconItem))
			 .displayItems((fFlag, creativeTab, isOP) -> creativeTab.acceptAll(content))
			 .build();
		});
		return tab;
	}
	
	private static ObjectArrayList<ItemStack> getItemsFromRegistryToTab(Collection<RegistryObject<Item>> registry) {
		ObjectArrayList<ItemStack> acceptanceList = new ObjectArrayList<ItemStack>();
		for (RegistryObject<Item> entry : registry) {
			acceptanceList.add(entry.get().getDefaultInstance());
		} 
		return acceptanceList;
	}
	
	private static MutableComponent getTranslatableComponent(String entry) {
		MutableComponent tComp = Component.translatable(entry);	
		return tComp;
	}
	
	public static ObjectArrayList<CreativeModeTab> getPresentTabs() {
		ObjectArrayList<CreativeModeTab> tabs = new ObjectArrayList<CreativeModeTab>();
		// Safety check
		if (tabs.isEmpty()) tabs.addAll(ObjectArrayList.of(VILLAGERY_BLOCKS, VILLAGERY_GEAR, VILLAGERY_ITEMS));
		
		return tabs;
	}
}