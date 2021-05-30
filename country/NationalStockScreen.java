package country;
import javax.swing.JFrame;
import javax.swing.JPanel;

import company.GUICompanyMain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NationalStockScreen extends JFrame{
	
	
	
	
	

	
	
	public NationalStockScreen ()
	{
		super();
		this.setSize(260,275);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(new Color(103,58,183));
		this.setTitle("백신 회사 및 백신 물량 관리");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image prgImg = toolkit.getImage("programIcon.png");
		setIconImage(prgImg);
		setResizable(false);
		
		
		//JLabel Population = new JLabel();
		//Population.setText("인구 수: ");
		
		
		
		JLabel NatStock = new JLabel();
		NatStock.setText("백신회사 및 물량관리");
		NatStock.setFont(new Font("맑은 고딕",18,18));
		NatStock.setForeground(Color.WHITE);
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		downPanel.setBackground(new Color(255,193,7));
		
		ImageIcon Comp = new ImageIcon("enterprise.png");
		Image Compa = Comp.getImage();
		Image ChangedCompa = Compa.getScaledInstance(100, 140,Image.SCALE_SMOOTH);
		ImageIcon ChangedComp = new ImageIcon(ChangedCompa);
		
		
		
		
		
		
		
		JButton CompanyButton = new JButton(ChangedComp);
		CompanyButton.setSize(new Dimension(100,140));
		CompanyButton.setContentAreaFilled(false);
		CompanyButton.setBorderPainted(false);
		CompanyButton.setFocusPainted(false);
		CompanyButton.addActionListener(new ListenerClass());
		
		downPanel.add(CompanyButton, BorderLayout.WEST);
		
		
		
		
		ImageIcon NCImg = new ImageIcon("syringe.png");
		Image NCImga = NCImg.getImage();
		Image ChangedNCImga = NCImga.getScaledInstance(100, 140,Image.SCALE_SMOOTH);
		ImageIcon ChangedNCImg = new ImageIcon(ChangedNCImga);
		
		
		
		
		
		
		
		
		
		JButton NatControl = new JButton(ChangedNCImg);
		NatControl.setSize(new Dimension(100,140));
		
		NatControl.setContentAreaFilled(false);
		NatControl.setBorderPainted(false);
		NatControl.setFocusPainted(false);
		
		NatControl.addActionListener(new ListenerClass());
		
		downPanel.add(NatControl, BorderLayout.EAST);
		
		
		
		
		NatControl.setActionCommand("회사");
		CompanyButton.setActionCommand("국가");
		//add(Population,BorderLayout.NORTH);
		
		add(NatStock,BorderLayout.NORTH);
		add(downPanel,BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}
	
	
	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("회사"))
			{
				NationalVaccineControl nvc = new NationalVaccineControl();
			}
			else if(e.getActionCommand().equals("국가"))
			{
				
				GUICompanyMain cmain = new GUICompanyMain();
			}
		}
		
	}
	
	
}
