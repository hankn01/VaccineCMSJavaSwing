package landing;

import java.awt.GridLayout;

import javax.swing.*;

public class LoginHome extends JPanel {
	public LoginHome() {
		super();
		setLayout(new GridLayout(2,1));
		add(new JLabel("This is Home"));
		add(new JLabel("Choose Your Login Category"));
	}
}
