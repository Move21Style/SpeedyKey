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

	private String word;
	int index;
	boolean active;
	boolean correct;

	/**
	 * Constructor
	 * 
	 * @param word - the word
	 */
	public SpeedyWord(int index, String word) {
		this.word = word;
		this.index = index;
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

}
