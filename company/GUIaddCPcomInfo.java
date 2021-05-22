package company;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIaddCPcomInfo extends JFrame {
	
	Dimension frameSize = this.getSize(); // ������ ������
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ������
	TextAdaptor TA = new TextAdaptor();


	
	
	public GUIaddCPcomInfo()  {
		

	setTitle("ȸ�� ���� �߰�");
	setLayout(new BorderLayout());
	setSize(400, 400);
	setResizable(false);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);


	JPanel form = new JPanel();
	form.setLayout(new GridLayout(9,2,5,5));
	add(form ,BorderLayout.CENTER);
	
	
	setTitle("ȸ�� ���� �߰�");

	
	JLabel l1 = new JLabel("ȸ���̸�");
	JLabel l2 = new JLabel("CEO");
	JLabel l3 = new JLabel("������");
	JLabel l4 = new JLabel("������ġ");
	JLabel l5 = new JLabel("��� ��");
	JLabel l6 = new JLabel("��Ź��û���");
	JLabel l7 = new JLabel("���");
	JLabel l8 = new JLabel("�Ѵ� ��� ���귮");
	//JLabel l9 = new JLabel("�Ǹ� ����");
	JLabel l99 = new JLabel("(�Է� ����:�̱�.�߱�.��������)");
	JPanel l999 = new JPanel();
	l999.setLayout(new GridLayout(2,1));
	//l999.add(l9);
	//l999.add(l99);
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();

	JTextField t4 = new JTextField();
	JTextField t5 = new JTextField();
	JTextField t6 = new JTextField();
	//JTextField t7 = new JTextField();
	String [] vaccinelist = {"Moderna", "Pfizer", "AZ", "Yansen", "ChadOx1"};
	JComboBox t7 = new JComboBox(vaccinelist);
	JTextField t8 = new JTextField();
	JTextArea t99 = new JTextArea(3, 10);
	JScrollPane t9 = new JScrollPane(t99);
	form.add(l1);
	form.add(t1);
	form.add(l2);
	form.add(t2);
	form.add(l3);
	JPanel date = new JPanel();
	JTextField month = new JTextField(2);
	month.setText("2");
	date.add(month);
	JTextField day = new JTextField(2);
	day.setText("11");
	date.add(day);
	JTextField year = new JTextField(4);
	year.setText("2000");
	date.add(year);
	form.add(date);
	form.add(l4);
	form.add(t4);
	form.add(l5);
	form.add(t5);
	form.add(l6);
	form.add(t6);
	form.add(l7);
	form.add(t7);
	form.add(l8);
	form.add(t8);
	form.add(l999);
	//form.add(t9);

	
	

	

	JPanel insertpanel = new JPanel();
	insertpanel.setLayout(new FlowLayout());
	JButton insert = new JButton("����");
	insert.addActionListener(new ActionListener() {


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(!(TA.stringisdisit(t8.getText())) || !(TA.stringisdisit(t5.getText())) || !(TA.stringisdisit(month.getText()))
					|| !(TA.stringisdisit(day.getText())) || !(TA.stringisdisit(year.getText()))) {
				JOptionPane.showMessageDialog(null, "������ �Ǵ�\n�Ѵ޹�Ż��귮\n�Ǵ� ��� ����\n���ڸ� �Է��Ͻÿ�.");
				
			}else {
			
			try {
				String filePath = "ȸ�絥����.txt";
				File file = new File(filePath);
				if(!file.exists()) {
					file.createNewFile();
				}
				BufferedWriter bos = new BufferedWriter(new FileWriter(file,true));
				bos.write("��Ź������-");
				bos.write(t1.getText()+"-"); //ȸ���̸�
				bos.write(t7.getSelectedItem()+"/"+t6.getText()+"-"); //���(��Ź�����û���)
				bos.write(" -"); // �Ǹű���
				bos.write(t8.getText()+"-"); // �Ѵ޹�Ż��귮
				bos.write(t2.getText()+"-"); //CEO
				bos.write(month.getText()+"/"+day.getText()+"/"+year.getText()+"-"); //������
				bos.write(t4.getText()+"-"); //���� ��ġ
				bos.write(t5.getText()+"\r\n"); //��� ��
				bos.close();
				TA.readtext();
				JOptionPane.showMessageDialog(null, "���� �Ϸ�");
				GUICompanyMain.model.setNumRows(0);
				try {
						String s;
						String[] array;
						BufferedReader reader = new BufferedReader(new FileReader(file));
						while((s=reader.readLine()) != null) {
							
							array=s.split("-");
							GUICompanyMain.model.addRow(array);
						}
						reader.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				dispose();	
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "���� ����");
			}	
		}
		}
	});
	insertpanel.add(insert);
	add(insertpanel, BorderLayout.SOUTH);
	}
	
	

}
