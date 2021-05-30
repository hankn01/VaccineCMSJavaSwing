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
		
		super("백신 관리");
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
		Inst.setText("<html>생산된 백신 중 필요한 분량만큼 도입합니다.<br>백신 생산 회사를 선택하고 도입 수량과 용량, 도입 날짜를 입력해 주세요.</html>");
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BorderLayout());
		selectCompany = new JComboBox();
		
		FileInputStream inpfile;
		try {
			inpfile = new FileInputStream("회사데이터.txt");
			Scanner scan = new Scanner(inpfile);
			scan.useDelimiter("-");
			while(scan.hasNext())
			{
				
				String[] inp_temp;
				String input = scan.nextLine();
				inp_temp = input.split("-");
				if(inp_temp[0].equals("백신개발생산기업"))
				{
				String type = inp_temp[1];
				String ts = inp_temp[2];
				selectCompany.addItem(type+"|"+ts);
				}
				else if(inp_temp[0].equals("위탁생산기업"))
				{
					String type = inp_temp[1];
					String ts = inp_temp[2];
					String res = ts.split("/")[0];
	
					selectCompany.addItem(type+"|"+res);
				}
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found.");
			JOptionPane.showMessageDialog(null,"파일을 찾을 수 없습니다. (에러 코드 401)", "파일 오류",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		
		
		
		
		downPanel.add(selectCompany,BorderLayout.NORTH);
		
		
		JPanel form = new JPanel();
		form.setLayout(new GridLayout(5,2));
		
		JLabel c1 = new JLabel();
		c1.setText("도입 일자와 종료 일자는");
		form.add(c1);
		
		JLabel c2 = new JLabel();
		c2.setText("'년/월/일' 형식으로 입력합니다.");
		form.add(c2);
		
		JLabel VacNumLbl = new JLabel();
		VacNumLbl.setText("백신 수량:");
		form.add(VacNumLbl);
		
		VacNum = new JTextField();
		form.add(VacNum);
		JLabel AmtLbl = new JLabel();
		AmtLbl.setText("백신 용량:");
		form.add(AmtLbl);
		
		Amount = new JTextField();
		form.add(Amount,BorderLayout.NORTH);
		
		
		JLabel DInputLabel = new JLabel();
		DInputLabel.setText("백신 도입 날짜:");
		form.add(DInputLabel);
		
		DInput = new JTextField();
		form.add(DInput);
		
		JLabel EDInputLabel = new JLabel();
		EDInputLabel.setText("백신 사용(유통)기한:");
		form.add(EDInputLabel);
		
		EDInput = new JTextField();
		form.add(EDInput);
		
		
		downPanel.add(form,BorderLayout.CENTER);
		
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new BorderLayout());
		JButton Intro = new JButton("백신 도입");
		Intro.addActionListener(this);
		ButtonPanel.add(Intro,BorderLayout.CENTER);
		
		
		
		downPanel.add(ButtonPanel,BorderLayout.SOUTH);
		
		
		this.add(Inst,BorderLayout.NORTH);
		this.add(downPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("백신 도입"))
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
				JOptionPane.showMessageDialog(null,"파일을 찾을 수 없습니다. (에러 코드 401)", "파일 오류",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (IOException e1) {
				System.err.println("File IOException.");
				JOptionPane.showMessageDialog(null,"파일 입출력 오류입니다.(IOException) (에러 코드 402)", "파일 오류",JOptionPane.ERROR_MESSAGE);
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
		else if(e.getActionCommand().equals("백신 폐기"))
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
			JOptionPane.showMessageDialog(null, "현재 도입되지 않은 백신입니다.");
			}
			this.Amount.setText("");
			this.selectCompany.setSelectedIndex(0);
			
			try {
				FileOutputStream fout = new FileOutputStream("NationalVaccinedata.dat");
				ObjectOutputStream oout = new ObjectOutputStream(fout);
				System.out.println(STCdata.get("모더나").getStock());
				oout.writeObject(STCdata);
			} catch (FileNotFoundException e1) {
				System.err.println("File Not Found.");
				JOptionPane.showMessageDialog(null,"파일을 찾을 수 없습니다. (에러 코드 401)", "파일 오류",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (IOException e1) {
				System.err.println("File IOException.");
				JOptionPane.showMessageDialog(null,"파일 입출력 오류입니다.(IOException) (에러 코드 402)", "파일 오류",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			
		}
		
	}
	
}
