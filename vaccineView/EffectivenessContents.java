package vaccineView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

import vaccine.Inoculationable;
import vaccine.Vaccine;

public class EffectivenessContents extends JPanel
implements Inoculationable{
	public static final int INPUT_MAX_SIZE = 30;
	
	private double[] risks = {
			0,0,0,0,0,0,0,0,0,0
	};
	
	private double[] effectiveness = {
			0,0,0,0,0,0,0,0,0,0
	};
	
	private Vaccine vaccine;
	
	public EffectivenessContents(Vaccine vaccine) {
		super();
		
		this.vaccine = vaccine;
		
		setLayout(new BorderLayout());
		
		JPanel riskContents = new JPanel();
		riskContents.setLayout(new GridLayout(risks.length, 1));
		
		for(int i=0 ; i<risks.length ; i++) {
			riskContents.add(new JLabel((i*10) + " ~ " + ((i+1)*10-1)  + " ages : " + risks[i] + "% " + effectiveness[i] + "% " + ((risks[i]>effectiveness[i])?"RISKY":"EFFECTIVE")));
		}
		
		add(riskContents, BorderLayout.CENTER);
		
		JPanel addForm = new JPanel();
		addForm.setLayout(new FlowLayout());
		
		JTextField input = new JTextField(INPUT_MAX_SIZE);
		input.setEditable(true);
		
		addForm.add(input);
		
		JButton addBtn = new JButton("Add");
		
		addForm.add(addBtn);
		
		setVisible(true);
	}
	
	public Ages parseAge(int age) {
		Ages ages;
		
		switch(age/10) {
		case 0: ages = Ages.Infant;
			break;
		case 1: ages = Ages.Teen;
			break;
		case 2:case 3: ages = Ages.Youth;
			break;
		case 4:case 5: ages = Ages.MiddleAge;
			break;
		case 6:case 7: ages = Ages.ElderAge;
			break;
		default: ages = Ages.OldAge;
			break;
		}
		
		return ages;
	}

	@Override
	public double calcRisk(Ages age, HumanRaces humanRace) {
		return RISK_FOR_AGE[age.ordinal()] * RISK_FOR_HUMAN_RACE[humanRace.ordinal()];
	}

	@Override
	public double calcProfit(Ages age, HumanRaces humanRace) {
		return 0;
	}

	@Override
	public boolean canInoculation(Ages age, HumanRaces humanRace) {
		return calcRisk(age, humanRace) < calcProfit(age, humanRace);
	}
}
