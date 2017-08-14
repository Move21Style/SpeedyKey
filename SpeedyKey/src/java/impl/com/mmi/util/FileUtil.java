/**
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
package com.mmi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A collection of useful methods
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
public class FileUtil {

	/**
	 * @return all available txt file names.
	 */
	public static List<String> getAvailableTxtFiles() {
		File file = new File(new File("").getAbsolutePath());

		String[] availableTxtFiles = file.list((File dir, String name) -> name.toLowerCase().endsWith(".txt"));

		return Arrays.asList(availableTxtFiles);
	}

	/**
	 * Read each word from given file and put these into a String[].
	 * 
	 * @param title
	 *            - the fileName
	 * @return the words in a String[]
	 */
	public static List<String> readWords(String title) {
		StringBuilder builder = new StringBuilder();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(title));
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		List<String> words = new ArrayList<>();
		for (String word : builder.toString().split(" ")) {
			if (!word.trim().equals("")) {
				words.add(word.trim());
			}
		}

		return UnicodeUtil.convert(words);
	}
}