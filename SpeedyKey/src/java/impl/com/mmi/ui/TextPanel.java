package com.mmi.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.mmi.model.Model;

/**
 * Contains the text to type
 * 
 * @author Move21Style
 */
public class TextPanel extends JPanel implements Observer {
	private static final long serialVersionUID = -1779431939119342773L;

	// private JScrollPane scrollPane;
	// private JPanel content;
	private List<SpeedyLabel> speedyLabels;

	public TextPanel() {
		setLayout(new BorderLayout());

		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // align, hgap, vgap
		setPreferredSize(new Dimension(480, 1000));
		// content = new JPanel();
		// content.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // align, hgap, vgap
		// content.setPreferredSize(new Dimension(600, 400));

		// scrollPane = new JScrollPane(content);
		// scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// scrollPane.setPreferredSize(new Dimension(600, 600));
		// scrollPane.setLayout(new ScrollPaneLayout());

		// add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model) o;
		System.out.println("Trigger TextPanel");
		SwingUtilities.invokeLater(() -> {
			if (model.getModelUpdateType().isRelevantForTextPanel()) {
				speedyLabels = model.getSpeedyLabels();
				for (SpeedyLabel speedyLabel : speedyLabels) {
					add(speedyLabel);
				}
				revalidate();
				// ((JScrollPane) getParent().getParent()).revalidate();
			}
		});
	}
}
