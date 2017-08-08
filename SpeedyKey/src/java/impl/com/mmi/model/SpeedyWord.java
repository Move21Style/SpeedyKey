/**
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
package com.mmi.model;

/**
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
public class SpeedyWord {
	public enum Color {
		GREEN, RED, NONE;
	}

	private String word;
	int index;

	private String input;

	boolean active = false;
	boolean correct = true;
	boolean complete = false;

	Color color = Color.NONE;

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
		return input != null && !word.startsWith(input);
	}

	/**
	 * @return <code>true</code> if input matches 100% the word
	 */
	public boolean isTurnGreen() {
		return input != null && input.equals(word);
	}

	public void appendInput(char c) {
		if (input == null) {
			input = new String();
		}

		input += Character.toString(c);
	}

	public boolean isStartingCahracter(char c) {
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

	public void setActive() {
		this.active = true;
	}

	public void updateColor() {
		if (isTurnGreen()) {
			color = Color.GREEN;
		} else if (isTurnRed()) {
			color = Color.RED;
		} else {
			color = Color.NONE;
		}
	}

	public void removeLastChar() {
		if (input != null) {
			int endIndex = input.length() == 0 ? 0 : input.length() - 1;
			input = input.substring(0, endIndex);
		}
	}
}
