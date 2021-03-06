package company;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vaccine.VaccineType;
import vaccine.Yansen;
import vaccine.AZ;
import vaccine.ChadOx1;
import vaccine.Moderna;
import vaccine.Pfizer;
import vaccine.Vaccine;
import vaccine.VaccineAddable;
import vaccine.VaccineProduct;
import vaccine.SideEffect;
import vaccineView.VaccineMainMenu;


public class SeeDetailGUI extends JFrame{
	
	TextAdaptor TA = new TextAdaptor();
	ArrayList<VaccineProduct> inventory = new ArrayList<VaccineProduct>(0);
	Company dc = null;

	
	public SeeDetailGUI(Object seltype, Object selname) {
		
		
		setTitle("회사 세부 정보");
		setLayout(new BorderLayout());
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		

		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(2,1, 10, 10));
		add(buttonpanel, BorderLayout.SOUTH);
		
		JButton close = new JButton("닫기");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		buttonpanel.add(close);
		close.setPreferredSize(new Dimension(30,30));
		
		
		
		
		TA.readtext();
		String Comname = (String) selname;
		String Comtype =(String) seltype;
		//System.out.println(Comname);
	
		//System.out.println(selname);
		

		if(Comtype.equals("백신개발생산기업")) {
			dc = new HaverVaccineCompany();
				for(Company c: TA.company) {
					if(c.getCompanyName().equals(selname)) {
						dc = c;
					}
				}
				JPanel datapanel =new JPanel();
				add(datapanel, BorderLayout.CENTER);
				datapanel.setLayout(new GridLayout(8,2,15,15));
				JLabel l1 = new JLabel("회사이름");
				JLabel d1 = new JLabel(dc.getCompanyName());
				datapanel.add(l1);
				datapanel.add(d1);
				JLabel l2 = new JLabel("백신");
				JButton d2 = new JButton(((HaverVaccineCompany) dc).getVaccine());
				
				d2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						
						
						VaccineMainMenu vmm = new VaccineMainMenu(((HaverVaccineCompany) dc).getvaccineinfo(), dc);
						
					}
						
					
					
				});
				datapanel.add(l2);
				datapanel.add(d2);
				JLabel l3 = new JLabel("판매 국가");
				JLabel d3 = new JLabel(((HaverVaccineCompany) dc).getCountry());
				datapanel.add(l3);
				datapanel.add(d3);
				JLabel l4 = new JLabel("한달 백신 생산량");
				JLabel d4 = new JLabel(Integer.toString(((HaverVaccineCompany) dc).getVTPM()));
				datapanel.add(l4);
				datapanel.add(d4);
				JLabel l5 = new JLabel("CEO");
				JLabel d5 = new JLabel(dc.getCEO());
				datapanel.add(l5);
				datapanel.add(d5);
				JLabel l6 = new JLabel("설립일");
				JLabel d6 = new JLabel(dc.getDate());
				datapanel.add(l6);
				datapanel.add(d6);
				JLabel l7 = new JLabel("본사위치");
				JLabel d7 = new JLabel(dc.getHeadquatersLocation());
				datapanel.add(l7);
				datapanel.add(d7);
				JLabel l8 = new JLabel("사원 수");
				JLabel d8 = new JLabel(Integer.toString(dc.getNumberOfEmployee()));
				datapanel.add(l8);
				datapanel.add(d8);
				

			 

		}else if(Comtype.equals("위탁생산기업")) {
			dc = new CPcompany();
				for(Company c: TA.company) {
					if(c.getCompanyName().equals(selname)) {
						dc = (CPcompany) c;
					}
					JPanel datapanel =new JPanel();
					add(datapanel, BorderLayout.CENTER);
					datapanel.setLayout(new GridLayout(8,2,15,15));
					JLabel l1 = new JLabel("회사이름");
					JLabel d1 = new JLabel(dc.getCompanyName());
					datapanel.add(l1);
					datapanel.add(d1);
					JLabel l2 = new JLabel("백신");
					JButton d2 = new JButton(((CPcompany) dc).getVaccine());
					
					
					
					
					d2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							
							VaccineMainMenu vmm = new VaccineMainMenu(((CPcompany) dc).getvaccineinfo(), dc);
							
							
							
								
						}
						
							
						
						
					});
					datapanel.add(l2);
					datapanel.add(d2);

					JLabel l4 = new JLabel("한달 백신 생산량");
					JLabel d4 = new JLabel(Integer.toString(((CPcompany) dc).getVTPM()));
					datapanel.add(l4);
					datapanel.add(d4);
					JLabel l5 = new JLabel("CEO");
					JLabel d5 = new JLabel(dc.getCEO());
					datapanel.add(l5);
					datapanel.add(d5);
					JLabel l6 = new JLabel("설립일");
					JLabel d6 = new JLabel(dc.getDate());
					datapanel.add(l6);
					datapanel.add(d6);
					JLabel l7 = new JLabel("본사위치");
					JLabel d7 = new JLabel(dc.getHeadquatersLocation());
					datapanel.add(l7);
					datapanel.add(d7);
					JLabel l8 = new JLabel("사원 수");
					JLabel d8 = new JLabel(Integer.toString(dc.getNumberOfEmployee()));
					datapanel.add(l8);
					datapanel.add(d8);
					JLabel l9 = new JLabel("위탁요청기업");
					JLabel d9 = new JLabel(((CPcompany) dc).getApprovedCompany());
					datapanel.add(l9);
					datapanel.add(d9);
					

					
					
					
					
				}
		}else {
			dc = new UnderDevelopCompany();
				for(Company c: TA.company) {
					if(c.getCompanyName().equals(selname)) {
						dc = (UnderDevelopCompany) c;
					}
				}
				JPanel datapanel =new JPanel();
				add(datapanel, BorderLayout.CENTER);
				datapanel.setLayout(new GridLayout(8,2,15,15));
				JLabel l1 = new JLabel("회사이름");
				JLabel d1 = new JLabel(dc.getCompanyName());
				datapanel.add(l1);
				datapanel.add(d1);
				JLabel l2 = new JLabel("개발 중인 백신 이름");
				JLabel d2 = new JLabel(((UnderDevelopCompany) dc).getDevelopVaccineName());
				datapanel.add(l2);
				datapanel.add(d2);				
				JLabel l3 = new JLabel("임상 단계");
				JLabel d3 = new JLabel("임상 "+((UnderDevelopCompany) dc).getClinicalProgress()+"단계");
				datapanel.add(l3);
				datapanel.add(d3);
				JLabel l5 = new JLabel("CEO");
				JLabel d5 = new JLabel(dc.getCEO());
				datapanel.add(l5);
				datapanel.add(d5);
				JLabel l6 = new JLabel("설립일");
				JLabel d6 = new JLabel(dc.getDate());
				datapanel.add(l6);
				datapanel.add(d6);
				JLabel l7 = new JLabel("본사위치");
				JLabel d7 = new JLabel(dc.getHeadquatersLocation());
				datapanel.add(l7);
				datapanel.add(d7);
				JLabel l8 = new JLabel("사원 수");
				JLabel d8 = new JLabel(Integer.toString(dc.getNumberOfEmployee()));
				datapanel.add(l8);
				datapanel.add(d8);
	
				
				
				
				
		}
		

		
		

		
		
	}


}
