package com.mmi.handler;

import java.awt.event.KeyEvent;

import com.mmi.model.Model;
import com.mmi.model.Model.InputFieldAction;
import com.mmi.model.Model.Status;
import com.mmi.model.Model.TextPanelAction;
import com.mmi.model.SpeedyWord;

public class InputHandler {

	/** The GUI model */
	private Model model;

	/** A marker to be set if user pressed a special key - i.e. whitespace or backspace */
	private boolean specialKeyEvent;

	/**
	 * The Constructor
	 * 
	 * @param model - the GUI model
	 */
	public InputHandler(Model model) {
		this.model = model;
	}

	/**
	 * Handles the key event.
	 * 
	 * @param event - the key event the user triggered by keyboard
	 */
	public void handle(KeyEvent event) {
		char c = event.getKeyChar();

		SpeedyWord speedyWord = getCurrentSpeedyWord();
		if (speedyWord == null) {
			// Ende
			return;
		}

		startIfPossible(c);

		if (model.status == Status.RUNNING) {
			// backspace ?
			handleBackSpace(c);

			// whitespace ?
			handleWhitespace(c);

			// all normal typing cases -> Appending
			if (!specialKeyEvent) {
				// TODO mmi:
				speedyWord.appendInput(c);
			}
		}

		model.textPanelAction = TextPanelAction.UPDATE_COLOR;
		model.inputFieldAction = InputFieldAction.UPDATE_COLOR;
		this.specialKeyEvent = false;
	}

	private void handleWhitespace(char c) {
		SpeedyWord speedyWord = getCurrentSpeedyWord();
		if (c == KeyEvent.VK_SPACE) {
			this.specialKeyEvent = true;
			System.out.println("KeyEvent.VK_SPACE");
			if (speedyWord.isTurnGreen()) {
				model.inputFieldAction = InputFieldAction.CLEAR_INPUTFIELD;
			} else {
				speedyWord.appendInput(c);
				model.textPanelAction = TextPanelAction.UPDATE_COLOR;
			}
		}
	}

	private void handleBackSpace(char c) {
		SpeedyWord speedyWord = getCurrentSpeedyWord();
		if (c == KeyEvent.VK_BACK_SPACE) {
			this.specialKeyEvent = true;
			System.out.println("KeyEvent.VK_BACK_SPACE");
			speedyWord.removeLastChar();
			model.textPanelAction = TextPanelAction.UPDATE_COLOR;
		}
	}

	private void startIfPossible(char input) {
		if (model.status != Status.RUNNING) {
			SpeedyWord firstSpeedyWord = model.getSpeedyWords().get(0);
			if (firstSpeedyWord.isStartingCharacter(input)) {
				System.out.println("Detected start!");
				model.status = Status.RUNNING;
			} else {
				model.inputFieldAction = InputFieldAction.CLEAR_INPUTFIELD;
			}
		}
	}

	private SpeedyWord getCurrentSpeedyWord() {
		for (SpeedyWord speedyWord : model.getSpeedyWords()) {
			if (!speedyWord.isCompleted()) {
				return speedyWord;
			}
		}
		return null;
	}

}
