package com.mnk.villagery.data.builder;

import com.google.gson.JsonObject;
import com.mnk.villagery.api.IDataGenBuilder;

import net.minecraft.resources.ResourceLocation;

public abstract class BaseDataBuilder implements IDataGenBuilder {
	private final ResourceLocation id;
	
	public BaseDataBuilder(ResourceLocation id) {
		this.id = id;
	}
	
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public JsonObject serialize() {
		return new JsonObject();
	}

}
