package company;

import java.awt.geom.FlatteningPathIterator;

import country.Country;
import vaccine.Vaccine;

public class UnderDevelopCompany extends Company{
	
	private String DevelopVaccineName;
	private int ClinicalProgress;
	
	public UnderDevelopCompany() {
		super();
		this.DevelopVaccineName = "";
		this.ClinicalProgress = 0;
	}
	
	public UnderDevelopCompany(String Companyname, 
			String Ceo, Date aDate, String head, String exvaccine, int num, int ClinicalProgress) {
		super(Companyname, Ceo, aDate, head, num);
		this.DevelopVaccineName = exvaccine;
		this.ClinicalProgress = ClinicalProgress;
		
		
	}
	
	
	public String comtype() {
		return "Ud";
	}
	
	public void setDevelopVaccineName(String n) {
		this.DevelopVaccineName = n;
	}
	
	public String getDevelopVaccineName() {
		return this.DevelopVaccineName;
	}
	
	
	public void setClinicalProgress(int CP) {
		if(CP > 0 && CP < 4) {
			this.ClinicalProgress = CP;
		}else {
			System.err.println("Error: 잘못된 임상 실험 단계");
		}
	}
	
	public int getClinicalProgress() {
		return this.ClinicalProgress;
	}
	

}
