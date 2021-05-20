package landing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class LoginHome extends JPanel
implements ActionListener{
	public static final int ID_DIGIT = 12;
	public static final int PW_DIGIT = 12;
	
	private JTextField idInput;
	private JTextField pwInput;
	
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	public LoginHome() {
			super();
			setLayout(new GridLayout(4,1));
			add(new JLabel("Login Home"));
			
			JPanel idInputForm = new JPanel();
			
			JLabel idPrompt = new JLabel("ID : ");
			idInputForm.add(idPrompt, BorderLayout.EAST);
			
			idInput = new JTextField(ID_DIGIT);
			idInput.setEditable(true);
			idInputForm.add(idInput, BorderLayout.CENTER);
			
			add(idInputForm);
			
			JPanel pwInputForm = new JPanel();
			
			JLabel pwPrompt = new JLabel("PW : ");
			pwInputForm.add(pwPrompt, BorderLayout.EAST);
			
			pwInput = new JTextField(PW_DIGIT);
			pwInput.setEditable(true);
			pwInputForm.add(pwInput, BorderLayout.CENTER);
			
			add(pwInputForm);
			
			JButton submit = new JButton("Submit");
			submit.setContentAreaFilled(false);
			submit.setBorderPainted(false);
			submit.addActionListener(this);
			
			add(submit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 Scanner sc = null;
		 try {
			sc = new Scanner(new FileInputStream("Account.txt"));
			
			StringTokenizer st;
			while(sc.hasNextLine()) {
				st = new StringTokenizer(sc.nextLine(), "-");
				
				accounts.add(new Account(st.nextToken(), st.nextToken()));
			}
			
			Account tmp = new Account(idInput.getText().toString(), pwInput.getText().toString());
			
			for(Account a : accounts) {
				if(a.equals(tmp)) {
					idInput.setText("Login Success");
					pwInput.setText("Login Success");
					break;
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		 
		 sc.close();
	}

	private class Account{
		private String id;
		private String pw;
		
		public Account(String id, String pw) {
			this.id = id;
			this.pw = pw;
		}
		
		@Override
		public boolean equals(Object a) {
			if(a == null)
				return false;
			if(a instanceof Account) {
				return ((Account) a).id.equals(id) && ((Account) a).pw.equals(pw);
			} else {
				return false;
			}
		}
	}
}
