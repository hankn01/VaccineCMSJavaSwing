import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NationalStockScreen extends JFrame{
	
	
	
	
	//Ŭ���� ���� ������ �ӽ÷� ����ϴ� ���� �����Դϴ�.	
	/**
	 * 
	 */

	private static int VaccinePopulation;
	private static int AZ;
	private static int Pfizer;
	private static int Moderna;
	private static int Sputnik_V;
	private static int Janssen;
	//�ӽ� ���� ��
	
	public NationalStockScreen ()
	{
		super("���� ��� ��� ��Ȳ �� ���� ��Ȳ");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JLabel Population = new JLabel();
		Population.setText("���� ��� ���� �α�: ");
		
		JLabel NatStock = new JLabel();
		NatStock.setText("<html>���� ��� ���(ȸ�纰): <br>AZ: <br>Pfizer: <br>Moderna: <br> </html>");
		
		JButton NatControl = new JButton("��� ����");
		NatControl.addActionListener(new ListenerClass());
		
		NatControl.setActionCommand("��������");
		
		add(Population,BorderLayout.NORTH);
		add(NatStock,BorderLayout.CENTER);
		add(NatControl,BorderLayout.SOUTH);
		

		
		this.setVisible(true);
		
	}
	
	
	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("��������"))
			{
				NationalVaccineControl nvc = new NationalVaccineControl();
			}
		}
		
	}
	
	
}
