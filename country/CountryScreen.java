package country;
import javax.swing.JFrame;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Toolkit;
import com.sun.tools.javac.Main;

import vaccine.Date;
import vaccine.Moderna;
import vaccine.VaccineProduct;
import vaccine.SideEffect.SideEffects;
import vaccineView.VaccineMainMenu;
public class CountryScreen extends JFrame{

	public static final int WIDTH = 460;
	public static final int HEIGHT = 180;
	Country ct = new Country();
	public CountryScreen()
	{
		
		JFrame CountryWindow = new JFrame("???ž????? PRO");
		CountryWindow.setSize(WIDTH, HEIGHT);
		CountryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CountryWindow.setLayout(new BorderLayout());
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image prgImg = toolkit.getImage("programIcon.png");
		CountryWindow.setIconImage(prgImg);
		CountryWindow.setResizable(false);
		
		
		ImageIcon icon = new ImageIcon("vaccineImage.png");
		JPanel upPanel = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(icon.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		//Color upBg = new Color(33,150,243);
		//upPanel.setSize(460,80);
		//upPanel.setBackground(upBg);
		//upPanel.setLayout(new BorderLayout());
		//upPanel.setBounds(0,70,10,10);
		//JLabel CountryName = new JLabel();
		//CountryName.setText("<html>???ž????? PRO<br></html>");
		
		//CountryName.setFont(new Font("???? ????",Font.PLAIN,15));
		//CountryName.setForeground(new Color(255,255,255));
		//CountryName.setAlignmentX(CENTER_ALIGNMENT);
		//CountryName.setAlignmentY(CENTER_ALIGNMENT);
		//upPanel.add(CountryName,BorderLayout.CENTER);
		
		
		
		
		
		//upPanel.add(ChangedVaccineImgIcon)
		
		JLabel CurrentBudget = new JLabel();
		
		
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		ImageIcon NatImg = new ImageIcon("??????????Ȳ??ư.JPG");
		Image NatImga = NatImg.getImage();
		Image ChangedNatImga = NatImga.getScaledInstance(150, 70,Image.SCALE_SMOOTH);
		ImageIcon ChangedNatImg = new ImageIcon(ChangedNatImga);
		
		
		
		JButton NationStock = new JButton(ChangedNatImg);
		//NationStock.setSize(new Dimension(170,20));
		NationStock.setPreferredSize(new Dimension(150,70));
		
		
		ImageIcon LocImg = new ImageIcon("???????Ű?????ư.png");
		Image LocImga = LocImg.getImage();
		Image ChangedLocImga = LocImga.getScaledInstance(150, 70, Image.SCALE_SMOOTH);
		ImageIcon ChangedLocImg = new ImageIcon(ChangedLocImga);
		JButton LocalStock = new JButton(ChangedLocImg);
		LocalStock.setPreferredSize(new Dimension(150,70));
		
		
		
		ImageIcon Third = new ImageIcon("????ȸ?纰??ư.png");
		Image Thirda = Third.getImage();
		Image ChangedThirda = Thirda.getScaledInstance(150, 70, Image.SCALE_SMOOTH);
		ImageIcon ChangedThird = new ImageIcon(ChangedThirda);
		
		
		JButton setCp = new JButton(ChangedThird);
		setCp.setPreferredSize(new Dimension(150,70));
		
		
		NationStock.addActionListener(new ListenerClass());
		NationStock.setActionCommand("????????");
		LocalStock.addActionListener(new ListenerClass());
		LocalStock.setActionCommand("????????");
		setCp.addActionListener(new ListenerClass());
		setCp.setActionCommand("ȸ?纰?з?");

		//CountryWindow.add(CurrentBudget,BorderLayout.CENTER);
		downPanel.add(NationStock,BorderLayout.WEST);
		downPanel.add(LocalStock,BorderLayout.CENTER);
		downPanel.add(setCp,BorderLayout.EAST);
		
		CountryWindow.add(upPanel,BorderLayout.CENTER);

		CountryWindow.add(downPanel,BorderLayout.SOUTH);

		CountryWindow.setVisible(true);
		
		
		
		
		
		
		
		
		
	}
	
	
	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("ȸ?纰?з?"))
			{
				NationalStockScreen nsc = new NationalStockScreen();
			}
			else if(e.getActionCommand().equals("????????"))
			{
				LocalStockScreen lsc = new LocalStockScreen();
			}
			else if(e.getActionCommand().equals("????????"))
			{
				//stub code
				
				GUISelectCompany gs = new GUISelectCompany();
				
				
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "???α׷? ???? ????  (?????ڵ? 201)");
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
