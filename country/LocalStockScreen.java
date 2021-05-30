package country;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class LocalStockScreen extends JFrame{

	
	
	static HashMap<String, VaccineSTCClass> data = new HashMap<String, VaccineSTCClass>();

	private static int VaccinePopulation;
	private static int AZ;
	private static int Pfizer;
	private static int Moderna;
	private static int Sputnik_V;
	private static int Janssen;	
	JComboBox SelectLocation = null;
	JLabel res = null;
	public LocalStockScreen()
	{
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image prgImg = toolkit.getImage("programIcon.png");
		this.setIconImage(prgImg);
		this.setResizable(false);
		
		
		res = new JLabel("<html>찾는 지역을 선택 후 확인 버튼을 클릭해 주세요.<br>할당 시에는 지역 할당/관리 버튼을 누르세요.</html>");
		
		
		
		SelectLocation = new JComboBox();
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
		downPanel.setLayout(new FlowLayout());
		
		JLabel selectLocation = new JLabel();
		selectLocation.setText("백신 접종 지역을 선택하여 주십시오.");
		
		JLabel result = new JLabel();
		
		JButton OK = new JButton("확인");
		OK.addActionListener(new ListenerClass());
		OK.setActionCommand("확인");
		
		JButton controlLocal = new JButton("지역 할당/관리");
		controlLocal.addActionListener(new ListenerClass());
		controlLocal.setActionCommand("지역");
		
		JButton fileSave = new JButton("현재 할당을 파일로 저장");
		fileSave.addActionListener(new ListenerClass());
		fileSave.setActionCommand("저장");
		
		downPanel.add(selectLocation);
		downPanel.add(result);
		downPanel.add(OK);
		downPanel.add(controlLocal);
		
		
		this.add(downPanel);
		downPanel.add(res);
		downPanel.add(fileSave);
		
		File file = new File("LocalData.dat");
		if(file.exists())
		{
			FileInputStream fin = null;
			try {
				fin = new FileInputStream("LocalData.dat");
				
				ObjectInputStream din = new ObjectInputStream(fin);
				
				data = (HashMap<String, VaccineSTCClass>)din.readObject();
				fin.close();
				din.close();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
		this.setVisible(true);
		
	}

	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("지역"))
			{
				LocalVaccineControl lvc = new LocalVaccineControl();
			}
			else if(e.getActionCommand().equals("확인"))
			{
				System.out.println(SelectLocation.getSelectedItem().toString());
				System.out.println(data.get(SelectLocation.getSelectedItem().toString()).getAZStock());
				
				if(data.containsKey(SelectLocation.getSelectedItem().toString()))
				{
					res.setText("아스트라제네카(AZ):"+data.get(SelectLocation.getSelectedItem().toString()).getAZStock()+", 모더나:"+data.get(SelectLocation.getSelectedItem().toString()).getModernaStock()+", 화이자: "+data.get(SelectLocation.getSelectedItem().toString()).getPfizerStock()+", 얀센: "+data.get(SelectLocation.getSelectedItem().toString()).getYansenStock()+"ChadOx1"+data.get(SelectLocation.getSelectedItem().toString()).getChadOx1Stock());
						
					
					
				
				}
				else if(data.get(SelectLocation.getSelectedItem().toString()) == null)
					JOptionPane.showMessageDialog(null, "항목이 존재하지 않습니다.");
				else
					JOptionPane.showMessageDialog(null, "항목이 존재하지 않습니다.");
				
			}
			else if(e.getActionCommand().equals("저장"))
			{
				FileOutputStream fst = null;
				try {
					fst = new FileOutputStream("LocalData.dat");
					ObjectOutputStream ds = new ObjectOutputStream(fst);
					ds.writeObject(data);
					ds.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "파일 저장 중 오류가 발생하였습니다. 프로그램을 다시 실행하거나 관리자에게 문의하세요.");
					e1.printStackTrace();
				}
				
			}
		}
		
	}
	
	public static HashMap<String, VaccineSTCClass> getData()
	{
		return data;
	}
	
	
}
