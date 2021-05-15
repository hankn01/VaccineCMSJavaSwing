package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public class AZ extends VirusVectorVaccine {

	public AZ(double cost, double protectionRate, double coldChainDegree, int inoculationTime, double sideEffectRisk,
			SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory, String virusName) {
		super(VaccineType.VaccineTypes.AZ, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, virusName);
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
