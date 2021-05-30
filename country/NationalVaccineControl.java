package country;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import company.GUICompanyMain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class NationalVaccineControl extends JFrame implements ActionListener{
	public static final int WIDTH = 450;
	public static final int HEIGHT = 250;
	VaccineSTCClass temp = null;
	JComboBox selectCompany = null;
	JTextField Amount = null;
	JTextField DInput = null;
	JTextField VacNum = null;
	JTextField EDInput = null;
	HashMap<String, VaccineSTCClass> STCdata = null;
	public NationalVaccineControl()
	{
		
		super("��� ����");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(new BorderLayout());
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image prgImg = toolkit.getImage("programIcon.png");
		setIconImage(prgImg);
		setResizable(false);
		
		
		
		File file = new File("NationalVaccinedata.dat");
		if(file.exists())
		{
		try {
			FileInputStream fin = new FileInputStream(file);
			
			ObjectInputStream oin = new ObjectInputStream(fin);
			STCdata = (HashMap<String, VaccineSTCClass>)oin.readObject();
			
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		}
		else
		{
			STCdata = new HashMap<String, VaccineSTCClass>();
		}
		
		JLabel Inst = new JLabel();
		Inst.setText("<html>����� ��� �� �ʿ��� �з���ŭ �����մϴ�.<br>��� ���� ȸ�縦 �����ϰ� ���� ������ �뷮, ���� ��¥�� �Է��� �ּ���.</html>");
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		selectCompany = new JComboBox();
		
		FileInputStream inpfile;
		try {
			inpfile = new FileInputStream("ȸ�絥����.txt");
			Scanner scan = new Scanner(inpfile);
			scan.useDelimiter("-");
			while(scan.hasNext())
			{
				
				String[] inp_temp;
				String input = scan.nextLine();
				inp_temp = input.split("-");
				if(inp_temp[0].equals("��Ű��߻�����"))
				{
				String type = inp_temp[1];
				String ts = inp_temp[2];
				selectCompany.addItem(type+"|"+ts);
				}
				else if(inp_temp[0].equals("��Ź������"))
				{
					String type = inp_temp[1];
					String ts = inp_temp[2];
					String res = ts.split("/")[0];
	
					selectCompany.addItem(type+"|"+res);
				}
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found.");
			JOptionPane.showMessageDialog(null,"������ ã�� �� �����ϴ�. (���� �ڵ� 401)", "���� ����",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		
		
		
		
		downPanel.add(selectCompany,BorderLayout.NORTH);
		
		
		JPanel form = new JPanel();
		form.setLayout(new GridLayout(5,2));
		
		JLabel c1 = new JLabel();
		c1.setText("���� ���ڿ� ���� ���ڴ�");
		form.add(c1);
		
		JLabel c2 = new JLabel();
		c2.setText("'��/��/��' �������� �Է��մϴ�.");
		form.add(c2);
		
		JLabel VacNumLbl = new JLabel();
		VacNumLbl.setText("��� ����:");
		form.add(VacNumLbl);
		
		VacNum = new JTextField();
		form.add(VacNum);
		JLabel AmtLbl = new JLabel();
		AmtLbl.setText("��� �뷮:");
		form.add(AmtLbl);
		
		Amount = new JTextField();
		form.add(Amount,BorderLayout.NORTH);
		
		
		JLabel DInputLabel = new JLabel();
		DInputLabel.setText("��� ���� ��¥:");
		form.add(DInputLabel);
		
		DInput = new JTextField();
		form.add(DInput);
		
		JLabel EDInputLabel = new JLabel();
		EDInputLabel.setText("��� ���(����)����:");
		form.add(EDInputLabel);
		
		EDInput = new JTextField();
		form.add(EDInput);
		
		
		downPanel.add(form,BorderLayout.CENTER);
		
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new BorderLayout());
		JButton Intro = new JButton("��� ����");
		Intro.addActionListener(this);
		ButtonPanel.add(Intro,BorderLayout.CENTER);
		
		
		
		downPanel.add(ButtonPanel,BorderLayout.SOUTH);
		
		
		this.add(Inst,BorderLayout.NORTH);
		this.add(downPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("��� ����"))
		{
			
			
			
			/*
			temp = new VaccineSTCClass();
			
			String sel = null;
			int amt;
			sel = this.selectCompany.getSelectedItem().toString();
			amt = Integer.parseInt(this.Amount.getText());
			
			if(STCdata.containsKey(sel))
			{
				int originstock=STCdata.get(sel).getStock();
				temp.setName(sel);
				temp.setStock(originstock+amt);
				STCdata.replace(sel, temp);
			}
			else
			{
			temp.setName(sel);
			
			temp.setStock(amt);
			STCdata.put(sel, temp);
			}
			this.Amount.setText("");
			this.selectCompany.setSelectedIndex(0);
			
			try {
				FileOutputStream fout = new FileOutputStream("NationalVaccinedata.dat");
				ObjectOutputStream oout = new ObjectOutputStream(fout);
				
				oout.writeObject(STCdata);
			} catch (FileNotFoundException e1) {
				System.err.println("File Not Found.");
				JOptionPane.showMessageDialog(null,"������ ã�� �� �����ϴ�. (���� �ڵ� 401)", "���� ����",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (IOException e1) {
				System.err.println("File IOException.");
				JOptionPane.showMessageDialog(null,"���� ����� �����Դϴ�.(IOException) (���� �ڵ� 402)", "���� ����",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			*/
			String ts = selectCompany.getItemAt(selectCompany.getSelectedIndex()).toString();
			//System.out.println(ts);
			String[] temp = null;
			temp = ts.split("\\|");
			String filename = temp[1];
			//System.out.println(filename);
			//File file = new File("National"+filename+".txt");
			File f = new File("National"+filename+".txt");
			try {
				try (FileWriter fw = new FileWriter(f,true)) {
					fw.write(VacNum.getText()+"|"+Amount.getText()+"|"+DInput.getText()+"|"+EDInput.getText()+"\n");
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
		}
		else if(e.getActionCommand().equals("��� ���"))
		{
			temp = new VaccineSTCClass();
			
			String sel = null;
			int amt;
			sel = this.selectCompany.getSelectedItem().toString();
			amt = Integer.parseInt(this.Amount.getText());
			
			if(STCdata.containsKey(sel))
			{
				int originstock=STCdata.get(sel).getStock();
				temp.setName(sel);
				temp.setStock(originstock-amt);
				if(temp.getStock()<=0)
				{
					STCdata.remove(sel);
				}
				else
				{
				STCdata.replace(sel, temp);
				}
			}
			else
			{
			JOptionPane.showMessageDialog(null, "���� ���Ե��� ���� ����Դϴ�.");
			}
			this.Amount.setText("");
			this.selectCompany.setSelectedIndex(0);
			
			try {
				FileOutputStream fout = new FileOutputStream("NationalVaccinedata.dat");
				ObjectOutputStream oout = new ObjectOutputStream(fout);
				System.out.println(STCdata.get("�����").getStock());
				oout.writeObject(STCdata);
			} catch (FileNotFoundException e1) {
				System.err.println("File Not Found.");
				JOptionPane.showMessageDialog(null,"������ ã�� �� �����ϴ�. (���� �ڵ� 401)", "���� ����",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (IOException e1) {
				System.err.println("File IOException.");
				JOptionPane.showMessageDialog(null,"���� ����� �����Դϴ�.(IOException) (���� �ڵ� 402)", "���� ����",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			
		}
		
	}
	
}
