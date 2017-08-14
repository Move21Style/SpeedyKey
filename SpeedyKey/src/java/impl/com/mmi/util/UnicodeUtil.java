package com.mmi.util;

import java.util.List;

public class UnicodeUtil {

	public static List<String> convert(List<String> words) {
		for (String word : words) {
			dumpString(word);
			word = word.replaceAll("\u201e", "\"");
			word = word.replaceAll("\u201c", "\"");
		}
		return words;
	}

	public static void dumpString(String text) {
		for (int i = 0; i < text.length(); i++) {
			System.out.println("U+" + Integer.toString(text.charAt(i), 16) + " " + text.charAt(i));
		}
	}
}
