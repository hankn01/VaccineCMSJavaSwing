package company;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vaccine.VaccineType;
import vaccine.Vaccine;
import vaccineView.VaccineMainMenu;

public class SeeDetailGUI extends JFrame {
	
	TextAdaptor TA = new TextAdaptor();
	
	Vaccine vaccineOfThisCompany = null; // Kanei0415
	
	public SeeDetailGUI(Object seltype, Object selname) {
		
		
		setTitle("ȸ�� ���� ����");
		setLayout(new BorderLayout());
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		

		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(2,1, 10, 10));
		add(buttonpanel, BorderLayout.SOUTH);
		
		JButton close = new JButton("�ݱ�");
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
	
		System.out.println(selname);
		

		if(Comtype.equals("��Ű��߻�����")) {
			HaverVaccineCompany dc = new HaverVaccineCompany();
				for(Company c: TA.company) {
					if(c.getCompanyName().equals(selname)) {
						dc = (HaverVaccineCompany) c;
					}
				}
				JPanel datapanel =new JPanel();
				add(datapanel, BorderLayout.CENTER);
				datapanel.setLayout(new GridLayout(8,2,15,15));
				JLabel l1 = new JLabel("ȸ���̸�");
				JLabel d1 = new JLabel(dc.getCompanyName());
				datapanel.add(l1);
				datapanel.add(d1);
				JLabel l2 = new JLabel("���");
				JButton d2 = new JButton(dc.getVaccine());
				d2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// Kanei0415
						String vaccineTypeFromInput = vaccineTypeTextField.getText().toString().lower();

						// Kanei0415
						switch(vaccineTypeFromInput) {
							case "morderna": vaccineOfThisCompany = new Morderna(Variables For Arguments);
								break;
							case "yansen": vaccineOfThisCompany = new Yansen(Variables For Arguments);
								break;
							... All of Cases
						}
						
					}
					
					
				});
				datapanel.add(l2);
				datapanel.add(d2);
				JLabel l3 = new JLabel("�Ǹ� ����");
				JLabel d3 = new JLabel(dc.getCountry());
				datapanel.add(l3);
				datapanel.add(d3);
				JLabel l4 = new JLabel("�Ѵ� ��� ���귮");
				JLabel d4 = new JLabel(Integer.toString(dc.getVTPM()));
				datapanel.add(l4);
				datapanel.add(d4);
				JLabel l5 = new JLabel("CEO");
				JLabel d5 = new JLabel(dc.getCEO());
				datapanel.add(l5);
				datapanel.add(d5);
				JLabel l6 = new JLabel("������");
				JLabel d6 = new JLabel(dc.getDate());
				datapanel.add(l6);
				datapanel.add(d6);
				JLabel l7 = new JLabel("������ġ");
				JLabel d7 = new JLabel(dc.getHeadquatersLocation());
				datapanel.add(l7);
				datapanel.add(d7);
				JLabel l8 = new JLabel("��� ��");
				JLabel d8 = new JLabel(Integer.toString(dc.getNumberOfEmployee()));
				datapanel.add(l8);
				datapanel.add(d8);
				

			 

		}else if(Comtype.equals("��Ź������")) {
			CPcompany dc = new CPcompany();
				for(Company c: TA.company) {
					if(c.getCompanyName().equals(selname)) {
						dc = (CPcompany) c;
					}
					JPanel datapanel =new JPanel();
					add(datapanel, BorderLayout.CENTER);
					datapanel.setLayout(new GridLayout(8,2,15,15));
					JLabel l1 = new JLabel("ȸ���̸�");
					JLabel d1 = new JLabel(dc.getCompanyName());
					datapanel.add(l1);
					datapanel.add(d1);
					JLabel l2 = new JLabel("���");
					JButton d2 = new JButton(dc.getVaccine());
					d2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// Kanei0415
							new VaccineMainMenu(vaccineOfThisCompany);
						}
						
						
					});
					datapanel.add(l2);
					datapanel.add(d2);

					JLabel l4 = new JLabel("�Ѵ� ��� ���귮");
					JLabel d4 = new JLabel(Integer.toString(dc.getVTPM()));
					datapanel.add(l4);
					datapanel.add(d4);
					JLabel l5 = new JLabel("CEO");
					JLabel d5 = new JLabel(dc.getCEO());
					datapanel.add(l5);
					datapanel.add(d5);
					JLabel l6 = new JLabel("������");
					JLabel d6 = new JLabel(dc.getDate());
					datapanel.add(l6);
					datapanel.add(d6);
					JLabel l7 = new JLabel("������ġ");
					JLabel d7 = new JLabel(dc.getHeadquatersLocation());
					datapanel.add(l7);
					datapanel.add(d7);
					JLabel l8 = new JLabel("��� ��");
					JLabel d8 = new JLabel(Integer.toString(dc.getNumberOfEmployee()));
					datapanel.add(l8);
					datapanel.add(d8);
					JLabel l9 = new JLabel("��Ź��û���");
					JLabel d9 = new JLabel(dc.getApprovedCompany());
					datapanel.add(l9);
					datapanel.add(d9);
					

					
					
					
					
				}
		}else {
			UnderDevelopCompany dc = new UnderDevelopCompany();
				for(Company c: TA.company) {
					if(c.getCompanyName().equals(selname)) {
						dc = (UnderDevelopCompany) c;
					}
				}
				JPanel datapanel =new JPanel();
				add(datapanel, BorderLayout.CENTER);
				datapanel.setLayout(new GridLayout(8,2,15,15));
				JLabel l1 = new JLabel("ȸ���̸�");
				JLabel d1 = new JLabel(dc.getCompanyName());
				datapanel.add(l1);
				datapanel.add(d1);
				JLabel l2 = new JLabel("���� ���� ��� �̸�");
				JLabel d2 = new JLabel(dc.getDevelopVaccineName());
				datapanel.add(l2);
				datapanel.add(d2);				
				JLabel l3 = new JLabel("�ӻ� �ܰ�");
				JLabel d3 = new JLabel("�ӻ� "+dc.getClinicalProgress()+"�ܰ�");
				datapanel.add(l3);
				datapanel.add(d3);
				JLabel l5 = new JLabel("CEO");
				JLabel d5 = new JLabel(dc.getCEO());
				datapanel.add(l5);
				datapanel.add(d5);
				JLabel l6 = new JLabel("������");
				JLabel d6 = new JLabel(dc.getDate());
				datapanel.add(l6);
				datapanel.add(d6);
				JLabel l7 = new JLabel("������ġ");
				JLabel d7 = new JLabel(dc.getHeadquatersLocation());
				datapanel.add(l7);
				datapanel.add(d7);
				JLabel l8 = new JLabel("��� ��");
				JLabel d8 = new JLabel(Integer.toString(dc.getNumberOfEmployee()));
				datapanel.add(l8);
				datapanel.add(d8);
	
				
				
				
				
		}
		

		
		

		
		
	}

}
