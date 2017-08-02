package com.mmi.util;

import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class FileUtilTest {

	@Test
	public void testGetAvailabletestFiles() {
		List<String> availableTxtFiles = FileUtil.getAvailableTxtFiles();
		Assert.assertEquals("Unexpected number txt files found", 1, availableTxtFiles.size());
		Assert.assertEquals("Unexpected file name", "leseprobe.txt", availableTxtFiles.get(0));
	}

}
