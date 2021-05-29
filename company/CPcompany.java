package company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import country.Country;
import vaccine.AZ;
import vaccine.ChadOx1;
import vaccine.Moderna;
import vaccine.Pfizer;
import vaccine.SideEffect;
import vaccine.Vaccine;
import vaccine.VaccineAddable;
import vaccine.VaccineProduct;
import vaccine.Yansen;

public class CPcompany extends Company  implements VaccineAddable{
	
	vaccine.SideEffect.SideEffects[] sideEffects = {SideEffect.SideEffects.Pain, SideEffect.SideEffects.Blush, SideEffect.SideEffects.Swelling, 
			SideEffect.SideEffects.Fatigue, SideEffect.SideEffects.Headache};
	
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
		this.setStringToVaccineinfo(avaccine);

	}
	
	public void setStringToVaccineinfo(String avaccine) {
		

		switch(avaccine) {
		case "Moderna": 

			Moderna vm = new Moderna(25000, 720/this.VPTM , -20, 86400, 0.11, sideEffects, new ArrayList<VaccineProduct>(), "MRNA-1273");
			this.vaccineinfo = vm;
			
			break;
		case "Pfizer": 
			Pfizer pm = new Pfizer(20000, 720/this.VPTM, -70, 86400, 0.16, sideEffects, new ArrayList<VaccineProduct>(), "BNT162b2");
			this.vaccineinfo = pm;
		
			break;
		case "AZ": 
			AZ  am= new AZ(3000, 720/this.VPTM, 5, 86400, 0.555, sideEffects, new ArrayList<VaccineProduct>(), "Ad5");
			this.vaccineinfo = am;
			break;
		case "Yansen": 
			Yansen ym = new Yansen(12000, 720/this.VPTM, -20, 86400, 0.1, sideEffects, new ArrayList<VaccineProduct>(), "Ad26)");
			this.vaccineinfo = ym;
			break;
		case "Chadox1": 
			ChadOx1 cm = new ChadOx1(0, 0, 0, 0, 0, sideEffects, new ArrayList<VaccineProduct>(), null, true, null);
			this.vaccineinfo = cm;
		}
	}
	
	public void setVaccineonfo(Vaccine avaccine) {
	
		this.vaccineinfo = avaccine;
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

	@Override
	public void addToFile(VaccineProduct vaccineProduct) {
		// TODO Auto-generated method stub
		
		PrintWriter out = null;
		try {
			String filename = this.getCompanyName();
			out = new  PrintWriter(new FileOutputStream(filename));
		}catch(FileNotFoundException e) {
			System.out.print("Error file not found");
			System.exit(0);
		}
		out.println(vaccineProduct.toString());
		out.close();
		
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
