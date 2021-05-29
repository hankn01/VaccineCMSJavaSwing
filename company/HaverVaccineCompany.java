package company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import country.*;
import vaccine.*;
import vaccineView.VaccineMainMenu;


public class HaverVaccineCompany extends Company implements VaccineAddable{
	
	vaccine.SideEffect.SideEffects[] sideEffects = {SideEffect.SideEffects.Pain, SideEffect.SideEffects.Blush, SideEffect.SideEffects.Swelling, 
			SideEffect.SideEffects.Fatigue, SideEffect.SideEffects.Headache};
	
	private int VPTM; //한달 백신 생산량 vaccine prodution time per month
	ArrayList<String> PVC = new ArrayList<String>(); // 백신 판매 국가
	//ArrayList<Country> PVC = new ArrayList<Country>(); // 백신 판매 국가
	private Vaccine vaccineinfo;
	private String vaccine;
	
	public HaverVaccineCompany(String Companyname, String Ceo, 
			Date aDate, String head, int num ,int aVPTM, ArrayList<String> acountry, String avaccine) {
		super(Companyname, Ceo, aDate, head, num);
		this.VPTM = aVPTM;
		this.addCountry(acountry);
		this.setVaccine(avaccine);
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
			AZ  am= new AZ(3000, 720/this.VPTM, 5, 86400, 0.55, sideEffects, new ArrayList<VaccineProduct>(), "Ad5");
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
	
	public HaverVaccineCompany(){
		super();
		this.VPTM = 0;
		this.PVC.add(null);
		this.vaccine = null;
	}
	

	
	public String comtype() {
		return "Hv";
	}




	public void setVPTM(int avptn) {
		this.VPTM = avptn;
	}
	
	public int getVTPM(){
		return this.VPTM;
	}
	
	public void addCountry(ArrayList<String> acountry) {
		for(int i=0; i<acountry.size(); i++) {
			PVC.add(acountry.get(i));
		}
	}
	
	public void romoveCountry(String aCountry) {
		int k = PVC.indexOf(aCountry);
		PVC.remove(k);
	}
	
	public String getCountry() {
		String line = "";
		int index = 0;
		for(String s: PVC) {
			index++;
			line += s;
			if(!(PVC.size() == index)) {
				line += "/";
			}
		}
		return line;
	}
	
	public void setVaccine(String avaccine) {
		this.vaccine = avaccine;
	}
	
	public String getVaccine() {
		return this.vaccine;
	}
	
	public double calculVPT() { //백신 한 병 생산 시간
		return this.VPTM / 720; // 단위 hour
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
	
	

}
