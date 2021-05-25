package com.spreetail.dictionary;

import java.util.Set;

public class DictionaryService {
	private static final String KEY_NOT_EXIST = "ERROR, key does not exist";
	private static final String EMPTY_SET = "empty set";

	private Dictionary dictionary = new Dictionary();

	public void processAdd(String[] userInput) {
		if (userInput.length != 3) {
			ConsoleUtilities.printToConsole("Please provide key and Value to add members to Key. ADD <key> <value>");
			return;
		}
		dictionary.addEntry(userInput[1], userInput[2]);
	}

	public void processKeys() {
		MultiValueMap<String, String> map = dictionary.getDictionary();
		if (map.size() == 0) {
			ConsoleUtilities.printToConsole(EMPTY_SET);
		}

		int keyCount = 0;
		for (String key : map.keys()) {
			ConsoleUtilities.printToConsole(++keyCount + ") " + key);
		}
	}

	public void processMembers(String[] userInput) {
		if (userInput.length == 1) {
			ConsoleUtilities.printToConsole("Please provide key to list members");
			return;
		}
		String key = userInput[1];
		MultiValueMap<String, String> map = dictionary.getDictionary();
		if (!map.contains(key)) {
			ConsoleUtilities.printToConsole(KEY_NOT_EXIST);
		}

		Set<String> values = map.get(key);
		int memberCount = 0;
		for (String value : values) {
			ConsoleUtilities.printToConsole(++memberCount + ") " + value);
		}
	}

	public void processRemove(String[] userInput) {
		if (userInput.length == 2) {
			String key = userInput[1];
			if (!dictionary.isKeyPresent(key)) {
				ConsoleUtilities.printToConsole(KEY_NOT_EXIST);
				return;
			}
			if (!dictionary.getDictionary().get(key).isEmpty()) {
				ConsoleUtilities.printToConsole(
						"Key is not empty. Please remove all values associated with Key or use REMOVEALL <key>");
			}
		} else if (userInput.length == 3) {
			dictionary.removeValueFromKey(userInput[1], userInput[2]);
		} else {
			ConsoleUtilities.printToConsole("Incorrect Arguments. Please use REMOVE <key> <value> or REMOVE <key>");
		}
	}

	public void processRemoveAll(String[] userInput) {
		if (userInput.length != 2) {
			ConsoleUtilities.printToConsole("Incorrect Arguments. Please use REMOVEALL <key>");
			return;
		}
		dictionary.removeKey(userInput[1]);
	}

	public void processClear() {
		dictionary.clear();
	}

	public void processKeyExists(String[] userInput) {
		if (userInput.length != 2) {
			ConsoleUtilities.printToConsole("Incorrect Arguments. Please use KEYEXISTS <key>");
			return;
		}
		ConsoleUtilities.printToConsole(Boolean.toString(dictionary.isKeyPresent(userInput[1])));
	}

	public void processValueExists(String[] userInput) {
		if (userInput.length != 3) {
			ConsoleUtilities.printToConsole("Incorrect Arguments. Please use VALUEEXISTS <key> <value>");
			return;
		}
		ConsoleUtilities.printToConsole(Boolean.toString(dictionary.isKeyValuePresent(userInput[1], userInput[2])));
	}

	public void processAllMembers() {
		MultiValueMap<String, String> map = dictionary.getDictionary();
		if (map.values().isEmpty()) {
			ConsoleUtilities.printToConsole(EMPTY_SET);
		}
		int countValues = 0;
		for (String key : map.keys()) {
			Set<String> values = map.get(key);
			for (String value : values) {
				ConsoleUtilities.printToConsole(++countValues + ") " + value);
			}
		}
	}

	public void processItems() {
		MultiValueMap<String, String> map = dictionary.getDictionary();
		if (map.size() == 0) {
			ConsoleUtilities.printToConsole(EMPTY_SET);
		}
		int keyValueCount = 0;
		for (String key : map.keys()) {
			Set<String> values = map.get(key);
			for (String value : values) {
				ConsoleUtilities.printToConsole(++keyValueCount + ") " + key + ": " + value);
			}
		}
	}
}
