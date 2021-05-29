package country;
import javax.swing.JFrame;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import vaccine.Date;
import vaccine.Moderna;
import vaccine.VaccineProduct;
import vaccine.SideEffect.SideEffects;
import vaccineView.VaccineMainMenu;
public class CountryScreen extends JFrame{

	public static final int WIDTH = 600;
	public static final int HEIGHT = 200;
	Country ct = new Country();
	public CountryScreen()
	{
		
		JFrame CountryWindow = new JFrame();
		CountryWindow.setSize(WIDTH, HEIGHT);
		CountryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CountryWindow.setLayout(new BorderLayout());
		
		JPanel upPanel = new JPanel();
		Color upBg = new Color(33,150,243);
		upPanel.setSize(100,100);
		upPanel.setBackground(upBg);
		upPanel.setLayout(new BorderLayout());
		upPanel.setBounds(0,70,10,10);
		JLabel CountryName = new JLabel();
		CountryName.setText("<html>백신어딨지 PRO<br></html>");
		
		CountryName.setFont(new Font("맑은 고딕",Font.PLAIN,15));
		CountryName.setForeground(new Color(255,255,255));
		CountryName.setAlignmentX(CENTER_ALIGNMENT);
		CountryName.setAlignmentY(CENTER_ALIGNMENT);
		upPanel.add(CountryName,BorderLayout.CENTER);
		
		
		JLabel CurrentBudget = new JLabel();
		
		
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		ImageIcon NatImg = new ImageIcon("국가백신현황버튼.JPG");
		Image NatImga = NatImg.getImage();
		Image ChangedNatImga = NatImga.getScaledInstance(150, 70,Image.SCALE_SMOOTH);
		ImageIcon ChangedNatImg = new ImageIcon(ChangedNatImga);
		
		
		
		JButton NationStock = new JButton(ChangedNatImg);
		//NationStock.setSize(new Dimension(170,20));
		NationStock.setPreferredSize(new Dimension(150,70));
		
		
		ImageIcon LocImg = new ImageIcon("지역백신관리버튼.png");
		Image LocImga = LocImg.getImage();
		Image ChangedLocImga = LocImga.getScaledInstance(150, 70, Image.SCALE_SMOOTH);
		ImageIcon ChangedLocImg = new ImageIcon(ChangedLocImga);
		JButton LocalStock = new JButton(ChangedLocImg);
		LocalStock.setPreferredSize(new Dimension(150,70));
		
		
		
		JButton setCp = new JButton("백신회사별 백신 분량 및 유통기한 관리");
		
		
		
		NationStock.addActionListener(new ListenerClass());
		NationStock.setActionCommand("국가관리");
		LocalStock.addActionListener(new ListenerClass());
		LocalStock.setActionCommand("지역관리");
		setCp.addActionListener(new ListenerClass());
		setCp.setActionCommand("회사별분량");

		CountryWindow.add(CurrentBudget,BorderLayout.CENTER);
		downPanel.add(NationStock,BorderLayout.WEST);
		downPanel.add(LocalStock,BorderLayout.CENTER);
		downPanel.add(setCp,BorderLayout.EAST);
		
		CountryWindow.add(upPanel,BorderLayout.NORTH);

		CountryWindow.add(downPanel,BorderLayout.SOUTH);

		CountryWindow.setVisible(true);
		
		
		
		
		
		
		
		
		
	}
	
	
	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("국가관리"))
			{
				NationalStockScreen nsc = new NationalStockScreen();
			}
			else if(e.getActionCommand().equals("지역관리"))
			{
				LocalStockScreen lsc = new LocalStockScreen();
			}
			else if(e.getActionCommand().equals("회사별분량"))
			{
				//stub code
				
				GUISelectCompany gs = new GUISelectCompany();
				
				
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "프로그램 동작 오류  (에러코드 201)");
			}
		}
		
	}
	/*
	
	public static void main(String[] args)
	{
		CountryScreen sc = new CountryScreen();
	}
	*/
	
	
}
