package com.spreetail.dictionary;

public enum Operations {
	KEYS("Get all keys in dictionary. Usage KEYS"),
	MEMBERS("Get all values associated with the given key. Usage MEMBERS <key>"),
	ADD("Add new key with value or Add value to an existing key. Usage ADD <key> <value>. Duplicates not allowed"),
	REMOVE("Remove value associated with Key. Removes key if last value is removed from key. Usage REMOVE <key> <value>"),
	REMOVEALL("Remove key and all its values. Usage REMOVEALL <key>"),
	CLEAR("Remove all keys and all values. Usage CLEAR"),
	KEYEXISTS("Verify if key exists. Usage KEYEXISTS <key>"),
	VALUEEXISTS("Verify value exists for a given key.Usage VALUEEXISTS <key> <value>"),
	ALLMEMBERS("Get all values from all keys. Usage ALLMEMBERS"),
	ITEMS("Get all keys and their values. Usage ITEMS"),
	EXIT("exit from console app. Usage EXIT"),
	HELP("use HELP for available operations or HELP <operation> for specific operation");
	
	private final String description;

	private Operations(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
