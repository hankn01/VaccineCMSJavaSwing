import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NationalStockScreen extends JFrame{
	
	
	
	
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
	
	public NationalStockScreen ()
	{
		super("전국 백신 재고 현황 및 접종 현황");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JLabel Population = new JLabel();
		Population.setText("현재 백신 접종 인구: ");
		
		JLabel NatStock = new JLabel();
		NatStock.setText("<html>전국 백신 재고(회사별): <br>AZ: <br>Pfizer: <br>Moderna: <br> </html>");
		
		JButton NatControl = new JButton("백신 관리");
		NatControl.addActionListener(new ListenerClass());
		
		NatControl.setActionCommand("국가관리");
		
		add(Population,BorderLayout.NORTH);
		add(NatStock,BorderLayout.CENTER);
		add(NatControl,BorderLayout.SOUTH);
		

		
		this.setVisible(true);
		
	}
	
	
	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("국가관리"))
			{
				NationalVaccineControl nvc = new NationalVaccineControl();
			}
		}
		
	}
	
	
}
