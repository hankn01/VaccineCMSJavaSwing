package country;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vaccine.Date;
import vaccine.Moderna;
import vaccine.VaccineProduct;
import vaccine.SideEffect.SideEffects;
import vaccineView.VaccineMainMenu;
public class CountryScreen extends JFrame{

	public static final int WIDTH = 350;
	public static final int HEIGHT = 120;
	Country ct = new Country();
	public CountryScreen()
	{
		
		JFrame CountryWindow = new JFrame();
		CountryWindow.setSize(WIDTH, HEIGHT);
		CountryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CountryWindow.setLayout(new BorderLayout());
		
		JLabel CountryName = new JLabel();
		CountryName.setText("백신어딨지 PRO");
		
		
		JLabel CurrentBudget = new JLabel();
		
		
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		
		JButton NationStock = new JButton("국가 백신 관리");
		
		
		
		
		JButton LocalStock = new JButton("지역 백신 관리");
		
		
		JButton setCp = new JButton("백신회사별 백신 분량 및 유통기한 관리");
		
		
		
		NationStock.addActionListener(new ListenerClass());
		NationStock.setActionCommand("국가관리");
		LocalStock.addActionListener(new ListenerClass());
		LocalStock.setActionCommand("지역관리");
		setCp.addActionListener(new ListenerClass());
		setCp.setActionCommand("회사별분량");
		CountryWindow.add(CountryName,BorderLayout.NORTH);
		CountryWindow.add(CurrentBudget,BorderLayout.CENTER);
		downPanel.add(NationStock,BorderLayout.WEST);
		downPanel.add(LocalStock,BorderLayout.CENTER);
		downPanel.add(setCp,BorderLayout.EAST);
		
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
