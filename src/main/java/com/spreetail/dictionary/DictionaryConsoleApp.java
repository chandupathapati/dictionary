package com.spreetail.dictionary;

import java.util.EnumSet;
import java.util.Scanner;

public class DictionaryConsoleApp {

	public static void main(String[] args) {

		welcomeText();
		readUserInputAndProcessActions();
	}

	private static void welcomeText() {
		StringBuilder textBuffer = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		textBuffer.append("**************Multi-Value Dictionary Console Application**************" + newLine);
		textBuffer.append("Please find the below available operations to perform on this Dictionary" + newLine);
		textBuffer.append(EnumSet.allOf(Operations.class) + newLine);
		textBuffer.append(
				"Use HELP to list available options or HELP <operation> for individual operation help" + newLine);

		ConsoleUtilities.printToConsole(textBuffer.toString());
	}

	private static void readUserInputAndProcessActions() {
		DictionaryService dictonaryService = new DictionaryService();
		Scanner sn = new Scanner(System.in);

		while (true) {
			String[] userInput = sn.nextLine().split(" ");
			try {
				Operations operation = Operations.valueOf(userInput[0].toUpperCase());
				switch (operation) {
				case ADD:
					dictonaryService.processAdd(userInput);
					break;
				case KEYS:
					dictonaryService.processKeys();
					break;
				case MEMBERS:
					dictonaryService.processMembers(userInput);
					break;
				case REMOVE:
					dictonaryService.processRemove(userInput);
					break;
				case REMOVEALL:
					dictonaryService.processRemoveAll(userInput);
					break;
				case CLEAR:
					dictonaryService.processClear();
					break;
				case KEYEXISTS:
					dictonaryService.processKeyExists(userInput);
					break;
				case VALUEEXISTS:
					dictonaryService.processValueExists(userInput);
					break;
				case ALLMEMBERS:
					dictonaryService.processAllMembers();
					break;
				case ITEMS:
					dictonaryService.processItems();
					break;
				case HELP:
					if (userInput.length == 1) {
						ConsoleUtilities.printToConsole(EnumSet.allOf(Operations.class).toString());
					} else if (userInput.length == 2) {
						Operations operationHelp = Operations.valueOf(userInput[1]);
						ConsoleUtilities.printToConsole(operationHelp.getDescription());
					}
					break;
				case EXIT:
					ConsoleUtilities.printToConsole("Multi Value Dictionary Console Application exited");
					sn.close();
					System.exit(0);
					break;
				default:
					ConsoleUtilities.printToConsole("Operation not yet avaialble...");
				}
			} catch (IllegalArgumentException e) {
				ConsoleUtilities.printToConsole(
						"Operation not valid. Please use HELP to list available operations or type EXIT to close.");
			}
		}
	}

}
