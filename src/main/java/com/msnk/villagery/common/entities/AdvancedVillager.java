package com.msnk.villagery.common.entities;

import java.util.List;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;

public class AdvancedVillager extends Villager implements SmartBrainOwner<AdvancedVillager> {

	public AdvancedVillager(EntityType<? extends Villager> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public List<ExtendedSensor<AdvancedVillager>> getSensors() {
		return null;
	}
	
	
}
