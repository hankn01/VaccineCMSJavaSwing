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
		super("��ž���� PRO - ���� ��� ��Ȳ");
	
		JFrame CountryWindow = new JFrame();
		CountryWindow.setSize(WIDTH, HEIGHT);
		CountryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CountryWindow.setLayout(new BorderLayout());
		
		JLabel CountryName = new JLabel();
		CountryName.setText("������ : "+"���ѹα�(Republic of Korea)");
		
		
		JLabel CurrentBudget = new JLabel();
		CurrentBudget.setText("���� ����(�ڷγ� 19 ��� ��) :\n"+"�׽�Ʈ �޷�");
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		
		JButton NationStock = new JButton("���� ��� ��Ȳ");
		
		JButton LocalStock = new JButton("������ ��� ��Ȳ");
		
		NationStock.addActionListener(new ListenerClass());
		NationStock.setActionCommand("����");
		LocalStock.addActionListener(new ListenerClass());
		LocalStock.setActionCommand("����");
		
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
			if(e.getActionCommand().equals("����"))
			{
				NationalStockScreen nsc = new NationalStockScreen();
			}
			else if(e.getActionCommand().equals("����"))
			{
				LocalStockScreen lsc = new LocalStockScreen();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "���α׷� ���� �߻�(�ڵ� 201)");
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
