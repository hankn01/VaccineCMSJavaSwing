package country;
import javax.swing.JFrame;
import javax.swing.JPanel;

import company.GUICompanyMain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NationalStockScreen extends JFrame{
	
	
	
	
	

	private static int VaccinePopulation;
	private static int AZ;
	private static int Pfizer;
	private static int Moderna;
	private static int Sputnik_V;
	private static int Janssen;

	
	public NationalStockScreen ()
	{
		super();
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JLabel Population = new JLabel();
		Population.setText("인구 수: ");
		
		JLabel NatStock = new JLabel();
		NatStock.setText("<br>AZ: <br>Pfizer: <br>Moderna: <br> </html>");
		
		
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		JButton CompanyButton = new JButton("회사");
		CompanyButton.addActionListener(new ListenerClass());
		
		downPanel.add(CompanyButton,BorderLayout.NORTH);
		
		JButton NatControl = new JButton("국가 관리");
		NatControl.addActionListener(new ListenerClass());
		
		downPanel.add(NatControl,BorderLayout.SOUTH);
		
		
		
		
		NatControl.setActionCommand("회사");
		CompanyButton.setActionCommand("국가");
		add(Population,BorderLayout.NORTH);
		add(NatStock,BorderLayout.CENTER);
		add(downPanel,BorderLayout.SOUTH);
		
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
