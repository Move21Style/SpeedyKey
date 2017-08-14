/**
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
package com.mmi.ui;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Holds the corresponding word and flags like active or correct.
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
public class SpeedyLabel extends JLabel {
	private static final long serialVersionUID = 7312242393176945810L;

	private String word;
	private int index;

	/**
	 * Constructor
	 * 
	 * @param word
	 */
	public SpeedyLabel(int index, String word) {
		this.index = index;
		this.word = word;

		setText(this.word);
		setBackground(null);
		setOpaque(true);

		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("Arial", Font.PLAIN, 20));

		// setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setBorder(BorderFactory.createEmptyBorder());
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
}
