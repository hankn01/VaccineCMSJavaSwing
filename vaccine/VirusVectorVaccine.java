package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public abstract class VirusVectorVaccine extends Vaccine {
	private String virusName;
	
	public VirusVectorVaccine(VaccineType.VaccineTypes vaccineType, double cost, double protectionRate, double coldChainDegree, int inoculationTime,
			double sideEffectRisk, SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory, String virusName) {
		super(vaccineType, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory);
		this.virusName = virusName;
	}

	public String getVirusName() {
		return virusName;
	}

	public void setVirusName(String virusName) {
		this.virusName = virusName;
	}
}
