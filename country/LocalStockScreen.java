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
		
		
		res = new JLabel("<html>ã�� ������ ���� �� Ȯ�� ��ư�� Ŭ���� �ּ���.<br>�Ҵ� �ÿ��� ���� �Ҵ�/���� ��ư�� ��������.</html>");
		
		
		
		SelectLocation = new JComboBox();
		SelectLocation.setToolTipText("---������ �����Ͽ� �ֽʽÿ�.----");
		SelectLocation.addItem("����");
		SelectLocation.addItem("���");
		SelectLocation.addItem("�λ�");
		SelectLocation.addItem("��õ");
		SelectLocation.addItem("�뱸");
		SelectLocation.addItem("����");
		SelectLocation.addItem("����");
		SelectLocation.addItem("���");
		SelectLocation.addItem("���");
		SelectLocation.addItem("�泲");
		SelectLocation.addItem("���");
		SelectLocation.addItem("�泲");
		SelectLocation.addItem("����");
		SelectLocation.addItem("����");
		SelectLocation.addItem("����");
		SelectLocation.addItem("����");
		SelectLocation.addItem("����");
		
		
		
		add(SelectLocation,BorderLayout.NORTH);
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new FlowLayout());
		
		JLabel selectLocation = new JLabel();
		selectLocation.setText("��� ���� ������ �����Ͽ� �ֽʽÿ�.");
		
		JLabel result = new JLabel();
		
		JButton OK = new JButton("Ȯ��");
		OK.addActionListener(new ListenerClass());
		OK.setActionCommand("Ȯ��");
		
		JButton controlLocal = new JButton("���� �Ҵ�/����");
		controlLocal.addActionListener(new ListenerClass());
		controlLocal.setActionCommand("����");
		
		JButton fileSave = new JButton("���� �Ҵ��� ���Ϸ� ����");
		fileSave.addActionListener(new ListenerClass());
		fileSave.setActionCommand("����");
		
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
			if(e.getActionCommand().equals("����"))
			{
				LocalVaccineControl lvc = new LocalVaccineControl();
			}
			else if(e.getActionCommand().equals("Ȯ��"))
			{
				System.out.println(SelectLocation.getSelectedItem().toString());
				System.out.println(data.get(SelectLocation.getSelectedItem().toString()).getAZStock());
				
				if(data.containsKey(SelectLocation.getSelectedItem().toString()))
				{
					res.setText("�ƽ�Ʈ������ī(AZ):"+data.get(SelectLocation.getSelectedItem().toString()).getAZStock()+", �����:"+data.get(SelectLocation.getSelectedItem().toString()).getModernaStock()+", ȭ����: "+data.get(SelectLocation.getSelectedItem().toString()).getPfizerStock()+", �Ἶ: "+data.get(SelectLocation.getSelectedItem().toString()).getYansenStock()+"ChadOx1"+data.get(SelectLocation.getSelectedItem().toString()).getChadOx1Stock());
						
					
					
				
				}
				else if(data.get(SelectLocation.getSelectedItem().toString()) == null)
					JOptionPane.showMessageDialog(null, "�׸��� �������� �ʽ��ϴ�.");
				else
					JOptionPane.showMessageDialog(null, "�׸��� �������� �ʽ��ϴ�.");
				
			}
			else if(e.getActionCommand().equals("����"))
			{
				FileOutputStream fst = null;
				try {
					fst = new FileOutputStream("LocalData.dat");
					ObjectOutputStream ds = new ObjectOutputStream(fst);
					ds.writeObject(data);
					ds.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "���� ���� �� ������ �߻��Ͽ����ϴ�. ���α׷��� �ٽ� �����ϰų� �����ڿ��� �����ϼ���.");
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
