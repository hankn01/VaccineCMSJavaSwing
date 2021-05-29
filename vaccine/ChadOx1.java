package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public class ChadOx1 extends DNAVaccine {
	private boolean researchDone;
	private Date releaseDate;

	public ChadOx1(double cost, double protectionRate, double coldChainDegree, int inoculationTime,
			double sideEffectRisk, SideEffects[] sideEffects, ArrayList<VaccineProduct> inventory,
			String[] DNANames, boolean researchDone, Date releaseDate) {
		super(VaccineType.VaccineTypes.ChadOx1, cost, protectionRate, coldChainDegree, inoculationTime, sideEffectRisk, sideEffects, inventory, DNANames);
		this.researchDone = researchDone;
		this.releaseDate = new Date(releaseDate);
	}

	public boolean isResearchDone() {
		return researchDone;
	}

	public void setResearchDone(boolean researchDone) {
		this.researchDone = researchDone;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public double calcProfit(Ages age, HumanRaces humanRace) {
		// Country 에서 확진자가 많으면 이익이 많도록 하게끔 데이터를 받아서 반환
		return 0;
	}
}
