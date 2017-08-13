package com.mmi.model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import com.mmi.handler.InputHandler;
import com.mmi.util.FileUtil;

/**
 * The main model
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
public class Model extends Observable {
	public enum InputFieldAction {
		NONE, CLEAR_INPUTFIELD; // Color is updated by each event automatically
	}

	public enum TextPanelAction {
		NONE, NEW_WORDS; // Color is updated by each event automatically
	}

	public enum Status {
		NONE, RUNNING, FINISHED;
	}

	private static Random RANDOM = new Random();
	private List<SpeedyWord> speedyWords = new ArrayList<>();

	public TextPanelAction textPanelAction = TextPanelAction.NONE;
	public InputFieldAction inputFieldAction = InputFieldAction.NONE;
	public Status status = Status.NONE;

	private InputHandler inputHandler;

	public void init() {
		inputHandler = new InputHandler(this);

		// Get words
		List<String> availableTxtFiles = FileUtil.getAvailableTxtFiles();
		String fileName = availableTxtFiles.get(RANDOM.nextInt(availableTxtFiles.size()));

		// Override to short test.txt file during development
		fileName = "test.txt";

		List<String> words = FileUtil.readWords(fileName);

		initSpeedyWords(words);

		System.out.println("Model initialized...");

		textPanelAction = TextPanelAction.NEW_WORDS;
		inputFieldAction = InputFieldAction.CLEAR_INPUTFIELD;
		changeAndNotify();
	}

	public void handleUserInput(KeyEvent event) {
		inputHandler.handle(event);
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

	/**
	 * Reset words and model.
	 */
	public void reset() {
		for (SpeedyWord w : getSpeedyWords()) {
			w.reset();
		}
		inputFieldAction = InputFieldAction.CLEAR_INPUTFIELD;
		status = Status.NONE;
		changeAndNotify();
	}
}
