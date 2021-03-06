package com.kv.store;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public interface KVMemoryStore {

	
	public abstract void put(String key, JsonNode value);
	
	public abstract void delete(String key);
	
	public abstract JsonNode get(String key);
	
	public abstract List<String> searchbyValue(String val);
}
