package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public class AZ extends VirusVectorVaccine {

	public AZ(double cost, double protectionRate, double coldChainDegree, int inoculationTime, double sideEffectRisk,
			SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory, String virusName) {
		super(VaccineType.VaccineTypes.AZ, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, virusName);
	}
}
