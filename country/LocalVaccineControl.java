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
		
		
		selectCompany.addItem("-----��� ȸ�� ����------");
		selectCompany.addItem("AZ");
		selectCompany.addItem("Pfizer");
		selectCompany.addItem("Moderna");
		selectCompany.addItem("ChadOx1");
		selectCompany.addItem("Yansen");
		
		upPanel.add(selectCompany,BorderLayout.NORTH);
		
		
		
		
		selectLoc = new JComboBox();
		
		selectLoc.addItem("-----���� ����-----");
		selectLoc.addItem("����");
		selectLoc.addItem("���");
		selectLoc.addItem("�λ�");
		selectLoc.addItem("��õ");
		selectLoc.addItem("�뱸");
		selectLoc.addItem("����");
		selectLoc.addItem("����");
		selectLoc.addItem("���");
		selectLoc.addItem("���");
		selectLoc.addItem("�泲");
		selectLoc.addItem("���");
		selectLoc.addItem("�泲");
		selectLoc.addItem("����");
		selectLoc.addItem("����");
		selectLoc.addItem("����");
		selectLoc.addItem("����");
		selectLoc.addItem("����");
		
		
		
		
		upPanel.add(selectLoc,BorderLayout.SOUTH);
		
		
		this.add(upPanel,BorderLayout.NORTH);
		JLabel LocArcLbl = new JLabel();
		LocArcLbl.setText("�Ҵ��� ��� ���� �Է�");
		this.add(LocArcLbl,BorderLayout.WEST);
		
		LocArc = new JTextField();
		
		this.add(LocArc,BorderLayout.CENTER);
		
		JButton Allowcate = new JButton("�Ҵ�");
		Allowcate.addActionListener(this);
		this.add(Allowcate,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		VaccineSTCClass st = null;
		if(e.getActionCommand().equals("�Ҵ�"))
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
				JOptionPane.showMessageDialog(null, "����: ���� ���Ե��� ���� ����Դϴ�.");
				st.setChadOx1Stock(Integer.parseInt(LocArc.getText()));

			}
			else if(selectCompany.getSelectedItem().toString().equals("Yansen"))
			{
				st.setYansenStock(Integer.parseInt(LocArc.getText()));

			}
			System.out.println(st.getAZStock());
			LocalStockScreen.data.put(selectLoc.getSelectedItem().toString(),st);
			JOptionPane.showMessageDialog(null, "����� �Ҵ��Ͽ����ϴ�.");
		}
	}
	
}
