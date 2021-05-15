package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public abstract class DNAVaccine extends Vaccine {
	private String[] DNANames;
	
	public DNAVaccine(VaccineType.VaccineTypes vaccineType, double cost, double protectionRate, double coldChainDegree, int inoculationTime,
			double sideEffectRisk, SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory, String[] DNANames) {
		super(vaccineType, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory);
		this.DNANames = DNANames;
	}

	public String[] getDNANames() {
		return DNANames;
	}

	public void setDNANames(String[] dNANames) {
		DNANames = dNANames;
	}
}
