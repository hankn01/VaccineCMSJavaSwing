package vaccineView;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vaccine.*;

public class InformationContents extends JPanel {
	private Vaccine vaccine;
	
	public InformationContents(Vaccine vaccine) {
		super();
		
		this.vaccine = vaccine;
		
		setLayout(new GridLayout(8,1));
		
		JLabel[] infomations = new JLabel[7];
		
		infomations[0] = new JLabel("name : " + vaccine.getVaccineType());
		infomations[1] = new JLabel("cost : " + vaccine.getCost() + "$");
		if(vaccine instanceof RNAVaccine)
			infomations[2] = new JLabel("RNAName : " + ((RNAVaccine)vaccine).getRNAName());
		else if(vaccine instanceof VirusVectorVaccine)
			infomations[2] = new JLabel("VirusNames : " + ((VirusVectorVaccine)vaccine).getVirusName());
		else if(vaccine instanceof DNAVaccine)
		{
			String res = "";
			for(String s : ((DNAVaccine)vaccine).getDNANames())
				res += s +" ";
				
			infomations[2] = new JLabel("DNANames : " + res);
		}
		infomations[3] = new JLabel("protectionRate : " + vaccine.getProtectionRate() + "%");
		infomations[4] = new JLabel("coldChainDegree : " + vaccine.getColdChainDegree() + "'C");
		infomations[5] = new JLabel("inoculationTime : " + vaccine.getInoculationTime() + "time(s)");
		String res = "";
		for(SideEffect.SideEffects s : vaccine.getSideEffects())
			res += s +" ";
		infomations[6] = new JLabel("SideEffects : " + res);
		
		for(JLabel jl : infomations)
			add(jl);
		
		setVisible(true);
	}
}
