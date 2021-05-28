package country;

import javax.swing.JFrame;

import vaccine.AZ;
import vaccine.ChadOx1;
import vaccine.Date;
import vaccine.Moderna;
import vaccine.Pfizer;
import vaccine.VaccineProduct;
import vaccine.SideEffect.SideEffects;
import vaccineView.VaccineMainMenu;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUISelectCompany extends JFrame implements ActionListener{
	public GUISelectCompany()
	{
		super("ȸ�� ����");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		
		JButton AZ = new JButton("AstraZeneca(AZ)");
		AZ.addActionListener(this);
		AZ.setActionCommand("�ƽ�Ʈ��");
		this.add(AZ);
		
		JButton Chad = new JButton("ChadOx1");
		Chad.addActionListener(this);
		Chad.setActionCommand("����");
		this.add(Chad);
		
		JButton Moderna = new JButton("Moderna");
		Moderna.addActionListener(this);
		Moderna.setActionCommand("�����");
		this.add(Moderna);
		
		JButton Pfizer = new JButton("Pfizer");
		Pfizer.addActionListener(this);
		Pfizer.setActionCommand("ȭ����");
		this.add(Pfizer);
		
		JButton Yansen = new JButton("Yansen");
		Yansen.addActionListener(this);
		Yansen.setActionCommand("�Ἶ");
		this.add(Yansen);
		
		JButton OtherCompany = new JButton("��Ÿ ��ü");
		OtherCompany.addActionListener(this);
		OtherCompany.setActionCommand("��Ÿ");
		this.add(OtherCompany);
		
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("�ƽ�Ʈ��"))
		{
			double cost = 100;
			String RNAName = "MRNA-1273";
			double protectionRate = 90;
			double coldChainDegree = -70;
			int inoculationTime = 2;
			SideEffects[] sideEffects = {SideEffects.Pain, SideEffects.Blush, SideEffects.Swelling, SideEffects.Fatigue, SideEffects.Headache};
			
			double sideEffectRisk = 0.5;
			
			ArrayList<VaccineProduct> inventory = new ArrayList<VaccineProduct>(0);
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,13), new Date(2021,5,20)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,14), new Date(2021,5,21)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,15), new Date(2021,5,22)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,16), new Date(2021,5,23)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,17), new Date(2021,5,24)));
			
			VaccineMainMenu vmm = new VaccineMainMenu(new AZ(
					cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, RNAName
			));
			
			
		}
		else if(e.getActionCommand().equals("����"))
		{
			double cost = 100;
			String[] DNAName = {"MRNA-1273","b"};
			double protectionRate = 90;
			double coldChainDegree = -70;
			int inoculationTime = 2;
			SideEffects[] sideEffects = {SideEffects.Pain, SideEffects.Blush, SideEffects.Swelling, SideEffects.Fatigue, SideEffects.Headache};
			
			double sideEffectRisk = 0.5;
			
			ArrayList<VaccineProduct> inventory = new ArrayList<VaccineProduct>(0);
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,13), new Date(2021,5,20)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,14), new Date(2021,5,21)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,15), new Date(2021,5,22)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,16), new Date(2021,5,23)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,17), new Date(2021,5,24)));
			
			VaccineMainMenu vmm = new VaccineMainMenu(new ChadOx1(cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, DNAName, true, new Date(2021,1,1)));
			
			
			
			
		}
		else if(e.getActionCommand().equals("�����"))
		{

			double cost = 100;
			String RNAName = "MRNA-1273";
			double protectionRate = 90;
			double coldChainDegree = -70;
			int inoculationTime = 2;
			SideEffects[] sideEffects = {SideEffects.Pain, SideEffects.Blush, SideEffects.Swelling, SideEffects.Fatigue, SideEffects.Headache};
			
			double sideEffectRisk = 0.5;
			
			ArrayList<VaccineProduct> inventory = new ArrayList<VaccineProduct>(0);
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,13), new Date(2021,5,20)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,14), new Date(2021,5,21)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,15), new Date(2021,5,22)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,16), new Date(2021,5,23)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,17), new Date(2021,5,24)));
			
			VaccineMainMenu vmm = new VaccineMainMenu(new Moderna(
					cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, RNAName
			));
			
			
			
		}
		else if(e.getActionCommand().equals("ȭ����"))
		{
			
			double cost = 100;
			String RNAName = "VVCT";
			double protectionRate = 90;
			double coldChainDegree = -70;
			int inoculationTime = 2;
			SideEffects[] sideEffects = {SideEffects.Pain, SideEffects.Blush, SideEffects.Swelling, SideEffects.Fatigue, SideEffects.Headache};
			
			double sideEffectRisk = 0.5;
			
			ArrayList<VaccineProduct> inventory = new ArrayList<VaccineProduct>(0);
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,13), new Date(2021,5,20)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,14), new Date(2021,5,21)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,15), new Date(2021,5,22)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,16), new Date(2021,5,23)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,17), new Date(2021,5,24)));
			
			VaccineMainMenu vmm = new VaccineMainMenu(new Pfizer(
					cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, RNAName
			));
			
			
			
		}
		else if(e.getActionCommand().equals("�Ἶ"))
		{
			double cost = 100;
			String RNAName = "VVCT";
			double protectionRate = 90;
			double coldChainDegree = -70;
			int inoculationTime = 2;
			SideEffects[] sideEffects = {SideEffects.Pain, SideEffects.Blush, SideEffects.Swelling, SideEffects.Fatigue, SideEffects.Headache};
			
			double sideEffectRisk = 0.5;
			
			ArrayList<VaccineProduct> inventory = new ArrayList<VaccineProduct>(0);
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,13), new Date(2021,5,20)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,14), new Date(2021,5,21)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,15), new Date(2021,5,22)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,16), new Date(2021,5,23)));
			inventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,17), new Date(2021,5,24)));
			
			VaccineMainMenu vmm = new VaccineMainMenu(new Pfizer(
					cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, RNAName
			));
			
		}
		else if(e.getActionCommand().equals("��Ÿ"))
		{
			
		}
	}
	
	
	
	
}
