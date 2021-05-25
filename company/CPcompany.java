package company;

import java.util.ArrayList;

import country.Country;
import vaccine.Vaccine;

public class CPcompany extends Company{
	
	private String ApprovedCompany;
	private int VPTM;
	private Vaccine vaccineinfo;
	private String vaccine;
	//ArrayList<Country> PVC = new ArrayList<Country>(); // 백신 판매 국가

	
	public CPcompany(){
		super();
		this.setApprovedCompany("");
		this.VPTM = 0;
		//ArrayList<Country> PVC = new ArrayList<Country>();
	}
	
	public CPcompany(String Companyname, String Ceo, Date aDate, 
			String head, int num ,int aVPTM , String avaccine, 
			String acompany) {
		super(Companyname, Ceo, aDate, head, num);
		this.VPTM = aVPTM;
		this.vaccine = avaccine;
		this.setApprovedCompany(acompany);

	}
	
	public void setvaccineinfo(Vaccine v) {
		this.vaccineinfo = v;
	}
	public Vaccine getvaccineinfo() {
		return this.vaccineinfo;
	}
	
	public String comtype() {
		return "Cp";
	}
	
	public void setVPTM(int avptn) {
		this.VPTM = avptn;
	}
	
	public int getVTPM(){
		return this.VPTM;
	}
	
	public void setVaccine(String avaccine) {
		this.vaccine = avaccine;
	}
	
	public String getVaccine() {
		return this.vaccine;
	}

	public String getApprovedCompany() {
		return ApprovedCompany;
	}

	public void setApprovedCompany(String approvedCompany) {
		ApprovedCompany = approvedCompany;
	}
	


	//public void addCountry(Country aCountry) {
	//	PVC.add(aCountry);
	//}
	
	//public void romoveCountry(Country aCountry) {
	//	int k = PVC.indexOf(aCountry);
	//	PVC.remove(k);
	//}
	
	//public void printCountry() {
	//	for(Country s: PVC) {
			//System.out.println(s.getCountry name)
	//	}
	//}
	
	
}
