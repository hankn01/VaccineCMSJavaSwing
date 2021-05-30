package country;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import company.Date;
import vaccine.AZ;
import vaccine.ChadOx1;
import vaccine.Moderna;
import vaccine.Pfizer;
import vaccine.SideEffect;
import vaccine.Vaccine;
import vaccine.VaccineAddable;
import vaccine.VaccineProduct;
import vaccine.Yansen;

public class VaccineForIO implements VaccineAddable{

	vaccine.SideEffect.SideEffects[] sideEffects = {SideEffect.SideEffects.Pain, SideEffect.SideEffects.Blush, SideEffect.SideEffects.Swelling, 
			SideEffect.SideEffects.Fatigue, SideEffect.SideEffects.Headache};
	
	private Vaccine vaccineinfo;
	private String vaccine;
	private int VPTM = 0;
	private Moderna vm = null;
	private Pfizer pm = null;
	private AZ am = null;
	private Yansen ym = null;
	private ChadOx1 cm = null;
	
	public VaccineForIO(){
		super();
		this.vaccine = "";
		this.vaccineinfo = null;
		this.VPTM =0;
	}
	
	public VaccineForIO(String avaccine, int aVPTM) {
		super();
		this.vaccine = avaccine;
		this.VPTM = aVPTM;
		ArrayList<VaccineProduct> ar = null;
		ar = new ArrayList<VaccineProduct>();
		File file = new File("National"+avaccine+".txt");
		if(file.exists())
		{
		try {
			FileInputStream fin = new FileInputStream(file);
			Scanner sc = new Scanner(fin);
			sc.useDelimiter("|");
			VaccineProduct temp = null;
			while(sc.hasNext())
			{
				int num = sc.nextInt();
				double cp = sc.nextDouble();
				String adate = sc.next();
				String bdate = sc.next();
				String a[] = adate.split(adate);
				String b[] = bdate.split(bdate);
				vaccine.Date pdate = new vaccine.Date(Integer.parseInt(a[0]),Integer.parseInt(a[1]),Integer.parseInt(a[2]));
				vaccine.Date edate = new vaccine.Date(Integer.parseInt(b[0]),Integer.parseInt(b[1]),Integer.parseInt(b[2]));
				
				temp = new VaccineProduct(num, cp, pdate, edate);
				ar.add(temp);
				vaccineinfo.setInventory(ar);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		else
		{
			ar = new ArrayList<VaccineProduct>();
		}
		switch(avaccine) {
		case "Moderna": 

			vm = new Moderna(25000, 720/this.VPTM , -20, 86400, 0.11, sideEffects, new ArrayList<VaccineProduct>(), "MRNA-1273");
			this.vaccineinfo = vm;
			
			break;
		case "Pfizer": 
			pm = new Pfizer(20000, 720/this.VPTM, -70, 86400, 0.16, sideEffects, new ArrayList<VaccineProduct>(), "BNT162b2");
			this.vaccineinfo = pm;
		
			break;
		case "AZ": 
			am= new AZ(3000, 720/this.VPTM, 5, 86400, 0.555, sideEffects, new ArrayList<VaccineProduct>(), "Ad5");
			this.vaccineinfo = am;
			break;
		case "Yansen": 
			ym = new Yansen(12000, 720/this.VPTM, -20, 86400, 0.1, sideEffects, new ArrayList<VaccineProduct>(), "Ad26)");
			this.vaccineinfo = ym;
			break;
		case "ChadOx1": 
			cm = new ChadOx1(0, 0, 0, 0, 0, sideEffects, new ArrayList<VaccineProduct>(), null, true, null);
			this.vaccineinfo = cm;
		}
		
		
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
	
	public int getVPTM(){
		return this.VPTM;
	}
	
	public void setVaccine(String avaccine) {
		this.vaccine = avaccine;
	}
	
	public String getVaccine() {
		return this.vaccine;
	}


	@Override
	public void addToFile(VaccineProduct vaccineProduct) {
		
		PrintWriter out = null;
		try {
			String filename = "National"+this.getVaccine()+".txt";
			out = new  PrintWriter(new FileOutputStream(filename),true);
			
		}catch(FileNotFoundException e) {
			System.out.print("Error file not found");
			System.exit(0);
		}
		out.println(vaccineProduct.getVaccineNum()+"|"+vaccineProduct.getCapacity()+"|"+vaccineProduct.getProductDate().getYear()+"/"+vaccineProduct.getProductDate().getMonth()+"/"+vaccineProduct.getProductDate().getDay()+"|"+vaccineProduct.getExpireDate().getYear()+"/"+vaccineProduct.getExpireDate().getMonth()+"/"+vaccineProduct.getExpireDate().getDay());
		out.close();
		
	}
	
	
	
	
	

	
	
	
}
