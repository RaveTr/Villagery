package com.mnk.villagery.common.entities;

import java.util.List;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;

public class AdvancedVillager extends Villager implements SmartBrainOwner<AdvancedVillager> {
	private static final EntityDataAccessor<Boolean> IS_TASKING = SynchedEntityData.defineId(AdvancedVillager.class, EntityDataSerializers.BOOLEAN);

	public AdvancedVillager(EntityType<? extends Villager> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public List<ExtendedSensor<AdvancedVillager>> getSensors() {
		return null;
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 1.12D));
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(IS_TASKING, false);
	}
}
