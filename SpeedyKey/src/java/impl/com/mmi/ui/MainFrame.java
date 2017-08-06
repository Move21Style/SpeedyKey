package com.mmi.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.mmi.model.Model;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -4645928022756303009L;

	private Model model;
	private InputField inputField;

	public MainFrame(Model model) {
		this.model = model;

		// setup main frame
		setTitle("Speedy Key");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(0, 10));

		// Create panels
		createCenterPanel();
		createRightPanel();
		inputField = createBottomPanel();
	}

	private InputField createBottomPanel() {
		// Pseudo solution
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new SpeedyGaps(10, 0), BorderLayout.WEST);
		panel.add(new SpeedyGaps(10, 0), BorderLayout.EAST);
		panel.add(new SpeedyGaps(0, 10), BorderLayout.SOUTH);

		// The text field
		InputField inputField = new InputField();
		connectModelToObserver(inputField);

		panel.add(inputField, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		return inputField;
	}

	private void createRightPanel() {
		RunningInfo runningInfo = new RunningInfo();
		getContentPane().add(runningInfo, BorderLayout.EAST);
		connectModelToObserver(runningInfo);
	}

	private void createCenterPanel() {

		TextPanel textPanel = new TextPanel();
		connectModelToObserver(textPanel);

		JScrollPane scrollPane = new JScrollPane(textPanel);
		scrollPane.setPreferredSize(new Dimension(800, 600));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		getContentPane().add(scrollPane, BorderLayout.CENTER);

		// Pseudo solution
		add(new SpeedyGaps(10, 0), BorderLayout.WEST);
		add(new SpeedyGaps(0, 10), BorderLayout.NORTH);
	}

	/**
	 * @return the inputField
	 */
	public InputField getInputField() {
		return inputField;
	}

	/**
	 * Connect observing component to model
	 * 
	 * @param observer - the observer
	 */
	private void connectModelToObserver(Observer observer) {
		model.addObserver(observer);
	}

	public void start() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
