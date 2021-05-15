package landing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CountryLogin extends JPanel
implements ActionListener{
	public static final int ID_DIGIT = 12;
	public static final int PW_DIGIT = 12;
	
	private JLabel idInput;
	private JLabel pwInput;
	
	public CountryLogin() {
		super();
		setLayout(new GridLayout(4,1));
		add(new JLabel("CountryLogin"));
		
		JPanel idInputForm = new JPanel();
		
		JLabel idPrompt = new JLabel("ID : ");
		idInputForm.add(idPrompt, BorderLayout.EAST);
		
		JTextField idInput = new JTextField(ID_DIGIT);
		idInput.setEditable(true);
		idInputForm.add(idInput, BorderLayout.CENTER);
		
		add(idInputForm);
		
		JPanel pwInputForm = new JPanel();
		
		JLabel pwPrompt = new JLabel("PW : ");
		pwInputForm.add(pwPrompt, BorderLayout.EAST);
		
		JTextField pwInput = new JTextField(ID_DIGIT);
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
		if(checkLogin()) {
			 // Data를 불러옵니다
		}
	}
	
	// Login ID PW 검사
	public boolean checkLogin() {
		return true;
	}
}
