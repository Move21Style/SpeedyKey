package com.mmi.model;

import java.util.List;
import java.util.Observable;
import java.util.Random;

import com.mmi.util.FileUtil;

/**
 * The main model
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
public class Model extends Observable {

	private static Random RANDOM = new Random();

	private List<String> words;

	public void init() {
		// Get words
		List<String> availableTxtFiles = FileUtil.getAvailableTxtFiles();
		String fileName = availableTxtFiles.get(RANDOM.nextInt(availableTxtFiles.size()));
		words = FileUtil.readWords(fileName);

		changeAndNotify();
	}

	/**
	 * @return the words
	 */
	public List<String> getWords() {
		return words;
	}

	/**
	 * Change the observable status and notify all observers.
	 */
	private void changeAndNotify() {
		setChanged();
		notifyObservers();
	}

}
