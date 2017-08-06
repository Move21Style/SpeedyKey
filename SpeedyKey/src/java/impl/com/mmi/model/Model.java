package com.mmi.model;

import java.util.ArrayList;
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
	private ModelUpdateType modelUpdateType;
	private List<SpeedyWord> speedyWords = new ArrayList<>();

	public void init() {
		// Get words
		List<String> availableTxtFiles = FileUtil.getAvailableTxtFiles();
		String fileName = availableTxtFiles.get(RANDOM.nextInt(availableTxtFiles.size()));
		List<String> words = FileUtil.readWords(fileName);
		buildSpeedyLabel(words);

		this.modelUpdateType = ModelUpdateType.ALL;
		System.out.println("Model initialized");
		changeAndNotify();
	}

	/**
	 * 
	 */
	private void buildSpeedyLabel(List<String> words) {
		if (speedyWords.isEmpty()) {
			for (int index = 0; index < words.size(); index++) {
				speedyWords.add(new SpeedyWord(index, words.get(index)));
			}
		}
	}

	/**
	 * @return the modelUpdateType
	 */
	public ModelUpdateType getModelUpdateType() {
		return modelUpdateType;
	}

	/**
	 * @return the speedyLabels
	 */
	public List<SpeedyWord> getSpeedyWords() {
		return speedyWords;
	}

	/**
	 * Change the observable status and notify all observers.
	 */
	private void changeAndNotify() {
		System.out.println("Trigger Observers");
		setChanged();
		notifyObservers();
	}

	public enum ModelUpdateType {
		ALL, //
		NONE, //
		TEXT, //
		INPUT, //
		RUNNING;

		public boolean isRelevantForTextPanel() {
			return this == ALL || this == TEXT;
		}
	}
}
