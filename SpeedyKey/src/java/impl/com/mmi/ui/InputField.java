package com.mmi.ui;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class InputField extends JTextField implements Observer {
	private static final long serialVersionUID = 7901869482740404063L;

	public InputField() {
		setPreferredSize(new Dimension(100, 50));
		setMinimumSize(new Dimension(100, 50));
		setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// Model model = (Model) arg0;
		System.out.println("Update input panel");
	}
}
