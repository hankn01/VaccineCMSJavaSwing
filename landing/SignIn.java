package landing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignIn extends JPanel 
implements ActionListener{
	public static final int ID_DIGIT = 12;
	public static final int PW_DIGIT = 12;
	
	private JTextField idInput;
	private JTextField pwInput;
	private JTextField pwCheck;
	
	public SignIn() {
		super();
		setLayout(new GridLayout(5,1));
		add(new JLabel("SignIn"));
		
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
		
		pwInput = new JTextField(ID_DIGIT);
		pwInput.setEditable(true);
		pwInputForm.add(pwInput, BorderLayout.CENTER);
		
		add(pwInputForm);
		
		JPanel pwCheckForm = new JPanel();
		
		JLabel pwCheckPrompt = new JLabel("PW Check : ");
		pwCheckForm.add(pwCheckPrompt, BorderLayout.EAST);
		
		pwCheck = new JTextField(ID_DIGIT);
		pwCheck.setEditable(true);
		pwCheckForm.add(pwCheck, BorderLayout.CENTER);
		
		add(pwCheckForm);
		
		JButton submit = new JButton("Submit");
		submit.setContentAreaFilled(false);
		submit.setBorderPainted(false);
		submit.addActionListener(this);
		
		add(submit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileOutputStream("Account.txt", true));
			
			String id = idInput.getText().toString();
			String password = pwInput.getText().toString();
			String passwordCheck = pwCheck.getText().toString();
			
			if(password.equals(passwordCheck)) {
				pw.println(id + "-" + password);
			} else {
				pwCheck.setText("The password is different.");
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		pw.close();
	}
}
