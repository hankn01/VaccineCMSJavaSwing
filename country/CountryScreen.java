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
		super("백신어딨어 PRO - 현재 백신 현황");
		this.setTitle("백신어딨어 PRO - 현재 국가 백신 현황");
		JFrame CountryWindow = new JFrame();
		CountryWindow.setSize(WIDTH, HEIGHT);
		CountryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CountryWindow.setLayout(new BorderLayout());
		
		JLabel CountryName = new JLabel();
		CountryName.setText("백신어딨어 PRO");
		
		
		JLabel CurrentBudget = new JLabel();
		CurrentBudget.setText("현재 예산(코로나 19 백신 편성) :\n"+"테스트 달러");
		
		
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		
		JButton NationStock = new JButton("전국 재고 현황");
		
		
		
		
		JButton LocalStock = new JButton("지역별 재고 현황");
		
		
		JButton setBudget = new JButton("예산 설정");
		
		NationStock.addActionListener(new ListenerClass());
		NationStock.setActionCommand("국가");
		LocalStock.addActionListener(new ListenerClass());
		LocalStock.setActionCommand("지역");
		
		CountryWindow.add(CountryName,BorderLayout.NORTH);
		CountryWindow.add(CurrentBudget,BorderLayout.CENTER);
		downPanel.add(NationStock,BorderLayout.WEST);
		downPanel.add(LocalStock,BorderLayout.CENTER);
		downPanel.add(setBudget,BorderLayout.EAST);
		
		CountryWindow.add(downPanel,BorderLayout.SOUTH);
		
		CountryWindow.setVisible(true);
		
		
		
		
		
		//stub code
		
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
	
	
	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("국가"))
			{
				NationalStockScreen nsc = new NationalStockScreen();
			}
			else if(e.getActionCommand().equals("지역"))
			{
				LocalStockScreen lsc = new LocalStockScreen();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "프로그램 오류 발생(코드 201)");
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
