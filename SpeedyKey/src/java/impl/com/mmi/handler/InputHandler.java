package com.mmi.handler;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;

import com.mmi.model.Model;
import com.mmi.model.Model.InputFieldAction;
import com.mmi.model.Model.Status;
import com.mmi.model.SpeedyWord;

public class InputHandler {
	private final int[] SPECIAL_KEYS = new int[] { KeyEvent.VK_BACK_SPACE, KeyEvent.VK_SPACE };

	/** The GUI model */
	private Model model;

	/** A marker to be set if user pressed a special key - i.e. whitespace or backspace */
	private boolean specialKeyEvent;

	/**
	 * The Constructor
	 * 
	 * @param model
	 *            - the GUI model
	 */
	public InputHandler(Model model) {
		this.model = model;
	}

	/**
	 * Handles the key event.
	 * 
	 * @param event
	 *            - the key event the user triggered by keyboard
	 */
	public void handle(KeyEvent event) {
		char c = event.getKeyChar();

		SpeedyWord speedyWord = getCurrentSpeedyWord();
		if (speedyWord == null) {
			model.inputFieldAction = InputFieldAction.CLEAR_INPUTFIELD;
			return;
		}

		startIfPossible(c);

		if (model.status == Status.RUNNING) {
			doSpecialKeyCheck(c);

			// backspace ?
			handleBackSpace(c);

			// whitespace ?
			handleWhitespace(c);

			// all normal typing cases -> Appending
			if (!specialKeyEvent) {
				speedyWord.appendInput(c);

				// Check if this was the last missing char to complete all words.
				if (isDetectEnd()) {
					for (SpeedyWord w : model.getSpeedyWords()) {
						w.setColor(Color.GREEN);
					}
				}
			}
		}
	}

	/**
	 * 
	 */
	private boolean isDetectEnd() {
		List<SpeedyWord> speedyWords = model.getSpeedyWords();
		////		boolean preLastComplete = false;
		//
		//		boolean skipPreLast = speedyWords.size() <= 1;
		//		if (!skipPreLast) {
		// Check preLast word
		//			SpeedyWord preLast = speedyWords.get(speedyWords.size() - 2);
		//			preLastComplete = preLast.isComplete();
		//		} else {
		// There is just one word. Means we assume simply that preLast word is complete
		//			preLastComplete = true;
		//		}

		// Continue with last word only if preLast is complete.
		//		if (preLastComplete) {
		SpeedyWord last = speedyWords.get(speedyWords.size() - 1);
		if (last.isTurnGreen()) {
			System.out.println("Detected end!");
			last.setComplete(true);
			model.status = Status.FINISHED;
			model.inputFieldAction = InputFieldAction.CLEAR_INPUTFIELD;
			return true;
		}
		//		}

		// t least one uncomplete word outstanding
		return false;
	}

	private void doSpecialKeyCheck(char c) {
		this.specialKeyEvent = false;
		for (int i : SPECIAL_KEYS) {
			this.specialKeyEvent |= i == c;
		}
	}

	private void handleWhitespace(char c) {
		SpeedyWord speedyWord = getCurrentSpeedyWord();
		if (c == KeyEvent.VK_SPACE) {
			System.out.println("KeyEvent.VK_SPACE");
			if (speedyWord.isTurnGreen()) {
				speedyWord.setComplete(true);
				model.inputFieldAction = InputFieldAction.CLEAR_INPUTFIELD;
			} else {
				speedyWord.appendInput(c);
			}
		}
	}

	private void handleBackSpace(char c) {
		SpeedyWord speedyWord = getCurrentSpeedyWord();
		if (c == KeyEvent.VK_BACK_SPACE) {
			System.out.println("KeyEvent.VK_BACK_SPACE");
			speedyWord.removeLastChar();
		}
	}

	private void startIfPossible(char c) {
		if (model.status == Status.NONE) {
			SpeedyWord firstSpeedyWord = model.getSpeedyWords().get(0);
			if (firstSpeedyWord.isStartingCharacter(c)) {
				System.out.println("Detected start!");
				model.status = Status.RUNNING;
			} else {
				model.inputFieldAction = InputFieldAction.CLEAR_INPUTFIELD;
			}
		}
	}

	private SpeedyWord getCurrentSpeedyWord() {
		for (SpeedyWord speedyWord : model.getSpeedyWords()) {
			if (!speedyWord.isComplete()) {
				return speedyWord;
			}
			// After all words were completed, don't change any color
			if (model.status != Status.FINISHED) {
				speedyWord.updateColor();
			}
		}
		return null;
	}

}
