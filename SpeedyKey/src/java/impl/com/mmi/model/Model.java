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
	public enum Status {
		NEW, RUNNING, FINISHED;
	}

	private static Random RANDOM = new Random();
	private List<SpeedyWord> speedyWords = new ArrayList<>();

	private Status status = Status.NEW;

	public void init() {
		// Get words
		List<String> availableTxtFiles = FileUtil.getAvailableTxtFiles();
		String fileName = availableTxtFiles.get(RANDOM.nextInt(availableTxtFiles.size()));
		List<String> words = FileUtil.readWords(fileName);
		initSpeedyWords(words);

		System.out.println("Model initialized");
		changeAndNotify();
	}

	/**
	 * 
	 */
	private void initSpeedyWords(List<String> words) {
		if (!speedyWords.isEmpty()) {
			speedyWords.clear();
		}

		for (int index = 0; index < words.size(); index++) {
			speedyWords.add(new SpeedyWord(index, words.get(index)));
		}
	}

	/**
	 * Change the observable status and notify all observers.
	 */
	private void changeAndNotify() {
		System.out.println("Trigger Observers");
		setChanged();
		notifyObservers();
	}

	public List<SpeedyWord> getSpeedyWords() {
		return speedyWords;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
