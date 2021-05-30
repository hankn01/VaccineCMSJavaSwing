package country;

import javax.swing.JFrame;

import vaccine.AZ;
import vaccine.ChadOx1;
import vaccine.Date;
import vaccine.Moderna;
import vaccine.Pfizer;
import vaccine.VaccineProduct;
import vaccine.VaccineType;
import vaccine.Yansen;
import vaccine.SideEffect.SideEffects;
import vaccineView.VaccineAdd;
import vaccineView.VaccineMainMenu;

import javax.management.remote.SubjectDelegationPermission;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUISelectCompany extends JFrame implements ActionListener, VaccineType{
	
	
	
	SideEffects[] sf = {SideEffects.Pain, SideEffects.Blush, SideEffects.Swelling, SideEffects.Fatigue, SideEffects.Headache};
	AZ AZdata = null;
	ArrayList<VaccineProduct> AZinventory = null;
	Pfizer Pfizerdata = null;
	ArrayList<VaccineProduct> Pfizerinventory = null;
	ChadOx1 ChadOx1data = null;
	ArrayList<VaccineProduct> ChadOx1inventory = null;
	Moderna Modernadata = null;
	ArrayList<VaccineProduct> Modernainventory = null;
	Yansen Yansendata = null;
	ArrayList<VaccineProduct> Yanseninventory = null;
	
	
	public GUISelectCompany()
	{
		super("회사 선택");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image prgImg = toolkit.getImage("programIcon.png");
		this.setIconImage(prgImg);
		this.setResizable(false);
		
		
		

		
		AZinventory = new ArrayList<VaccineProduct>(0);
		
		AZinventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,13), new Date(2021,5,20)));
		
		Pfizerinventory = new ArrayList<VaccineProduct>(0);
		
		Pfizerinventory.add(new VaccineProduct(20, 6.5, new Date(2021,5,13), new Date(2021,5,20)));
		
				
		ChadOx1inventory = new ArrayList<VaccineProduct>(0);
		ChadOx1inventory.add(new VaccineProduct(20,6.5, new Date(2021,5,13),new Date(2021,5,20)));
		
		Modernainventory = new ArrayList<VaccineProduct>(0);
		Modernainventory.add(new VaccineProduct(20,6.5,new Date(2021,5,13), new Date(2021,5,20)));
		
		Yanseninventory = new ArrayList<VaccineProduct>(0);
		Yanseninventory.add(new VaccineProduct(20,6.5,new Date(2021,5,13),new Date(2021,5,20)));
		
		
		JButton AZ = new JButton("AstraZeneca(AZ)");
		AZ.addActionListener(this);
		AZ.setActionCommand("아스트라");
		this.add(AZ);
		
		JButton Chad = new JButton("ChadOx1");
		Chad.addActionListener(this);
		Chad.setActionCommand("차드");
		this.add(Chad);
		
		JButton Moderna = new JButton("Moderna");
		Moderna.addActionListener(this);
		Moderna.setActionCommand("모더나");
		this.add(Moderna);
		
		JButton Pfizer = new JButton("Pfizer");
		Pfizer.addActionListener(this);
		Pfizer.setActionCommand("화이자");
		this.add(Pfizer);
		
		JButton Yansen = new JButton("Yansen");
		Yansen.addActionListener(this);
		Yansen.setActionCommand("얀센");
		this.add(Yansen);
		
		JButton OtherCompany = new JButton("기타 업체");
		OtherCompany.addActionListener(this);
		OtherCompany.setActionCommand("기타");
		this.add(OtherCompany);
		
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("아스트라"))
		{
			
			AZdata = new AZ(VaccineType.cost[2],90,VaccineType.coldChainDegree[2],VaccineType.inoculationTime,VaccineType.sideEffectRisk[2],sf,AZinventory,VaccineType.RNAName[2]);

			
			VaccineMainMenu vmm = new VaccineMainMenu(AZdata, null);
			
			
		}
		else if(e.getActionCommand().equals("차드"))
		{
			String[] temp = {"a"};
			ChadOx1data = new ChadOx1(VaccineType.cost[4],90,VaccineType.coldChainDegree[4],VaccineType.inoculationTime,VaccineType.sideEffectRisk[4],sf,ChadOx1inventory,temp,false,new Date(2020,1,1));
			VaccineMainMenu vmm = new VaccineMainMenu(ChadOx1data, null);
			
		}
		else if(e.getActionCommand().equals("모더나"))
		{

			Modernadata = new Moderna(VaccineType.cost[0],90,VaccineType.coldChainDegree[0],VaccineType.inoculationTime,VaccineType.sideEffectRisk[0],sf,AZinventory,VaccineType.RNAName[0]);
			
			
			VaccineMainMenu vmm = new VaccineMainMenu(Modernadata,null);
			
			
			
		}
		else if(e.getActionCommand().equals("화이자"))
		{
			
			Pfizerdata = new Pfizer(this.cost[1],90,VaccineType.coldChainDegree[1], VaccineType.inoculationTime,VaccineType.sideEffectRisk[1],sf,Pfizerinventory,VaccineType.RNAName[1]);

			
			VaccineMainMenu vmm = new VaccineMainMenu(Pfizerdata,null);
			
			
			
		}
		else if(e.getActionCommand().equals("얀센"))
		{
			Yansendata = new Yansen(this.cost[3],90,VaccineType.coldChainDegree[3], VaccineType.inoculationTime,VaccineType.sideEffectRisk[3],sf,Pfizerinventory,VaccineType.RNAName[3]);
			
			
			VaccineMainMenu vmm = new VaccineMainMenu(Yansendata, null);
			
		}
		else if(e.getActionCommand().equals("기타"))
		{
			
		}
	}
	
	
	
	
}
