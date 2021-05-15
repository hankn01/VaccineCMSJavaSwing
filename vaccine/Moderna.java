package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public class Moderna extends RNAVaccine {

	public Moderna(double cost, double protectionRate, double coldChainDegree, int inoculationTime,
			double sideEffectRisk, SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory, String RNAName) {
		super(VaccineType.VaccineTypes.Moderna, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, RNAName);
	
	}

	@Override
	public double calcProfit(Ages age, HumanRaces humanRace) {
		// Country 에서 확진자가 많으면 이익이 많도록 하게끔 데이터를 받아서 반환
		return 0;
	}

	@Override
	public VaccineProduct product(int vaccineNum, double capacity, Date productDate, Date expireDate) {
		return new VaccineProduct(vaccineNum, capacity, productDate, expireDate);
	}

	@Override
	public Date calcProductTime(int productNum) {
		// Company에서 한 병당 생산 시간 데이터 받아서 반환
		return null;
	}

}