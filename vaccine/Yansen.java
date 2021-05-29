package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public class Yansen extends VirusVectorVaccine {

	public Yansen(double cost, double protectionRate, double coldChainDegree, int inoculationTime,
			double sideEffectRisk, SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory, String virusName) {
		super(VaccineType.VaccineTypes.Yansen, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, virusName);
	}

	@Override
	public double calcProfit(Ages age, HumanRaces humanRace) {
		// Country 에서 확진자가 많으면 이익이 많도록 하게끔 데이터를 받아서 반환
		return 0;
	}
}
