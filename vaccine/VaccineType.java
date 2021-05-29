package vaccine;

public interface VaccineType {
	enum VaccineTypes {
		Moderna, Pfizer, // RNAVaccine
		AZ, Yansen, // VirusVectorVaccine
		ChadOx1 // DNAVaccine
	}
	
	int[] cost = {
			25000, 20000, 3000, 12000, 0
	};
	
	int[] coldChainDegree = {
			-20, -70, 5, -20, 0
	};
	
	int inoculationTime = 86400; //하루를 초로 변환, 발열 따위 증상이 나타나기까지 시간
	
	double[] sideEffectRisk = {
			0.11,0.16,0.55, 0.1, 0 
	};
	
	String[] RNAName = {
			 "MRNA-1273", "BNT162b2","Ad5","Ad26",null
			
	};

}
