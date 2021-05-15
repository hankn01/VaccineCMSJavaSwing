package vaccineView;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import vaccine.Vaccine;
import vaccineView.VaccineMainMenu.ContentsType;

public class MainContents extends JPanel
implements ActionListener {
	
	private Vaccine vaccine;
	private VaccineMainMenu vmm;
	
	public MainContents(Vaccine vaccine, VaccineMainMenu vmm) {
		super();
		
		this.vaccine = vaccine;
		this.vmm = vmm;
		
		setBackground(Color.white);
		setLayout(new GridLayout(3,1));
		
		JButton[] navigations = new JButton[3];
		
		navigations[0] = new JButton("1. Show Information");
		navigations[0].setActionCommand("Information");
		
		navigations[1] = new JButton("2. Show Effectiveness");
		navigations[1].setActionCommand("Effectiveness");
		
		navigations[2] = new JButton("3. Show Inventory");
		navigations[2].setActionCommand("Inventory");

		for(JButton jb : navigations) {
			jb.setBorderPainted(false);
			jb.setFocusPainted(false);
			jb.setBackground(Color.white);
			jb.addActionListener(this);
			add(jb);
		}
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Information": vmm.setContents(ContentsType.Information, vaccine);
			break;
		case "Effectiveness": vmm.setContents(ContentsType.Effectiveness, vaccine);
			break;
		case "Inventory": vmm.setContents(ContentsType.Inventory, vaccine);
			break;
		}
	}
}
