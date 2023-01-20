package com.mnk.villagery.common.items.tiers;

import java.util.List;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

import com.google.common.base.Supplier;
import com.mnk.villagery.Villagery;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.registries.RegistryObject;

public class VillageryTier implements Tier {
	private final ResourceLocation regName;
	private int durability;
	private float speed;
	private float attackDamage;
	private int miningLevel;
	private int enchantability;
	private Supplier<Ingredient> repairIngredient;
	private TagKey<Block> blockTierTag;
	private List<Tier> worseTierTypes = new ObjectArrayList<Tier>();
	private List<Tier> betterTierTypes = new ObjectArrayList<Tier>();
	
	public VillageryTier(String regName) {
		this.regName = Villagery.prefix(regName);
	}
	
	public ResourceLocation getTierRegName() {
		return regName;
	}

	@Override
	public int getUses() {
		return durability;
	}

	@Override
	public float getSpeed() {
		return speed;
	}

	@Override
	public float getAttackDamageBonus() {
		return attackDamage;
	}

	@Override
	public int getLevel() {
		return miningLevel;
	}

	@Override
	public int getEnchantmentValue() {
		return enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairIngredient.get();
	}
	
	@Override
	public @Nullable TagKey<Block> getTag() {
		return blockTierTag;
	}
	
	public List<Tier> getWorseTierTypes() {
		return worseTierTypes;
	}
	
	public List<Tier> getBetterTierTypes() {
		return betterTierTypes;
	}
	
	public VillageryTier setDurability(int durability) {
		this.durability = durability;
		
		return this;
	}
	
	public VillageryTier setSpeed(float speed) {
		this.speed = speed;
		
		return this;
	}
	
	public VillageryTier setAttackDamage(float attackDamage) {
		this.attackDamage = attackDamage - 1;
		
		return this;
	}
	
	public VillageryTier setAttackDamageWithBonus(float attackDamage) {
		this.attackDamage = attackDamage;
		
		return this;
	}
	
	public VillageryTier setAttackDamageBareHurt() {
		setAttackDamage(0);
		
		return this;
	}
	
	public VillageryTier setAttackDamageNoHurt() {
		setAttackDamage(-1);
		
		return this;
	}
	
	public VillageryTier setMiningLevel(int miningLevel) {
		this.miningLevel = miningLevel;
		
		return this;
	}
	
	public VillageryTier setMiningLevelNoBreak() {
		setMiningLevel(-1);
		
		return this;
	}
	
	public VillageryTier setWoodMiningLevel() {
		setMiningLevel(0);
		
		return this;
	}
	
	public VillageryTier setStoneMiningLevel() {
		setMiningLevel(1);
		
		return this;
	}
	
	public VillageryTier setIronMiningLevel() {
		setMiningLevel(2);
		
		return this;
	}
	
	public VillageryTier setGoldMiningLevel() {
		setMiningLevel(3);
		
		return this;
	}
	
	public VillageryTier setDiamondMiningLevel() {
		setMiningLevel(4);
		
		return this;
	}
	
	public VillageryTier setNetheriteMiningLevel() {
		setMiningLevel(5);
		
		return this;
	}
	
	public VillageryTier setEnchantability(int enchantability) {
		this.enchantability = enchantability;
		
		return this;
	}
	
	public VillageryTier setNoEnchantability() {
		this.enchantability = 0;
		
		return this;
	}
	
	public VillageryTier setRepairIngredient(Supplier<Ingredient> repairIngredient) {
		this.repairIngredient = repairIngredient;
		
		return this;
	}
	
	public VillageryTier setRepairIngredient(RegistryObject<Item> repairIngredient) {
		setRepairIngredient(() -> Ingredient.of(repairIngredient.get()));
		
		return this;
	}
	
	public VillageryTier setRepairIngredient(Item repairIngredient) {
		setRepairIngredient(() -> Ingredient.of(repairIngredient));
		
		return this;
	}
	
	public VillageryTier setRepairIngredient(TagKey<Item> repairIngredient) {
		setRepairIngredient(() -> Ingredient.of(repairIngredient));
		
		return this;
	}
	
	public VillageryTier setRepairIngredient(Ingredient repairIngredient) {
		setRepairIngredient(() -> repairIngredient);
		
		return this;
	}
	
	public VillageryTier setNoRepairIngredient() {
		setRepairIngredient(() -> Ingredient.EMPTY);
		
		return this;
	}
	
	public VillageryTier setTierTag(TagKey<Block> blockTierTag) {
		this.blockTierTag = blockTierTag;
		
		return this;
	}
	
	public VillageryTier setStoneTierTag() {
		setTierTag(BlockTags.NEEDS_STONE_TOOL);
		
		return this;
	}
	
	public VillageryTier setIronTierTag() {
		setTierTag(BlockTags.NEEDS_IRON_TOOL);
		
		return this;
	}
	
	public VillageryTier setDiamondTierTag() {
		setTierTag(BlockTags.NEEDS_DIAMOND_TOOL);
		
		return this;
	}
	
	public VillageryTier copyTierPropertiesOfTier(@Nonnull VillageryTier tierType) {
		VillageryTier newTierType = new VillageryTier(getTierRegName().toString())
		.setAttackDamage(tierType.getAttackDamageBonus())
		.setMiningLevel(tierType.getLevel())
		.setSpeed(tierType.getSpeed())
		.setDurability(tierType.getUses())
		.setRepairIngredient(() -> tierType.getRepairIngredient())
		.setTierTag(tierType.getTag());	
		
		return newTierType;
	}
	
	public VillageryTier mergeTierTypes(@Nonnull VillageryTier... types) {
		VillageryTier newTierType = new VillageryTier(getTierRegName().toString());
		
		List<Ingredient> repairIngredients = new ObjectArrayList<Ingredient>();
		
		for (VillageryTier tierType : types) {
			repairIngredients.add(tierType.getRepairIngredient());
			
			// Gotta use the standard incrementing for loop :zad:
			for (int i = 0; i < repairIngredients.size() - 1; i++) {
				Ingredient rIng = repairIngredients.get(i);				
				for (int j = 0; j < rIng.getItems().length - 1; j++) {
					ItemStack repairStack = rIng.getItems()[j];
					ItemStack repairStackAfter = rIng.getItems()[j++];
					
					newTierType.setRepairIngredient(Ingredient.of(repairStack, repairStackAfter));
				}
			}
			
			newTierType.setAttackDamage(newTierType.getAttackDamageBonus() + tierType.getAttackDamageBonus())
			.setMiningLevel(newTierType.getLevel() + tierType.getLevel())
			.setSpeed(newTierType.getSpeed() + tierType.getSpeed())
			.setDurability(newTierType.getUses() + tierType.getUses())
			.setTierTag(compareTierTags(newTierType, tierType) ? newTierType.getTag() : tierType.getTag());	
		}
		
		return newTierType;
	}
	
	protected boolean compareTierTags(VillageryTier firstTier, VillageryTier secondTier) {
		if (!firstTier.hasCustomTierType()) {
			// Vanilla hardcoded switch statement moment
			switch (firstTier.getTag().location().toString()) {
			default:
				return true;
			case "minecraft:block/needs_stone_tool":
				return firstTier.getTag().equals(BlockTags.NEEDS_IRON_TOOL) || firstTier.getTag().equals(BlockTags.NEEDS_DIAMOND_TOOL);
			case "minecraft:block/needs_iron_tool":
				return firstTier.getTag().equals(BlockTags.NEEDS_DIAMOND_TOOL);
			case "minecraft:block/needs_diamond_tool":
				return false;
			}
		} else if (!firstTier.getWorseTierTypes().isEmpty() || !firstTier.getBetterTierTypes().isEmpty()) {
			if (firstTier.getWorseTierTypes().contains(secondTier)) return true;
			if (firstTier.getBetterTierTypes().contains(secondTier)) return false;
		}
		
		return true;
	}
	
	protected VillageryTier buildCustomTierType() {
		TierSortingRegistry.registerTier(this, getTierRegName(), List.of(), List.of());
		
		return this;
	}
	
	protected VillageryTier buildCustomTierTypeWithStatus() {
		TierSortingRegistry.registerTier(this, getTierRegName(), List.of(worseTierTypes), List.of(betterTierTypes));
		
		return this;
	}
	
	protected boolean hasCustomTierType() {
		return !getTag().equals(BlockTags.NEEDS_STONE_TOOL) && !getTag().equals(BlockTags.NEEDS_IRON_TOOL) && !getTag().equals(BlockTags.NEEDS_DIAMOND_TOOL);
	}

}
