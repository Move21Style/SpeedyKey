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

	private String input = new String();

	boolean complete = false;

	public Color color = null;

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

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	public boolean isCompleted() {
		return this.complete;
	}

	private void updateColor() {
		if (isTurnGreen()) {
			color = Color.GREEN;
		} else if (isTurnRed()) {
			color = Color.RED;
		} else {
			color = null;
		}
	}

	public Color getColor() {
		return this.color;
	}

	public void removeLastChar() {
		int endIndex = input.length() == 0 ? 0 : input.length() - 1;
		input = input.substring(0, endIndex);
		updateColor();
	}
}
