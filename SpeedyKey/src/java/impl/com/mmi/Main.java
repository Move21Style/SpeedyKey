package com.mmi;

import javax.swing.SwingUtilities;

import com.mmi.ui.MainFrame;

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> new MainFrame().start());
	}

}
