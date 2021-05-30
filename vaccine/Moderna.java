package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public class Moderna extends RNAVaccine {

	public Moderna(double cost, double protectionRate, double coldChainDegree, int inoculationTime,
			double sideEffectRisk, SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory, String RNAName) {
		super(VaccineType.VaccineTypes.Moderna, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, RNAName);
	
	}
}