package com.mmi.util;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FileUtilTest {

	@Test
	public void testGetAvailabletestFiles() {
		List<String> availableTxtFiles = FileUtil.getAvailableTxtFiles();
		Assert.assertEquals("Unexpected number txt files found", 1, availableTxtFiles.size());
		Assert.assertEquals("Unexpected file name", "leseprobe.txt", availableTxtFiles.get(0));
	}

	@Test
	public void testReadWords() throws Exception {
		List<String> words = FileUtil.readWords("leseprobe.txt");
		Assert.assertEquals("Unexpected number words", 318, words.size());

		for (String word : words) {
			Assert.assertTrue("Empty word entry <" + words.indexOf(word) + ">",
					word != null && word.trim().length() > 0);
		}
	}

}
