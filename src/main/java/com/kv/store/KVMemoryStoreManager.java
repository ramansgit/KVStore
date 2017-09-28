package com.kv.store;

import java.util.Hashtable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class KVMemoryStoreManager implements KVMemoryStore {

	private static KVMemoryStoreManager manager;
	private static Hashtable<String, JsonNode> kvCache = new Hashtable<String, JsonNode>();

	private KVMemoryStoreManager() {

	}

	/**
	 * 
	 * @return
	 */
	public static KVMemoryStoreManager getInstance() {
		if (manager == null) {
			manager = new KVMemoryStoreManager();
		}

		return manager;
	}

	public void put(String key, JsonNode value) {
		kvCache.put(key, value);
	}

	public void delete(String key) {
		kvCache.remove(key);
	}

	public JsonNode get(String key) {

		return kvCache.get(key);
	}

	public List<String> searchbyValue(String val) {

		return null;
	}

}
