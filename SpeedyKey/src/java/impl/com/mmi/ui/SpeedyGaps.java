/**
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
package com.mmi.ui;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * A pseudo Panel to create easier gaps.
 * 
 * @author Move21Style<move21style@googlemail.com>
 */
public class SpeedyGaps extends JPanel {
	private static final long serialVersionUID = -5777476448292680805L;

	public SpeedyGaps(int width, int height) {
		setPreferredSize(new Dimension(width, height));
	}
}
