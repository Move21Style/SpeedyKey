package com.mmi.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.mmi.model.Model;

public class SpeedyKeyListener extends KeyAdapter {

	private Model model;

	public SpeedyKeyListener(Model model) {
		this.model = model;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		model.handleUserInput(e);
	}

}
