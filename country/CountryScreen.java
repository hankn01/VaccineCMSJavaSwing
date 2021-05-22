package country;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CountryScreen extends JFrame{

	public static final int WIDTH = 250;
	public static final int HEIGHT = 120;
	
	public CountryScreen()
	{
		super("백신어딨어 PRO - 현재 백신 현황");
	
		JFrame CountryWindow = new JFrame();
		CountryWindow.setSize(WIDTH, HEIGHT);
		CountryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CountryWindow.setLayout(new BorderLayout());
		
		JLabel CountryName = new JLabel();
		CountryName.setText("국가명 : "+"대한민국(Republic of Korea)");
		
		
		JLabel CurrentBudget = new JLabel();
		CurrentBudget.setText("현재 예산(코로나 19 백신 편성) :\n"+"테스트 달러");
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		
		JButton NationStock = new JButton("전국 재고 현황");
		
		JButton LocalStock = new JButton("지역별 재고 현황");
		
		NationStock.addActionListener(new ListenerClass());
		NationStock.setActionCommand("국가");
		LocalStock.addActionListener(new ListenerClass());
		LocalStock.setActionCommand("지역");
		
		CountryWindow.add(CountryName,BorderLayout.NORTH);
		CountryWindow.add(CurrentBudget,BorderLayout.CENTER);
		downPanel.add(NationStock,BorderLayout.WEST);
		downPanel.add(LocalStock,BorderLayout.EAST);
		
		CountryWindow.add(downPanel,BorderLayout.SOUTH);
		
		CountryWindow.setVisible(true);
		
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
