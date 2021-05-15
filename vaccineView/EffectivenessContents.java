package vaccineView;

import javax.swing.*;

import vaccine.Vaccine;

public class EffectivenessContents extends JPanel {
	public static final int INPUT_MAX_SIZE = 30;
	
	public static final String[] HEADER = {"Age", "Risk(%)", "Effectiveness(%)", "Inoculationable"};
	
	private double[] risks = {
			0,0,0,0,0,0,0,0,0,0
	};
	
	private double[] effectiveness = {
			0,0,0,0,0,0,0,0,0,0
	};
	
	private String[][] body = new String[risks.length][HEADER.length];
	
	private Vaccine vaccine;
	
	public EffectivenessContents(Vaccine vaccine) {
		super();
		this.vaccine = vaccine;
		
		for(int i=0 ; i<risks.length ; i++) {
			body[i][0] = (i*10) + " ~ " + ((i+1)*10-1);
			body[i][1] = risks[i] + "";
			body[i][2] = effectiveness[i] + "";
			body[i][3] = (risks[i]>effectiveness[i]) ? "RISKY" : "EFFECTIVE";
		}
		
		JScrollPane scroll = new JScrollPane(new JTable(body, HEADER));
		
		add(scroll);
		
		setVisible(true);
	}
}
