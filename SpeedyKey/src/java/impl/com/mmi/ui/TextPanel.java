package com.mmi.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicLabelUI;

import com.mmi.model.Model;
import com.mmi.model.Model.TextPanelAction;
import com.mmi.model.SpeedyWord;

/**
 * Contains the text to type
 * 
 * @author Move21Style
 */
public class TextPanel extends JPanel implements Observer {
	private static final long serialVersionUID = -1779431939119342773L;

	private List<SpeedyLabel> speedyLabels = new ArrayList<>();
	private final int VGAP = 5;
	private final int HGAP = VGAP * 2;

	public TextPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT, HGAP, VGAP)); // align, hgap, vgap
		setBorder(BorderFactory.createLineBorder(Color.RED));
	}

	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model) o;

		if (model.textPanelAction == TextPanelAction.NONE) {
			return;
		}

		if (model.textPanelAction == TextPanelAction.NEW_WORDS) {
			// reset
			model.textPanelAction = TextPanelAction.NONE;

			System.out.println(getClass().getSimpleName() + " - setup TextPanel with new words");
			SwingUtilities.invokeLater(() -> {

				// Calculate and add labels
				Dimension labelSize = null;
				BasicLabelUI basicLabelUI = new BasicLabelUI();
				List<SpeedyWord> speedyWords = model.getSpeedyWords();
				for (SpeedyWord speedyWord : speedyWords) {
					SpeedyLabel speedyLabel = new SpeedyLabel(speedyWord.getIndex(), speedyWord.getWord());
					labelSize = basicLabelUI.getPreferredSize(speedyLabel);
					speedyLabel.setPreferredSize(new Dimension(labelSize.width + VGAP, labelSize.height));
					speedyLabel.validate();
					add(speedyLabel);
					speedyLabels.add(speedyLabel);
				}

				// Re-layout view
				validate();

				// Set scroll bar unit increment
				JScrollPane scrollPane = (JScrollPane) getParent().getParent();
				if (labelSize != null) {
					JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
					verticalScrollBar.setUnitIncrement(labelSize.height + VGAP); // 26
				}
			});
		} else {
			System.out.println("WARNING: " + getClass().getSimpleName() + " - Unhandled action ["
					+ model.textPanelAction.name() + "]");
		}
	}

	/**
	 * Need to override to make resizing of the scroll panel possible.<br>
	 * The width is taken from parent - {@link #HGAP}.<br>
	 * The height is taken by last component's location + it's height + {@link #VGAP}.
	 * 
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		Dimension retVal = super.getPreferredSize();

		if (this.getComponents().length > 0) {
			Component lastComponent = this.getComponents()[this.getComponents().length - 1];
			Point point = lastComponent.getLocation();
			// System.out.println("Point=" + point);

			retVal = new Dimension(getParent().getSize().width - HGAP, (point.y + lastComponent.getHeight() + VGAP));
		}

		return retVal;
	}
}
