package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public abstract class RNAVaccine extends Vaccine {
	private String RNAName;
	
	public RNAVaccine(VaccineType.VaccineTypes vaccineType, double cost, double protectionRate, double coldChainDegree, int inoculationTime,
			double sideEffectRisk, SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory, String RNAName) {
		super(vaccineType, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory);
		this.RNAName = RNAName;
	}

	public String getRNAName() {
		return RNAName;
	}

	public void setRNAName(String rNAName) {
		RNAName = rNAName;
	}
}
