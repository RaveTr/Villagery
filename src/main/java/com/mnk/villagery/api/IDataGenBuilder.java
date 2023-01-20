package com.mnk.villagery.api;

import com.google.gson.JsonObject;

@FunctionalInterface
public interface IDataGenBuilder {	
	JsonObject serialize();
}
