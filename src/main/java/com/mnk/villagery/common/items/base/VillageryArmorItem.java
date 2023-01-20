package com.mnk.villagery.common.items.base;

import java.util.List;

import com.mnk.villagery.Villagery;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class VillageryArmorItem extends ArmorItem {

	public VillageryArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
		super(pMaterial, pSlot, pProperties);
	}
	
	public String getPrunedRegistryName() {
		String regName = getDescriptionId();		
		regName = regName.substring(regName.lastIndexOf("."));		
		return regName;
	}
	
	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
		super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
		
		pTooltipComponents.add(Component.translatable("tooltip.".concat(Villagery.MODID).concat(getPrunedRegistryName())));
	}

}
