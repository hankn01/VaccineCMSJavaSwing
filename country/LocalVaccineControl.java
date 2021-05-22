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
		super("지역별 재고 할당");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(new BorderLayout());
		
		JComboBox selectCompany = new JComboBox();
		this.add(selectCompany,BorderLayout.NORTH);
		
		JTextArea LocArc = new JTextArea();
		LocArc.setText("지역 및 수량 입력");
		this.add(LocArc,BorderLayout.CENTER);
		
		JButton Allowcate = new JButton("할당");
		
		this.add(Allowcate,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	
	
}
