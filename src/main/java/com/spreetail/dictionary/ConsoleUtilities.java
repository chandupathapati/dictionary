package com.spreetail.dictionary;

public class ConsoleUtilities {
	
	private ConsoleUtilities() {
		throw new IllegalStateException("Console Utility class");
	}

	public static void printToConsole(String message) {
		System.out.println(message);
	}
}
