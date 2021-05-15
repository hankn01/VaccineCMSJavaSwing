package vaccineView;

import java.awt.BorderLayout;
import javax.swing.*;
import vaccine.*;

public class InventoryContents extends JPanel {
	public static final String[] HEADER = {"Number", "Capacity", "Produce Date", "Expire Date"};
	
	private Vaccine vaccine;
	private String[][] body;
	
	public InventoryContents(Vaccine vaccine) {
		super();
		this.vaccine = vaccine;
		this.body = new String[vaccine.getInventory().size()][HEADER.length];
		setLayout(new BorderLayout());
		
		for(int i=0 ; i<body.length ; i++) {
			body[i][0] = vaccine.getInventory().get(i).getVaccineNum() + "";
			body[i][1] = vaccine.getInventory().get(i).getCapacity() + "";
			body[i][2] = vaccine.getInventory().get(i).getProductDate().toString();
			body[i][3] = vaccine.getInventory().get(i).getExpireDate().toString();
		}
		
		JScrollPane scroll = new JScrollPane(new JTable(body, HEADER));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(scroll);
		
		setVisible(true);
	}
}
