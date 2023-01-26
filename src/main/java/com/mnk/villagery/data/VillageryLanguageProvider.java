package com.mnk.villagery.data;

import com.mnk.villagery.Villagery;
import com.mnk.villagery.common.registry.VillageryBlocks;
import com.mnk.villagery.common.registry.VillageryCreativeTabs;
import com.mnk.villagery.common.registry.VillageryItems;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class VillageryLanguageProvider extends LanguageProvider {

	public VillageryLanguageProvider(PackOutput output) {
		super(output, Villagery.MODID, "en_us");
	}
	
	@Override
	public String getName() {
		return super.getName();
	}
	
	private static ObjectArrayList<String> getLowerCaseListedWords() {
		ObjectArrayList<String> lcw = new ObjectArrayList<String>();
		
		lcw.addAll(ObjectArrayList.of("Of", "And"));
		
		return lcw;
	}
	
	//https://stackoverflow.com/questions/1892765/how-to-capitalize-the-first-character-of-each-word-in-a-string
	private static String formatString(String input) {
		char[] charSet = input.toLowerCase().toCharArray();
		boolean found = false;
		for (int i = 0; i < charSet.length - 1; i++) {
			if (!found && Character.isLetter(charSet[i])) {
				charSet[i] = Character.toUpperCase(charSet[i]);
				found = true;
			} else if (Character.isWhitespace(charSet[i]) || charSet[i] == '.' || charSet[i] == '_') {
				found = false;
			}
		}
		
		String baseResult = String.valueOf(charSet);
		
		for (String lcw : getLowerCaseListedWords()) if (baseResult.contains(lcw)) baseResult = baseResult.replaceAll(lcw, lcw.toLowerCase());
		
		return baseResult;
	}
	
	private void localizeGeneralRegistryNames(String registryName) {		
		if (registryName.isBlank() || registryName.isEmpty() || registryName == null) return;
		if (!registryName.contains(".")) return;
		
		String regNameTemp = registryName;
		String formatted = formatString(regNameTemp);
		String regName = formatted.substring(formatted.lastIndexOf(".") + 1).replaceAll("_", " ");
		
		add(registryName, regName);
	}
	
	private void translateItems() {
		for (RegistryObject<Item> itemRegEntry : VillageryItems.VILLAGERY_GEAR.getEntries()) {
			Item item = itemRegEntry.get();
			String registryName = item.getDescriptionId();
			
			localizeGeneralRegistryNames(registryName);
		}
		
		for (RegistryObject<Item> itemRegEntry : VillageryItems.VILLAGERY_ITEMS.getEntries()) {
			Item item = itemRegEntry.get();
			String registryName = item.getDescriptionId();
			
			localizeGeneralRegistryNames(registryName);
		}
	}
	
	private void translateBlocks() {
		for (RegistryObject<Block> blockGenEntry : VillageryBlocks.VILLAGERY_BLOCKS.getEntries()) {
			Block block = blockGenEntry.get();
			String registryName = block.getDescriptionId();
			
			localizeGeneralRegistryNames(registryName);
		}
	}
	
	private void translateEntities() {
		
	}
	
	private void translateCreativeTabs() {
		for (CreativeModeTab tabEntry : VillageryCreativeTabs.getPresentTabs()) {
			String registryName = tabEntry.getDisplayName().toString();
			int endCharIndex = registryName.indexOf("',");
			registryName = registryName.substring(17, endCharIndex);
			
			localizeGeneralRegistryNames(registryName);
		}
	}
	
	private void translateAll() {
		translateBlocks();
		translateCreativeTabs();
		translateEntities();
		translateItems();
	}

	@Override
	protected void addTranslations() {	
		translateAll();
	}

}
