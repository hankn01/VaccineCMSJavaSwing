package country;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class LocalVaccineControl extends JFrame implements ActionListener{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 150;
	JComboBox selectLoc = null;
	JComboBox selectCompany = null;
	JTextField LocArc = null;
	public LocalVaccineControl()
	{
		super("");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(new BorderLayout());
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image prgImg = toolkit.getImage("programIcon.png");
		this.setIconImage(prgImg);
		this.setResizable(false);
		
		
		
		
		
		JPanel upPanel = new JPanel();
		upPanel.setLayout(new BorderLayout());
		
		selectCompany = new JComboBox();
		
		
		selectCompany.addItem("-----백신 회사 선택------");
		selectCompany.addItem("AZ");
		selectCompany.addItem("Pfizer");
		selectCompany.addItem("Moderna");
		selectCompany.addItem("ChadOx1");
		selectCompany.addItem("Yansen");
		
		upPanel.add(selectCompany,BorderLayout.NORTH);
		
		
		
		
		selectLoc = new JComboBox();
		
		selectLoc.addItem("-----지역 선택-----");
		selectLoc.addItem("서울");
		selectLoc.addItem("경기");
		selectLoc.addItem("부산");
		selectLoc.addItem("인천");
		selectLoc.addItem("대구");
		selectLoc.addItem("대전");
		selectLoc.addItem("세종");
		selectLoc.addItem("울산");
		selectLoc.addItem("충북");
		selectLoc.addItem("충남");
		selectLoc.addItem("경북");
		selectLoc.addItem("경남");
		selectLoc.addItem("제주");
		selectLoc.addItem("강원");
		selectLoc.addItem("광주");
		selectLoc.addItem("전북");
		selectLoc.addItem("전남");
		
		
		
		
		upPanel.add(selectLoc,BorderLayout.SOUTH);
		
		
		this.add(upPanel,BorderLayout.NORTH);
		JLabel LocArcLbl = new JLabel();
		LocArcLbl.setText("할당할 백신 수량 입력");
		this.add(LocArcLbl,BorderLayout.WEST);
		
		LocArc = new JTextField();
		
		this.add(LocArc,BorderLayout.CENTER);
		
		JButton Allowcate = new JButton("할당");
		Allowcate.addActionListener(this);
		this.add(Allowcate,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		VaccineSTCClass st = null;
		if(e.getActionCommand().equals("할당"))
		{
			
			if(!LocalStockScreen.data.containsKey(selectLoc.getSelectedItem().toString()))
			{
				st = new VaccineSTCClass(selectLoc.getSelectedItem().toString());
			}
			else
			{
				st = LocalStockScreen.data.get(selectLoc.getSelectedItem().toString());
			}
			if(selectCompany.getSelectedItem().toString().equals("AZ"))
			{
				st.setAZStock(Integer.parseInt(LocArc.getText()));
							
			}
			else if(selectCompany.getSelectedItem().toString().equals("Moderna"))
			{
				st.setModernaStock(Integer.parseInt(LocArc.getText()));

			}
			else if(selectCompany.getSelectedItem().toString().equals("Pfizer"))
			{
				st.setPfizerStock(Integer.parseInt(LocArc.getText()));

			}
			else if(selectCompany.getSelectedItem().toString().equals("ChadOx1"))
			{
				JOptionPane.showMessageDialog(null, "주의: 현재 도입되지 않은 백신입니다.");
				st.setChadOx1Stock(Integer.parseInt(LocArc.getText()));

			}
			else if(selectCompany.getSelectedItem().toString().equals("Yansen"))
			{
				st.setYansenStock(Integer.parseInt(LocArc.getText()));

			}
			System.out.println(st.getAZStock());
			LocalStockScreen.data.put(selectLoc.getSelectedItem().toString(),st);
			JOptionPane.showMessageDialog(null, "백신을 할당하였습니다.");
		}
	}
	
}
