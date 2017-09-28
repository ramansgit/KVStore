package com.kv.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.kv.store.KVMemoryStoreManager;

public class KeyValueServiceImpl implements KeyValueService{

	KVMemoryStoreManager manager = KVMemoryStoreManager.getInstance();	
	
	
	public void put(String key, JsonNode value) {
		manager.put(key, value);		
	}

	public void delete(String key) {
		
		manager.delete(key);		
	}

	public JsonNode get(String key) {	
		return manager.get(key);
	}

	public List<String> searchbyValue(String val) {
		
		return null;
	}

	
	
}
