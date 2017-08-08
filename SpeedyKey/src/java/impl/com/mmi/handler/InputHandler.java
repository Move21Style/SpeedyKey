package com.mmi.handler;

import java.awt.event.KeyEvent;

import com.mmi.model.Model;
import com.mmi.model.Model.InputFieldAction;
import com.mmi.model.Model.Status;
import com.mmi.model.Model.TextPanelAction;
import com.mmi.model.SpeedyWord;

public class InputHandler {

	private Model model;

	public InputHandler(Model model) {
		this.model = model;
	}

	public void handle(KeyEvent event) {
		char c = event.getKeyChar();

		SpeedyWord speedyWord = getCurrentSpeedyWord();
		if (speedyWord == null) {
			// Ende
			return;
		}

		startIfPossible(c);

		if (model.status == Status.START) {
			System.out.println("Detected start!");
			model.status = Status.RUNNING;
		}

		if (model.status == Status.RUNNING) {
			// backspace ?
			handleBackSpace(c);

			// whitespace ?
			handleWhitespace(c);

			// all other cases -> Appending
			if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
				// TODO mmi:
			}
		}
	}

	private void handleWhitespace(char c) {
		SpeedyWord speedyWord = getCurrentSpeedyWord();
		if (c == KeyEvent.VK_SPACE) {
			System.out.println("KeyEvent.VK_SPACE");
			model.textPanelAction = TextPanelAction.UPDATE_COLOR;
			if (speedyWord.isTurnGreen()) {
				model.inputFieldAction = InputFieldAction.CLEAR_INPUTFIELD;
			}
		}
	}

	private void handleBackSpace(char c) {
		SpeedyWord speedyWord = getCurrentSpeedyWord();
		if (c == KeyEvent.VK_BACK_SPACE) {
			System.out.println("KeyEvent.VK_BACK_SPACE");
			speedyWord.removeLastChar();
			model.textPanelAction = TextPanelAction.UPDATE_COLOR;
		}
	}

	private void startIfPossible(char input) {
		if (model.status != Status.RUNNING) {
			SpeedyWord firstSpeedyWord = model.getSpeedyWords().get(0);
			if (firstSpeedyWord.isStartingCharacter(input)) {
				firstSpeedyWord.setActive();
				model.status = Status.START;
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
