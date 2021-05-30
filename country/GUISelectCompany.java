package country;

import javax.swing.JFrame;

import company.CPcompany;
import vaccine.AZ;
import vaccine.ChadOx1;
import vaccine.Date;
import vaccine.Moderna;
import vaccine.Pfizer;
import vaccine.VaccineProduct;
import vaccine.VaccineType;
import vaccine.Yansen;
import vaccine.SideEffect.SideEffects;
import vaccine.VaccineAddable;
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;

public class GUISelectCompany extends JFrame implements ActionListener, VaccineType{
	
	
	
	SideEffects[] sf = {SideEffects.Pain, SideEffects.Blush, SideEffects.Swelling, SideEffects.Fatigue, SideEffects.Headache};
	
	VaccineForIO AZdata = null;
	//ArrayList<VaccineProduct> AZinventory = null;
	VaccineForIO Pfizerdata = null;
	//ArrayList<VaccineProduct> Pfizerinventory = null;
	VaccineForIO ChadOx1data = null;
	//ArrayList<VaccineProduct> ChadOx1inventory = null;
	VaccineForIO Modernadata = null;
	//ArrayList<VaccineProduct> Modernainventory = null;
	VaccineForIO Yansendata = null;
	
	
	
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
		
		
		
/*
		
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
		*/
		
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
		
		
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getActionCommand().equals("아스트라"))
		{
			
			AZdata = new VaccineForIO("AZ", 500);
			
			VaccineMainMenu vmm = new VaccineMainMenu(AZdata.getvaccineinfo(), AZdata);
			
			
		}
		else if(e.getActionCommand().equals("차드"))
		{
		
			ChadOx1data = new VaccineForIO("ChadOx1",500);
			VaccineMainMenu vmm = new VaccineMainMenu(ChadOx1data.getvaccineinfo(), ChadOx1data);
			
		}
		else if(e.getActionCommand().equals("모더나"))
		{

			Modernadata = new VaccineForIO("Moderna", 500);
			
			VaccineMainMenu vmm = new VaccineMainMenu(Modernadata.getvaccineinfo(),Modernadata);
			
			
			
		}
		else if(e.getActionCommand().equals("화이자"))
		{
			
			Pfizerdata = new VaccineForIO("Pfizer",500);

			
			VaccineMainMenu vmm = new VaccineMainMenu(Pfizerdata.getvaccineinfo(),Pfizerdata);
			
			
			
		}
		else if(e.getActionCommand().equals("얀센"))
		{
			Yansendata = new VaccineForIO("Yansen",500);
			
			
			VaccineMainMenu vmm = new VaccineMainMenu(Yansendata.getvaccineinfo(), Yansendata);
			
		}
		
	}
/*
	@Override
	public void addToFile(VaccineProduct vaccineProduct, VaccineType.VaccineTypes vac) {
		int num;
		double cap;
		Date pro;
		Date expr;
		String filename = null;
		
		num = vaccineProduct.getVaccineNum();
		cap = vaccineProduct.getCapacity();
		
		pro = vaccineProduct.getProductDate();
		expr = vaccineProduct.getExpireDate();
		
		if(vac.equals(VaccineType.VaccineTypes.AZ))
		{
			filename = "NatAZ.txt";
		}
		else if(vac.equals(VaccineType.VaccineTypes.ChadOx1))
		{
			filename = "NatChadOx1.txt";
		}
		else if(vac.equals(VaccineType.VaccineTypes.Moderna))
		{
			filename = "NatModerna.txt";
		}
		else if(vac.equals(VaccineType.VaccineTypes.Pfizer))
		{
			filename = "NatPfizer.txt";
		}
		else if(vac.equals(VaccineType.VaccineTypes.Yansen))
		{
			filename = "NatYansen.txt";
		}
		
	
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true));
				PrintWriter pw = new PrintWriter(bw,true);
				
				pw.write(num+"-"+cap+"-"+pro+"-"+expr+"\n");
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
		
		
		
	}

	*/
	
	
	
}
