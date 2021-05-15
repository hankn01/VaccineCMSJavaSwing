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
		// Country ���� Ȯ���ڰ� ������ ������ ������ �ϰԲ� �����͸� �޾Ƽ� ��ȯ
		return 0;
	}

	@Override
	public VaccineProduct product(int vaccineNum, double capacity, Date productDate, Date expireDate) {
		return new VaccineProduct(vaccineNum, capacity, productDate, expireDate);
	}

	@Override
	public Date calcProductTime(int productNum) {
		// Company���� �� ���� ���� �ð� ������ �޾Ƽ� ��ȯ
		return null;
	}

}