package company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIaddHavevaccineComInfo extends JFrame {

	public GUIaddHavevaccineComInfo(){

		setTitle("회사 정보 추가");
		setLayout(new BorderLayout());
		setSize(400, 320);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel form = new JPanel();
		form.setLayout(new GridLayout(8,2,5,5));
		add(form ,BorderLayout.CENTER);
		
		
		setTitle("회사 정보 추가");


		JLabel l1 = new JLabel("회사이름");
		JLabel l2 = new JLabel("백신");
		JLabel l3 = new JLabel("판매 국가");
		JLabel l33 = new JLabel("(입력 예시:미국/중국/유럽연합)");
		JPanel l333 = new JPanel();
		l333.setLayout(new GridLayout(2,1));
		l333.add(l3);
		l333.add(l33);
		JLabel l4 = new JLabel("한달 백신 생산량");
		JLabel l5 = new JLabel("CEO");
		JLabel l6 = new JLabel("설립일");
		JLabel l7 = new JLabel("본사위치");
		JLabel l8 = new JLabel("사원 수");
		
		
		
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		//JTextField t3 = new JTextField();
		JTextArea t33 = new JTextArea(3, 10);
		JScrollPane t3 = new JScrollPane(t33);
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		
		JTextField t7 = new JTextField();
		JTextField t8 = new JTextField();
		
		
		form.add(l1);
		form.add(t1);
		form.add(l2);
		form.add(t2);
		form.add(l333);
		form.add(t3);
		form.add(l4);
		form.add(t4);
		form.add(l5);
		form.add(t5);
		form.add(l6);
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
		form.add(l7);
		form.add(t7);
		form.add(l8);
		form.add(t8);
		
		JPanel insertpanel = new JPanel();
		insertpanel.setLayout(new FlowLayout());
		JButton insert = new JButton("저장");
		insertpanel.add(insert);
		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				try {
					String filePath = "C:\\Users\\배지훈\\eclipse-workspace\\Teamp\\src\\company\\회사데이터.txt";
					File file = new File(filePath);
					if(!file.exists()) {
						file.createNewFile();
					}
					BufferedWriter bos = new BufferedWriter(new FileWriter(file,true));
					bos.write("백신개발생산기업-");
					bos.write(t1.getText()+"-");
					bos.write(t2.getText()+"-");
					bos.write(t33.getText()+"-"); 
					bos.write(t4.getText()+"-"); 
					bos.write(t5.getText()+"-"); //ceo
					bos.write(month.getText()+"/"+day.getText()+"/"+year.getText()+"-"); // 설립일
					bos.write(t7.getText()+"-"); // 본사위치
					bos.write(t8.getText()+"\r\n"); //사원 수
					bos.close();
					JOptionPane.showMessageDialog(null, "저장 완료");
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
					JOptionPane.showMessageDialog(null, "저장 실패");
				}
			}
		});
		insertpanel.add(insert);
		add(insertpanel, BorderLayout.SOUTH);
		}

	}
