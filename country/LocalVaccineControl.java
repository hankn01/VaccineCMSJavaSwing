package country;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
public class LocalVaccineControl extends JFrame{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 150;
	
	public LocalVaccineControl()
	{
		super("������ ��� �Ҵ�");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(new BorderLayout());
		
		JComboBox selectCompany = new JComboBox();
		this.add(selectCompany,BorderLayout.NORTH);
		
		JTextArea LocArc = new JTextArea();
		LocArc.setText("���� �� ���� �Է�");
		this.add(LocArc,BorderLayout.CENTER);
		
		JButton Allowcate = new JButton("�Ҵ�");
		
		this.add(Allowcate,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	
	
}
