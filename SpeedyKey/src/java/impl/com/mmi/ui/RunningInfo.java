package com.mmi.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * Contins running information like timer and stats
 * 
 * @author Move21Style
 */
public class RunningInfo extends JPanel implements Observer {
	private static final long serialVersionUID = 6705154309510264244L;

	public RunningInfo() {
		// TODO mmi: Dummy
		setLayout(new GridLayout(1, 5));
		setPreferredSize(new Dimension(100, 0));
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
