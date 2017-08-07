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
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		char keyChar = e.getKeyChar();
		int modifiersEx = e.getModifiersEx();
		boolean shiftDown = e.isShiftDown();
		int extendedKeyCode = e.getExtendedKeyCode();
		boolean altDown = e.isAltDown();
		String keyText = KeyEvent.getKeyText(e.getKeyCode());

		System.out.println("keyPressed(KeyEvent e)" //
				+ ": keyCode=" + keyCode //
				+ ", keyChar=" + keyChar //
				+ ", modifiersEx=" + modifiersEx //
				+ ", shiftDown=" + shiftDown //
				+ ", extendedKeyCode=" + extendedKeyCode //
				+ ", altDown=" + altDown //
				+ ", keyText=" + keyText);
	}

	// TODO mmi: 
	//		----> Seems to be the solution <----
	@Override
	public void keyTyped(KeyEvent e) {
		int keyCode = e.getKeyCode();
		char keyChar = e.getKeyChar();
		int modifiersEx = e.getModifiersEx();
		boolean shiftDown = e.isShiftDown();
		int extendedKeyCode = e.getExtendedKeyCode();
		boolean altDown = e.isAltDown();
		String keyText = KeyEvent.getKeyText(e.getKeyCode());

		System.out.println("keyTyped(KeyEvent e)" //
				+ ": keyCode=" + keyCode //
				+ ", keyChar=" + keyChar //
				+ ", modifiersEx=" + modifiersEx //
				+ ", shiftDown=" + shiftDown //
				+ ", extendedKeyCode=" + extendedKeyCode //
				+ ", altDown=" + altDown //
				+ ", keyText=" + keyText);
	}

}
