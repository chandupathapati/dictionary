package com.spreetail.dictionary;

public class Dictionary {
	
	private MultiValueMap<String, String> multiValueMap = new MultiValueMap<>();

	public void addEntry(String key, String value) {
		if (multiValueMap.put(key, value)) {
			ConsoleUtilities.printToConsole("Added");
		} else {
			ConsoleUtilities.printToConsole("ERROR, value already exists");
		}
	}

	public void removeValueFromKey(String key, String value) {
		if (!isKeyPresent(key)) {
			ConsoleUtilities.printToConsole("ERROR, key does not exist.");
			return;
		}
		if (!isKeyValuePresent(key, value)) {
			ConsoleUtilities.printToConsole("ERROR, value does not exist.");
			return;
		}
		if (multiValueMap.remove(key, value)) {
			ConsoleUtilities.printToConsole("Removed");
			if (multiValueMap.get(key).isEmpty()) {
				multiValueMap.remove(key);
			}
		}
	}

	public void removeKey(String key) {
		if (!isKeyPresent(key)) {
			ConsoleUtilities.printToConsole("ERROR, key does not exist");
			return;
		}

		if (multiValueMap.remove(key)) {
			ConsoleUtilities.printToConsole("Removed");
		}
	}

	public void clear() {
		if (multiValueMap.clear()) {
			ConsoleUtilities.printToConsole("Cleared");
		}
	}

	public boolean isKeyPresent(String key) {
		return multiValueMap.contains(key);
	}

	public MultiValueMap<String, String> getDictionary() {
		return multiValueMap;
	}

	public boolean isKeyValuePresent(String key, String value) {
		return multiValueMap.contains(key, value);
	}
}
