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

	
	
	//클래스 연동 전까지 임시로 사용하는 스텁 변수입니다.	
	/**
	 * 
	 */

	private static int VaccinePopulation;
	private static int AZ;
	private static int Pfizer;
	private static int Moderna;
	private static int Sputnik_V;
	private static int Janssen;
	//임시 변수 끝
	
	public LocalStockScreen()
	{
		super("지역별 재고 현황 및 접종 현황");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JComboBox SelectLocation = new JComboBox();
		SelectLocation.setToolTipText("지역 선택 드롭다운 메뉴");
		SelectLocation.addItem("서울");
		SelectLocation.addItem("경기");
		SelectLocation.addItem("인천");
		SelectLocation.addItem("부산");
		SelectLocation.addItem("대구");
		SelectLocation.addItem("대전");
		SelectLocation.addItem("울산");
		
		SelectLocation.addItem("광주");
		SelectLocation.addItem("세종");
		SelectLocation.addItem("충북");
		SelectLocation.addItem("충남");
		SelectLocation.addItem("경북");
		SelectLocation.addItem("경남");
		SelectLocation.addItem("강원");
		SelectLocation.addItem("제주");
		SelectLocation.addItem("전북");
		SelectLocation.addItem("전남");
		
		
		add(SelectLocation,BorderLayout.NORTH);
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		JLabel selectLocation = new JLabel();
		selectLocation.setText("지역을 선택하여 주십시오.");
		
		JLabel result = new JLabel();
		result.setText("<html>선택 지역의 백신 현황입니다.<br>백신 접종 장소:<br>백신 접종 인구:<br>백신 접종률:<br>연령대별 접종률:<br>남은 백신: <br></html>");
		
		JButton controlLocal = new JButton("지역별 재고 할당 및 지역 백신 관리");
		controlLocal.addActionListener(new ListenerClass());
		controlLocal.setActionCommand("관리");
		
		
		downPanel.add(selectLocation,BorderLayout.NORTH);
		downPanel.add(result,BorderLayout.CENTER);
		downPanel.add(controlLocal,BorderLayout.SOUTH);
		
		
		this.add(downPanel);
		

		
		this.setVisible(true);
		
	}

	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("관리"))
			{
				LocalVaccineControl lvc = new LocalVaccineControl();
			}
		}
		
	}
	
	
	
	
}
