package landing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LandingPage extends JFrame {
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	
	public enum Pages{
		Login, SignIn
	};
	
	LoginHome l = new LoginHome(this);
	SignIn si = new SignIn();
	
	public LandingPage() {
		super();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Vaccine CMS by Team1");
		
		add(l, BorderLayout.CENTER);
		
		JMenuBar loginBar = new JMenuBar();
		
		JMenu loginTypeMenu = new JMenu("Login Type");
		
		JMenuItem Country = new JMenuItem("Login");
		Country.addActionListener(new LoginMenuOnChangeEventLisener(this));
		loginTypeMenu.add(Country);
		
		JMenuItem Company = new JMenuItem("SignIn");
		Company.addActionListener(new LoginMenuOnChangeEventLisener(this));
		loginTypeMenu.add(Company);
		
		loginBar.add(loginTypeMenu);
		
		setJMenuBar(loginBar);
	}
	
	private class LoginMenuOnChangeEventLisener implements ActionListener {
		private JFrame parent;
		
		public LoginMenuOnChangeEventLisener(JFrame parent) {
			this.parent = parent;
		}
		
		public void setPage(Pages type) {
			parent.getContentPane().removeAll();
			parent.setLayout(new BorderLayout());
			
			switch(type) {
			case Login: parent.add(l, BorderLayout.CENTER);
				break;
			case SignIn: parent.add(si, BorderLayout.CENTER);
				break;
			}
			
			parent.revalidate();
			parent.repaint();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "Login": setPage(Pages.Login);
				break;
			case "SignIn": setPage(Pages.SignIn);
			break;
			}
		}
	}
	
	public static void main(String[] args) {
		LandingPage lp = new LandingPage();
		lp.setVisible(true);
	}
}
