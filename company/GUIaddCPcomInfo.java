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
	
	Dimension frameSize = this.getSize(); // 프레임 사이즈
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
	TextAdaptor TA = new TextAdaptor();


	
	
	public GUIaddCPcomInfo()  {
		

	setTitle("회사 정보 추가");
	setLayout(new BorderLayout());
	setSize(400, 400);
	setResizable(false);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);


	JPanel form = new JPanel();
	form.setLayout(new GridLayout(9,2,5,5));
	add(form ,BorderLayout.CENTER);
	
	
	setTitle("회사 정보 추가");

	
	JLabel l1 = new JLabel("회사이름");
	JLabel l2 = new JLabel("CEO");
	JLabel l3 = new JLabel("설립일");
	JLabel l4 = new JLabel("본사위치");
	JLabel l5 = new JLabel("사원 수");
	JLabel l6 = new JLabel("위탁요청기업");
	JLabel l7 = new JLabel("백신");
	JLabel l8 = new JLabel("한달 백신 생산량");
	//JLabel l9 = new JLabel("판매 국가");
	JLabel l99 = new JLabel("(입력 예시:미국.중국.유럽연합)");
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
	JButton insert = new JButton("저장");
	insert.addActionListener(new ActionListener() {


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(!(TA.stringisdisit(t8.getText())) || !(TA.stringisdisit(t5.getText())) || !(TA.stringisdisit(month.getText()))
					|| !(TA.stringisdisit(day.getText())) || !(TA.stringisdisit(year.getText()))) {
				JOptionPane.showMessageDialog(null, "설립일 또는\n한달백신생산량\n또는 사원 수에\n숫자를 입력하시오.");
				
			}else {
			
			try {
				String filePath = "회사데이터.txt";
				File file = new File(filePath);
				if(!file.exists()) {
					file.createNewFile();
				}
				BufferedWriter bos = new BufferedWriter(new FileWriter(file,true));
				bos.write("위탁생산기업-");
				bos.write(t1.getText()+"-"); //회사이름
				bos.write(t7.getSelectedItem()+"/"+t6.getText()+"-"); //백신(위탁생산요청기업)
				bos.write(" -"); // 판매국가
				bos.write(t8.getText()+"-"); // 한달백신생산량
				bos.write(t2.getText()+"-"); //CEO
				bos.write(month.getText()+"/"+day.getText()+"/"+year.getText()+"-"); //설립일
				bos.write(t4.getText()+"-"); //본사 위치
				bos.write(t5.getText()+"\r\n"); //사원 수
				bos.close();
				TA.readtext();
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
		}
	});
	insertpanel.add(insert);
	add(insertpanel, BorderLayout.SOUTH);
	}
	
	

}
