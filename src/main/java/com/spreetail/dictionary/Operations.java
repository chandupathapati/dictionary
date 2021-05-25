package com.spreetail.dictionary;

public enum Operations {
	KEYS("Get all keys in dictionary. Usage KEYS"),
	MEMBERS("Get all string associated with the give key. Usage MEMBERS <key>"),
	ADD("Add new key with value. Usage ADD <key> <value> duplicate. Duplicates not allowed"),
	REMOVE("Remove String associated with Key. Removes key if last string is removed from key. Usage REMOVE <key> <value>"),
	REMOVEALL("Remove key and all its values. Usage REMOVEALL <key>"),
	CLEAR("Remove all keys and all values. Usage CLEAR"),
	KEYEXISTS("Verify if key exists. Usage KEYEXISTS <key>"),
	VALUEEXISTS("Verify value exists for a given key.Usage VALUEEXISTS <key> <value>"),
	ALLMEMBERS("Get all values from all keys. Usage ALLMEMBERS"),
	ITEMS("Get all keys and their values. Usage ITEMS"),
	EXIT("exit from console app. Usage EXIT"),
	HELP("use HELP for avaialble operations or HELP <operation> for specific operation");
	
	private final String description;

	private Operations(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
