/**
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
package com.mmi.model;

import java.awt.Color;

/**
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
public class SpeedyWord {
	private String word;
	int index;

	/** User's input */
	private String input = new String();

	private boolean complete = false;

	/** The color to set the background to, or <code>null</code> if no coloring to be performed */
	private Color color = null;

	/**
	 * Constructor
	 * 
	 * @param word
	 *            - the word
	 */
	public SpeedyWord(int index, String word) {
		this.word = word;
		this.index = index;
	}

	/**
	 * @return <code>true</code> if user has made a typo
	 */
	public boolean isTurnRed() {
		// typing started && input does not match word
		return !input.isEmpty() && !word.startsWith(input);
	}

	/**
	 * @return <code>true</code> if input matches 100% the word
	 */
	public boolean isTurnGreen() {
		return !input.isEmpty() && input.equals(word);
	}

	/**
	 * Append given character to the {@link #input} {@link String}.
	 * 
	 * @param c
	 */
	public void appendInput(char c) {
		input += Character.toString(c);
		updateColor();
	}

	public boolean isStartingCharacter(char c) {
		return word.startsWith(Character.toString(c));
	}

	/**
	 * @return
	 */
	public int getIndex() {
		return this.index;
	}

	public String getWord() {
		return word;
	}

	public boolean isComplete() {
		return this.complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public void updateColor() {
		if (!this.complete) {
			if (isTurnGreen()) {
				color = Color.GREEN;
			} else if (isTurnRed()) {
				color = Color.RED;
			} else {
				color = null;
			}
		} else {
			color = null;
		}
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the current {@link #color} status
	 */
	public Color getColor() {
		return this.color;
	}

	public void removeLastChar() {
		int endIndex = input.length() == 0 ? 0 : input.length() - 1;
		input = input.substring(0, endIndex);
		updateColor();
	}

	/**
	 * Reset the status of the word as before the run was started.
	 */
	public void reset() {
		this.input = new String();
		setComplete(false);
		updateColor();
	}
}
