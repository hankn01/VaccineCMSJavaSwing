package vaccineView;

import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import vaccine.Vaccine;
import vaccineView.VaccineMainMenu.ContentsType;

public class TopBar extends JPanel {
	public TopBar(ContentsType type, Vaccine vaccine, ActionListener al) {
		super();
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		
		add(new JLabel(vaccine.getVaccineType().toString() + " : " +type.toString()), BorderLayout.WEST);
		
		JButton closeBtn = new JButton("Home");
		closeBtn.addActionListener(al);
		add(closeBtn, BorderLayout.EAST);
	}
}
