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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class NationalVaccineControl extends JFrame implements ActionListener{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 150;
	VaccineSTCClass temp = null;
	JComboBox selectCompany = null;
	JTextField Amount = null;
	HashMap<String, VaccineSTCClass> STCdata = null;
	public NationalVaccineControl()
	{
		
		super("백신 관리");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(new BorderLayout());
		
		
		
		File file = new File("NationalVaccinedata.dat");
		if(file.exists())
		{
		try {
			FileInputStream fin = new FileInputStream(file);
			
			ObjectInputStream oin = new ObjectInputStream(fin);
			STCdata = (HashMap<String, VaccineSTCClass>)oin.readObject();
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		else
		{
			STCdata = new HashMap<String, VaccineSTCClass>();
		}
		
		JLabel Inst = new JLabel();
		Inst.setText("백신을 도입하거나, 유효기간이 만료된 백신 또는 불량 백신을 폐기합니다.");
		
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
				String type = inp_temp[1];
	
				selectCompany.addItem(type);
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found.");
			JOptionPane.showMessageDialog(null,"파일을 찾을 수 없습니다. (에러 코드 401)", "파일 오류",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		
		
		
		
		downPanel.add(selectCompany,BorderLayout.NORTH);
		
		Amount = new JTextField();
		downPanel.add(Amount,BorderLayout.CENTER);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new BorderLayout());
		JButton Intro = new JButton("백신 도입");
		Intro.addActionListener(this);
		ButtonPanel.add(Intro,BorderLayout.WEST);
		
		JButton Dispose = new JButton("백신 폐기");
		Dispose.addActionListener(this);
		ButtonPanel.add(Dispose,BorderLayout.EAST);
		
		downPanel.add(ButtonPanel,BorderLayout.SOUTH);
		
		
		this.add(Inst,BorderLayout.NORTH);
		this.add(downPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("백신 도입"))
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
