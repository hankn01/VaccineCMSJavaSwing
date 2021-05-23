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
	
	public VaccineMainMenu(Vaccine vaccine) {
		super();
		
		this.vaccine = vaccine;
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(VaccineMainMenu_WIDTH, VaccineMainMenu_HEIGHT);
		
		mc = new MainContents(vaccine, this);
		infc = new InformationContents(vaccine);
		efc = new EffectivenessContents(vaccine);
		invc = new InventoryContents(vaccine);
		
		setContents(ContentsType.Main, vaccine);
		
		setVisible(true);
	}
	
	public void setContents(ContentsType ct, Vaccine vaccine) {	
		getContentPane().removeAll();
		
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		add(new TopBar(ct, vaccine, this), BorderLayout.NORTH);
		
		switch(ct) {
		case Main: add(mc, BorderLayout.CENTER);
			break;
		case Information: add(infc, BorderLayout.CENTER);
			break;
		case Effectiveness: add(efc, BorderLayout.CENTER);
			break;
		case Inventory: add(invc, BorderLayout.CENTER);
			break;
		}
		
		revalidate();
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setContents(ContentsType.Main, vaccine);
	}
	
//	public static void main(String[] args) {
//		double cost = 100;
//		String RNAName = "MRNA-1273";
//		double protectionRate = 90;
//		double coldChainDegree = -70;
//		int inoculationTime = 2;
//		SideEffects[] sideEffects = {SideEffects.Pain, SideEffects.Blush, SideEffects.Swelling, SideEffects.Fatigue, SideEffects.Headache};
//		
//		double sideEffectRisk = 0.5;
//		
//		ArrayList<VaccineProduct> inventory = new ArrayList<VaccineProduct>(0);
//		inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,13), new Date(2021,5,20)));
//		inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,14), new Date(2021,5,21)));
//		inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,15), new Date(2021,5,22)));
//		inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,16), new Date(2021,5,23)));
//		inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,17), new Date(2021,5,24)));
//		
//		VaccineMainMenu vmm = new VaccineMainMenu(new Moderna(
//				cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, RNAName
//		));
//	}
}
