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
	
	public LocalStockScreen()
	{
		super("������ ��� ��Ȳ �� ���� ��Ȳ");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JComboBox SelectLocation = new JComboBox();
		SelectLocation.setToolTipText("���� ���� ��Ӵٿ� �޴�");
		
		
		
		add(SelectLocation,BorderLayout.NORTH);
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		
		JLabel selectLocation = new JLabel();
		selectLocation.setText("������ �����Ͽ� �ֽʽÿ�.");
		
		JLabel result = new JLabel();
		result.setText("<html>���� ������ ��� ��Ȳ�Դϴ�.<br>��� ���� ���:<br>��� ���� �α�:<br>��� ������:<br>���ɴ뺰 ������:<br></html>");
		
		JButton controlLocal = new JButton("������ ��� �Ҵ� �� ���� ��� ����");
		controlLocal.addActionListener(new ListenerClass());
		controlLocal.setActionCommand("����");
		
		
		downPanel.add(selectLocation,BorderLayout.NORTH);
		downPanel.add(result,BorderLayout.CENTER);
		downPanel.add(controlLocal,BorderLayout.SOUTH);
		
		
		this.add(downPanel);
		

		
		this.setVisible(true);
		
	}

	class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("����"))
			{
				LocalVaccineControl lvc = new LocalVaccineControl();
			}
		}
		
	}
	
	
	
	
}
