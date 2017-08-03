/**
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
package com.mmi.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
public class SpeedyLabel extends JLabel {
	private static final long serialVersionUID = 7312242393176945810L;

	private String word;
	boolean active;
	boolean correct;

	/**
	 * Constructor
	 * 
	 * @param word
	 */
	public SpeedyLabel(String word) {
		this.word = word;

		setText(this.word);
		setBackground(Color.LIGHT_GRAY);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("Arial", Font.PLAIN, 20));
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * @param correct the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
}
