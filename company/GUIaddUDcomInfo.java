package company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;

public class GUIaddUDcomInfo extends JFrame implements ActionListener{

	public GUIaddUDcomInfo() {

		setTitle("ȸ�� ���� �߰�");
		setLayout(new BorderLayout());
		setSize(400, 300);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel form = new JPanel();
		form.setLayout(new GridLayout(7,2,5,5));
		add(form ,BorderLayout.CENTER);
		
		
		setTitle("ȸ�� ���� �߰�");


		JLabel l1 = new JLabel("ȸ���̸�");
		JLabel l2 = new JLabel("CEO");
		JLabel l3 = new JLabel("������");
		JLabel l4 = new JLabel("������ġ");
		JLabel l5 = new JLabel("��� ��");
		JLabel l7 = new JLabel("�������� ��� �̸�");
		JLabel l8 = new JLabel("��� ���� �ܰ�");
		
		
		
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		JTextField t7 = new JTextField();
		String [] num = {"�ӻ� 1�ܰ�", "�ӻ� 2�ܰ�", "�ӻ� 3�ܰ�"};
		JComboBox t8 = new JComboBox(num);
		
		
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
		form.add(l7);
		form.add(t7);
		form.add(l8);
		form.add(t8);
		
		

		JPanel insertpanel = new JPanel();
		insertpanel.setLayout(new FlowLayout());
		JButton insert = new JButton("����");
		insert.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String filePath = "C:\\Users\\������\\eclipse-workspace\\Teamp\\src\\company\\ȸ�絥����.txt";
					File file = new File(filePath);
					if(!file.exists()) {
						file.createNewFile();
					}
					BufferedWriter bos = new BufferedWriter(new FileWriter(file,true));
					bos.write("����ӻ�ܰ���-");
					bos.write(t1.getText()+"-");
					bos.write(t7.getText()+"/"+t8.getSelectedItem()+"-");
					bos.write(" -"); //�Ǹű��� x
					bos.write(" -"); //�Ѵ� ���귮 x
					bos.write(t2.getText()+"-"); //ceo
					bos.write(month.getText()+"/"+day.getText()+"/"+year.getText()+"-"); // ������
					bos.write(t4.getText()+"-"); // ������ġ
					bos.write(t5.getText()+"\r\n"); //��� ��
					bos.close();
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
		});
		insertpanel.add(insert);
		add(insertpanel, BorderLayout.SOUTH);

		

		}
		
		


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
