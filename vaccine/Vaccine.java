package vaccine;

import java.util.ArrayList;

import vaccine.SideEffect.SideEffects;

public abstract class Vaccine
implements Inoculationable, Runnable {
	// 1. information
	private VaccineType.VaccineTypes vaccineType;
	private double cost;
	private double protectionRate;
	private double coldChainDegree;
	private int inoculationTime;
	private double sideEffectRisk;
	private SideEffect.SideEffects[] sideEffects;
	private VaccineProduct vaccineProduct;
	
	// 3. inventory
	private ArrayList<VaccineProduct> inventory;
	
	public Vaccine(VaccineType.VaccineTypes vaccineType, double cost, double protectionRate, double coldChainDegree, int inoculationTime, 
			double sideEffectRisk, SideEffects[] sideEffects, 
			ArrayList<VaccineProduct> inventory) {
		super();
		this.vaccineType = vaccineType;
		this.cost = cost;
		this.protectionRate = protectionRate;
		this.coldChainDegree = coldChainDegree;
		this.inoculationTime = inoculationTime;
		this.sideEffectRisk = sideEffectRisk;
		this.sideEffects = sideEffects;
		this.inventory = inventory;
	}

	public VaccineType.VaccineTypes getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(VaccineType.VaccineTypes vaccineType) {
		this.vaccineType = vaccineType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getProtectionRate() {
		return protectionRate;
	}

	public void setProtectionRate(double protectionRate) {
		this.protectionRate = protectionRate;
	}

	public double getColdChainDegree() {
		return coldChainDegree;
	}

	public void setColdChainDegree(double coldChainDegree) {
		this.coldChainDegree = coldChainDegree;
	}

	public int getInoculationTime() {
		return inoculationTime;
	}

	public void setInoculationTime(int inoculationTime) {
		this.inoculationTime = inoculationTime;
	}

	public double getSideEffectRisk() {
		return sideEffectRisk;
	}

	public void setSideEffectRisk(double sideEffectRisk) {
		this.sideEffectRisk = sideEffectRisk;
	}

	public SideEffect.SideEffects[] getSideEffects() {
		return sideEffects;
	}

	public void setSideEffects(SideEffect.SideEffects[] sideEffects) {
		this.sideEffects = sideEffects;
	}

	public ArrayList<VaccineProduct> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<VaccineProduct> inventory) {
		this.inventory = inventory;
	}
	
	public void addVaccineProduct(VaccineProduct vaccineProduct) {
		this.vaccineProduct = vaccineProduct;
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public double calcRisk(Ages age, HumanRaces humanRace) {
		return getSideEffectRisk() 
				* Inoculationable.RISK_FOR_AGE[age.ordinal()] * Inoculationable.RISK_FOR_HUMAN_RACE[humanRace.ordinal()];
	}

	@Override
	public boolean canInoculation(Ages age, HumanRaces humanRace) {
		return calcRisk(age, humanRace) < calcProfit(age, humanRace);
	}
	
	@Override
	public void run() {
		this.inventory.add(vaccineProduct);
	}
}
