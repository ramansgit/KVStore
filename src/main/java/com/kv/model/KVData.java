package com.kv.model;

import com.fasterxml.jackson.databind.JsonNode;

public class KVData {

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public JsonNode getValue() {
		return value;
	}

	public void setValue(JsonNode value) {
		this.value = value;
	}

	private String key;
	
	private JsonNode value;
}
