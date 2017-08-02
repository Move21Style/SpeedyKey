package com.mmi.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mmi.model.Model;

public class InputPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 7901869482740404063L;

	JTextField textField;

	public InputPanel() {

		setLayout(new BorderLayout(0, 10));
		this.textField = new JTextField();
		textField.setPreferredSize(new Dimension(100, 50));
		textField.setMinimumSize(new Dimension(100, 50));
		textField.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));

		add(textField, BorderLayout.CENTER);

		// Pseudo solution to get a gap to left and right side
		add(new SpeedyGaps(10, 0), BorderLayout.WEST);
		add(new SpeedyGaps(10, 0), BorderLayout.EAST);
		add(new SpeedyGaps(0, 2), BorderLayout.SOUTH);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Model model = (Model) arg0;
		System.out.println("Update input panel");
	}
}
