package landing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignIn extends JPanel 
implements ActionListener{
	public static final int ID_DIGIT = 12;
	public static final int PW_DIGIT = 12;
	
	private JLabel idInput;
	private JLabel pwInput;
	private JLabel pwCheck;
	
	public SignIn() {
		super();
		setLayout(new GridLayout(5,1));
		add(new JLabel("SignIn"));
		
		JPanel idInputForm = new JPanel();
		
		JLabel idPrompt = new JLabel("ID : ");
		idInputForm.add(idPrompt, BorderLayout.EAST);
		
		JTextField idInput = new JTextField(ID_DIGIT);
		idInput.setEditable(true);
		idInputForm.add(idInput, BorderLayout.CENTER);
		
		JButton check = new JButton("Check");
		check.addActionListener(this);
		idInputForm.add(check, BorderLayout.WEST);
		
		add(idInputForm);
		
		JPanel pwInputForm = new JPanel();
		
		JLabel pwPrompt = new JLabel("PW : ");
		pwInputForm.add(pwPrompt, BorderLayout.EAST);
		
		JTextField pwInput = new JTextField(ID_DIGIT);
		pwInput.setEditable(true);
		pwInputForm.add(pwInput, BorderLayout.CENTER);
		
		add(pwInputForm);
		
		JPanel pwCheckForm = new JPanel();
		
		JLabel pwCheckPrompt = new JLabel("PW Check : ");
		pwCheckForm.add(pwCheckPrompt, BorderLayout.EAST);
		
		JTextField pwCheckInput = new JTextField(ID_DIGIT);
		pwCheckInput.setEditable(true);
		pwCheckForm.add(pwCheckInput, BorderLayout.CENTER);
		
		add(pwCheckForm);
		
		JButton submit = new JButton("Submit");
		submit.setContentAreaFilled(false);
		submit.setBorderPainted(false);
		submit.addActionListener(this);
		
		add(submit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	// Login ID PW °Ë»ç
	public boolean checkLogin() {
		return true;
	}
}
