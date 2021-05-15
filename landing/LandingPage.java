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
		Country, Company, Home, SignIn
	};
	
	LoginHome lh = new LoginHome();
	CountryLogin conl = new CountryLogin();
	CompanyLogin coml = new CompanyLogin();
	SignIn si = new SignIn();
	
	public LandingPage() {
		super();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Vaccine CMS by Team1");
		
		add(lh, BorderLayout.CENTER);
		
		JMenuBar loginBar = new JMenuBar();
		
		JMenu loginTypeMenu = new JMenu("Login Type");
		
		JMenuItem Country = new JMenuItem("Country");
		Country.addActionListener(new LoginMenuOnChangeEventLisener(this));
		loginTypeMenu.add(Country);
		
		JMenuItem Company = new JMenuItem("Company");
		Company.addActionListener(new LoginMenuOnChangeEventLisener(this));
		loginTypeMenu.add(Company);
		
		JMenuItem Home = new JMenuItem("Home");
		Home.addActionListener(new LoginMenuOnChangeEventLisener(this));
		loginTypeMenu.add(Home);
		
		JMenuItem SignIn = new JMenuItem("SignIn");
		SignIn.addActionListener(new LoginMenuOnChangeEventLisener(this));
		loginTypeMenu.add(SignIn);
		
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
			case Country: parent.add(conl, BorderLayout.CENTER);
				break;
			case Company: parent.add(coml, BorderLayout.CENTER);
				break;
			case Home: parent.add(lh, BorderLayout.CENTER);
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
			case "Country": setPage(Pages.Country);
				break;
			case "Company": setPage(Pages.Company);
				break;
			case "Home": setPage(Pages.Home);
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
