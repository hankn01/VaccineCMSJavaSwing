package vaccineView;

import javax.swing.*;

import vaccine.Vaccine;

public class EffectivenessContents extends JPanel {
	public static final int INPUT_MAX_SIZE = 30;
	
	public static final String[] HEADER = {"Age", "Risk(%)", "Effectiveness(%)", "Inoculationable"};
	
	private double[] risks = {
			1.2,1.3,1.5,1.2,1.2,1.1,1.1,1,1,0.9
	};
	
	private double[] effectiveness = {
			1.1,1.2,1.3,1.4,1.5,1.7,1.8,1.9,2.1,2
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
