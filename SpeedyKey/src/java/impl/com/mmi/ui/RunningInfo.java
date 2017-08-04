package com.mmi.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Contins running information like timer and stats
 * 
 * @author Move21Style
 */
public class RunningInfo extends JPanel implements Observer {
	private static final long serialVersionUID = 6705154309510264244L;

	// TODO mmi: Dummy
	public RunningInfo() {
		setLayout(new GridLayout(0, 1)); // unlimited rows, 1 column

		setPreferredSize(new Dimension(200, 0));

		for (int i = 0; i < 20; i++) {
			JLabel comp = new JLabel("Platzhalter");
			comp.setHorizontalAlignment(SwingConstants.CENTER);
			add(comp);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
