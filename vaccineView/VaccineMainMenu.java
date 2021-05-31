package vaccineView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import vaccine.*;
import vaccine.SideEffect.SideEffects;

public class VaccineMainMenu extends JFrame
implements ActionListener {
	
	public static final int VaccineMainMenu_WIDTH = 500;
	public static final int VaccineMainMenu_HEIGHT = 500;
	public static enum ContentsType {
		Main, Information, Effectiveness, Inventory
	};
	
	private Vaccine vaccine;
	private MainContents mc;
	private InformationContents infc;
	private EffectivenessContents efc;
	private InventoryContents invc;
	private VaccineAddable temp;
	public VaccineMainMenu(Vaccine vaccine, VaccineAddable vaccineAddable) {
		super();
		
		this.vaccine = vaccine;
		temp = vaccineAddable;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(VaccineMainMenu_WIDTH, VaccineMainMenu_HEIGHT);
		
		mc = new MainContents(vaccine, this);
		infc = new InformationContents(vaccine);
		efc = new EffectivenessContents(vaccine);
		invc = new InventoryContents(vaccine, vaccineAddable);
		
		setContents(ContentsType.Main, vaccine);
		
		setVisible(true);
	}
	
	public void setContents(ContentsType ct, Vaccine vaccine) {	
		getContentPane().removeAll();
		
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		add(new TopBar(ct, vaccine, this), BorderLayout.NORTH);
		
		JButton refresh = new JButton("새로고침");
		refresh.addActionListener(this);
		refresh.setActionCommand("새로고침");
		
		switch(ct) {
		case Main: add(mc, BorderLayout.CENTER);
			break;
		case Information: add(infc, BorderLayout.CENTER);
			break;
		case Effectiveness: add(efc, BorderLayout.CENTER);
			break;
		case Inventory: add(invc, BorderLayout.CENTER);
		add(refresh,BorderLayout.SOUTH);
			break;
		}
		
		revalidate();
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("새로고침"))
		{
			invc = new InventoryContents(vaccine, temp);
			this.revalidate();
			this.repaint();
		}
		
		
			setContents(ContentsType.Main, vaccine);
		
	}
}
