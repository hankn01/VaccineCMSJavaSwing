package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public class Pfizer extends RNAVaccine {

	public Pfizer(double cost, double protectionRate, double coldChainDegree, int inoculationTime,
			double sideEffectRisk, SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory, String RNAName) {
		super(VaccineType.VaccineTypes.Pfizer, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, RNAName);
	}
}
