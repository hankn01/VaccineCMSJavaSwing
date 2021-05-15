package vaccineView;

import java.awt.BorderLayout;
import javax.swing.*;
import vaccine.*;

public class InventoryContents extends JPanel {
	public static final int TEXTAREA_ROW = 20;
	public static final int TEXTAREA_COL = 15;
	
	private Vaccine vaccine;
	private JTextArea inventory;
	
	public InventoryContents(Vaccine vaccine) {
		super();
		
		this.vaccine = vaccine;
		
		setLayout(new BorderLayout());
		
		inventory = new JTextArea(TEXTAREA_ROW, TEXTAREA_COL);
		inventory.setEditable(false);
		updateIventory();
		
		JScrollPane scroll = new JScrollPane(inventory);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(scroll);
		
		setVisible(true);
	}
	
	public void updateIventory() {
		String res = "";
		for(VaccineProduct vp : vaccine.getInventory())
			res += vp.toString() +"\n";
		inventory.setText(res);
	}
}
