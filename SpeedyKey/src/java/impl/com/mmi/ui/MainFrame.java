package com.mmi.ui;

import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;

import com.mmi.model.Model;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -4645928022756303009L;

	private Model model;

	public MainFrame() {

		// setup main frame
		setTitle("Flexi Type");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(5, 5));

		// setup model
		this.model = new Model();

		// Create panels
		createCenterPanel();
		createRightPanel();
		createBottomPanel();
	}

	private void createBottomPanel() {
		InputPanel inputPanel = new InputPanel();
		connectModelToObserver(inputPanel);
		add(inputPanel, BorderLayout.SOUTH);
	}

	private void createRightPanel() {
		RunningInfo runningInfo = new RunningInfo();
		connectModelToObserver(runningInfo);
		add(runningInfo, BorderLayout.EAST);
	}

	private void createCenterPanel() {
		TextPanel textPanel = new TextPanel();
		connectModelToObserver(textPanel);
		add(textPanel, BorderLayout.CENTER);
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
		setVisible(true);

		model.init();
	}

}
