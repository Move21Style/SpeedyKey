package com.mmi.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.mmi.model.Model;
import com.mmi.model.Model.InputFieldAction;
import com.mmi.model.SpeedyWord;

public class InputField extends JTextField implements Observer {
	private static final long serialVersionUID = 7901869482740404063L;

	public InputField() {
		setPreferredSize(new Dimension(100, 50));
		setMinimumSize(new Dimension(100, 50));

		setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));

		setOpaque(true);
		setBackground(Color.WHITE);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Model model = (Model) arg0;

		if (model.inputFieldAction == InputFieldAction.NONE) {
			return;
		}

		if (model.inputFieldAction == InputFieldAction.CLEAR_INPUTFIELD) {
			// reset
			model.inputFieldAction = InputFieldAction.NONE;
			System.out.println(getClass().getSimpleName() + " - clear text field");

			SwingUtilities.invokeLater(() -> {
				setText("");
				setCaretPosition(0);
			});
		} else if (model.inputFieldAction == InputFieldAction.UPDATE_COLOR) {
			for (SpeedyWord speedyWord : model.getSpeedyWords()) {
				if (speedyWord.isTurnRed()) {
					setBackground(speedyWord.getColor());
					return; // Done
				}
			}
			setBackground(Color.WHITE); // All words on track -> reset bgColor
		} else {
			System.out.println("WARNING: " + getClass().getSimpleName() + " - Unhandled action ["
					+ model.inputFieldAction.name() + "]");
		}
	}
}
