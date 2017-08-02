package com.mmi;

import javax.swing.SwingUtilities;

import com.mmi.model.Model;
import com.mmi.ui.MainFrame;

public class Main {

	public static void main(String[] args) {

		Model model = new Model();

		SwingUtilities.invokeLater(() -> new MainFrame(model).start());

		System.out.println("GUI running...");

		SwingUtilities.invokeLater(() -> model.init());
	}

}
