package vaccine;

public interface VaccineType {
	enum VaccineTypes {
		Moderna, Pfizer, // RNAVaccine
		AZ, Yansen, // VirusVectorVaccine
		ChadOx1 // DNAVaccine
	}
}
