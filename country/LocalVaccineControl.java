package country;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
public class LocalVaccineControl extends JFrame{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 150;
	
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
		
		JComboBox selectCompany = new JComboBox();
		
		
		selectCompany.addItem("-----��� ȸ�� ����------");
		
		
		upPanel.add(selectCompany,BorderLayout.NORTH);
		
		
		
		
		JComboBox selectLoc = new JComboBox();
		
		selectLoc.addItem("-----���� ����-----");
		
		upPanel.add(selectLoc,BorderLayout.SOUTH);
		
		
		this.add(upPanel,BorderLayout.NORTH);
		JTextArea LocArc = new JTextArea();
		LocArc.setText("���� �Է�");
		this.add(LocArc,BorderLayout.CENTER);
		
		JButton Allowcate = new JButton("�Ҵ�");
		
		this.add(Allowcate,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	
	
}
