import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class NationalVaccineControl extends JFrame{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 150;
	
	public NationalVaccineControl()
	{
		
		super("백신 관리");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(new BorderLayout());
		
		JLabel Inst = new JLabel();
		Inst.setText("백신을 도입하거나, 유효기간이 만료된 백신 또는 불량 백신을 폐기합니다.");
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		JComboBox selectCompany = new JComboBox();
		downPanel.add(selectCompany,BorderLayout.NORTH);
		
		JTextField Amount = new JTextField();
		downPanel.add(Amount,BorderLayout.CENTER);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new BorderLayout());
		JButton Intro = new JButton("백신 도입");
		ButtonPanel.add(Intro,BorderLayout.WEST);
		
		JButton Dispose = new JButton("백신 폐기");
		ButtonPanel.add(Dispose,BorderLayout.EAST);
		
		downPanel.add(ButtonPanel,BorderLayout.SOUTH);
		
		
		this.add(Inst,BorderLayout.NORTH);
		this.add(downPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	
	
}
