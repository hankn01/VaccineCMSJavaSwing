	package company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;



public class TextAdaptor {
	ArrayList<Company> company = new ArrayList<Company>();
	ArrayList<String> country = new ArrayList<String>(); // ���� �̸� ����Ʈ
	
	Scanner in = null;
	PrintWriter out = null;
	public void readtext() {
		ArrayList<String> pstr = new ArrayList<String>();

		try {
		in = new Scanner(new FileInputStream("C:\\Users\\������\\eclipse-workspace\\Teamp\\src\\company\\ȸ�絥����.txt"));
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		String line = null;
		while(in.hasNextLine()) {
			pstr.clear();
			line = in.nextLine();
			StringTokenizer st1 = new StringTokenizer(line, "-");
			while(st1.hasMoreTokens()) {
				pstr.add(st1.nextToken());
			}
			if(pstr.get(0).equals("��Ű��߻�����")) {
				
			
				
				String[] d = new String[3]; // ��¥ ����
				int i =0;
				StringTokenizer dt = new StringTokenizer(pstr.get(6), "/");
				while(dt.hasMoreTokens()) {
					d[i] = dt.nextToken();
					i++;
				}
				Date adate = new Date(Integer.valueOf(d[0]), Integer.valueOf(d[1]),Integer.valueOf(d[2]));
				
				
				country.clear(); // ���� �̸� ����
				StringTokenizer ct = new StringTokenizer(pstr.get(3), "/");
				while(ct.hasMoreTokens()) {
					country.add(ct.nextToken());
				}
				
				int num =Integer.valueOf(pstr.get(8));
				int Vnum = Integer.valueOf(pstr.get(4));
				
				HaverVaccineCompany Hv = new HaverVaccineCompany(pstr.get(1),pstr.get(5),adate,pstr.get(7), 
						num, Vnum, country, pstr.get(2)); // ��ü ����
				
				company.add(Hv);
				
				
				
				
			}else if(pstr.get(0).equals("��Ź������")) {
				
				

				String[] d = new String[3]; // ��¥ ����
				int i =0;
				StringTokenizer dt = new StringTokenizer(pstr.get(6), "/");
				while(dt.hasMoreTokens()) {
					d[i] = dt.nextToken();
					i++;
				}
				Date adate = new Date(Integer.valueOf(d[0]), Integer.valueOf(d[1]),Integer.valueOf(d[2]));
				
			
				
				String[] VandC = new String[2]; // ��Ű� ûŹȸ��
				int z =0;
				StringTokenizer vact = new StringTokenizer(pstr.get(2), "/");
				while(vact.hasMoreTokens()) {
					VandC[z] = dt.nextToken();
					z++;
				}
				
				CPcompany Cp = new CPcompany(pstr.get(1),pstr.get(5),adate,pstr.get(7), 
						Integer.valueOf(pstr.get(8)), Integer.valueOf(pstr.get(4)), VandC[0], VandC[1]); // ��ü ����
				
				company.add(Cp);
				
				
			}else { //����ӻ�ܰ���
				
				String[] d = new String[3]; // ��¥ ����
				int i =0;
				StringTokenizer dt = new StringTokenizer(pstr.get(6), "/");
				while(dt.hasMoreTokens()) {
					d[i] = dt.nextToken();
					i++;
				}
				Date adate = new Date(Integer.valueOf(d[0]), Integer.valueOf(d[1]),Integer.valueOf(d[2]));
				
				
				
				String[] VandL = new String[2]; // ���� ���� ��Ű� �ӻ� �ܰ� ����
				int z =0;
				StringTokenizer val = new StringTokenizer(pstr.get(2), "/");
				while(val.hasMoreTokens()) {
					VandL[i] = val.nextToken();
					i++;
				}
				
				
				UnderDevelopCompany Ud = new UnderDevelopCompany(pstr.get(1),pstr.get(5),adate,pstr.get(7), 
						VandL[0], Integer.valueOf(pstr.get(8)) , Integer.valueOf(VandL[1].replaceAll("[^0-9]", ""))); // ��ü ����
				
				company.add(Ud);
				
			}
		}
		
		in.close();
	}
	
	
	public void equalizeText() {
		
		try {
		out = new PrintWriter(new FileOutputStream("C:\\Users\\������\\eclipse-workspace\\Teamp\\src\\company\\ȸ�絥����.txt"));
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		for(Company c: company) {
			if(c.comtype().equals("Hv")) {
				HaverVaccineCompany hv = null;
				hv = (HaverVaccineCompany) c;
				
				out.println("��Ű��߻�����-"+hv.getCompanyName()+"-"+hv.getVaccine()+"-"+hv.getCountry()+"-"+hv.getVTPM()+"-"
						+hv.getCEO()+"-"+hv.getDate()+"-"+hv.getHeadquatersLocation()+"-"+hv.getNumberOfEmployee());
			}else if(c.comtype().equals("Cp")) {
				//out.println("��Ź������-"+);
				
			}else if(c.comtype().equals("Ud")){
				//out.println("����ӻ�ܰ���-"+);
				
			}else {
				System.err.println("Wrong company type");
				System.exit(0);
			}
		}
		
	}

	
	
}
