package vaccine;

public interface Inoculationable {
	enum Ages {
	// 0~9	    10~19 20~39  40~59      60~79     80~
		Infant, Teen, Youth, MiddleAge, ElderAge, OldAge
	};
	
	enum HumanRaces {
			White, Black, Asian
	};
	
	public static final double[] RISK_FOR_AGE = { 
	//  Infant, Teen, Youth, MiddleAge, ElderAge, OldAge
		1.3, 1.4, 1.3, 1.2, 1.1, 1.0
	};
	public static final double[] RISK_FOR_HUMAN_RACE = {
	// White, Black, Asian
		1.0, 1.2, 1.1
	};
	
	public abstract double calcRisk(Ages age, HumanRaces humanRace);
	public abstract double calcProfit(Ages age, HumanRaces humanRace);
	public abstract boolean canInoculation(Ages age, HumanRaces humanRace);
}