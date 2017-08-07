package com.mmi;

import java.awt.event.KeyListener;

import javax.swing.SwingUtilities;

import com.mmi.listener.SpeedyKeyListener;
import com.mmi.model.Model;
import com.mmi.ui.MainFrame;

public class Main {

	public static void main(String[] args) {

		Model model = new Model();
		MainFrame mainFrame = new MainFrame(model);

		registerKeyListener(mainFrame, model);

		SwingUtilities.invokeLater(() -> {
			mainFrame.start();
		});

		System.out.println("GUI running...");
		SwingUtilities.invokeLater(() -> model.init());
	}

	/**
	 * Register {@link KeyListener}s
	 * 
	 * @param mainFrame
	 *            - the main frame view
	 * @param model
	 *            - the model
	 */
	private static void registerKeyListener(MainFrame mainFrame, Model model) {
		// // Focus input field
		// SwingUtilities.invokeLater(() -> {
		// mainFrame.addWindowFocusListener(new WindowAdapter() {
		// public void windowGainedFocus(WindowEvent e) {
		// mainFrame.getInputField().requestFocusInWindow();
		// }
		// });
		// });

		mainFrame.getInputField().addKeyListener(new SpeedyKeyListener(model));
	}

}
