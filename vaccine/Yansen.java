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
		// Country ���� Ȯ���ڰ� ������ ������ ������ �ϰԲ� �����͸� �޾Ƽ� ��ȯ
		return 0;
	}
}
