package com.mmi.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mmi.model.Model;

/**
 * Contins running information like timer and stats
 * 
 * @author Move21Style
 */
public class RunningInfo extends JPanel implements Observer {
	private static final long serialVersionUID = 6705154309510264244L;

	private Model model;

	// TODO mmi: Dummy
	public RunningInfo(Model model) {
		this.model = model;
		setLayout(new GridLayout(0, 1)); // unlimited rows, 1 column

		setPreferredSize(new Dimension(200, 0));

		for (int i = 0; i < 20; i++) {
			JLabel comp = new JLabel("Platzhalter");
			comp.setHorizontalAlignment(SwingConstants.CENTER);
			add(comp);
		}

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.reset();
			}
		});
		add(btnReset);
	}

	@Override
	public void update(Observable o, Object arg) {
		//		Model model = (Model) o;
	}
}
