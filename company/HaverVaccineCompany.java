package company;


import java.util.ArrayList;
import country.*;
import vaccine.*;


public class HaverVaccineCompany extends Company{
	
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
	
	public void setvaccineinfo(Vaccine v) {
		this.vaccineinfo = v;
	}
	public Vaccine getvaccineinfo() {
		return this.vaccineinfo;
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
	
	

}
