package country;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocalStockScreen extends JFrame{

	
	


	private static int VaccinePopulation;
	private static int AZ;
	private static int Pfizer;
	private static int Moderna;
	private static int Sputnik_V;
	private static int Janssen;	
	public LocalStockScreen()
	{
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JComboBox SelectLocation = new JComboBox();
		SelectLocation.setToolTipText("---지역을 선택하여 주십시오.----");
		SelectLocation.addItem("서울");
		SelectLocation.addItem("경기");
		SelectLocation.addItem("부산");
		SelectLocation.addItem("인천");
		SelectLocation.addItem("대구");
		SelectLocation.addItem("대전");
		SelectLocation.addItem("세종");
		SelectLocation.addItem("울산");
		SelectLocation.addItem("충북");
		SelectLocation.addItem("충남");
		SelectLocation.addItem("경북");
		SelectLocation.addItem("경남");
		SelectLocation.addItem("제주");
		SelectLocation.addItem("강원");
		SelectLocation.addItem("광주");
		SelectLocation.addItem("전북");
		SelectLocation.addItem("전남");
		
		
		
		add(SelectLocation,BorderLayout.NORTH);
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		JLabel selectLocation = new JLabel();
		selectLocation.setText("백신 접종 지역을 선택하여 주십시오.");
		
		JLabel result = new JLabel();
		
		JButton controlLocal = new JButton("지역 할당/관리");
		controlLocal.addActionListener(new ListenerClass());
		controlLocal.setActionCommand("지역");
		
		
		downPanel.add(selectLocation,BorderLayout.NORTH);
		downPanel.add(result,BorderLayout.CENTER);
		downPanel.add(controlLocal,BorderLayout.SOUTH);
		
		
		this.add(downPanel);
		

		
		this.setVisible(true);
		
	}

	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("지역"))
			{
				LocalVaccineControl lvc = new LocalVaccineControl();
			}
		}
		
	}
	
	
	
	
}
