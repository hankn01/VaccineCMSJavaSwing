package country;
import java.util.ArrayList;



public class LocalGov {
	private String LocalName;
	private ArrayList<VaccineLocation> VCL; //다른 조원의 결과와 연동
	private int VaccinationAmount;
	private int Population;
	private int Amount;
	public LocalGov()
	{
		Amount = 0;
		LocalName = "";
		VaccinationAmount = 0;
		Population = 0;
	}
	
	public LocalGov(String name, int Population, int VaccinationAmount, int CurAmount)
	{
		this.LocalName = name;
		this.Population = Population;
		this.VaccinationAmount = VaccinationAmount;
		this.Amount = CurAmount;
		
		
	}
	//클래스 협의 결과에 따라 생성자는 수정될 수 있음.
	
	public void addLocation(String LocName, String Addr)
	{
		VaccineLocation temp = new VaccineLocation(LocName, Addr);
		VCL.add(temp);
	}
	public ArrayList<VaccineLocation> getLocation()
	{
		return VCL;
	}
	
	public void AllocateVaccine(int Amount)
	{
		this.Amount += Amount;
	}
	public void setLocalName(String LocalName)
	{
		this.LocalName = LocalName;
	}
	
	public void setVaccinationAmount(int amt)
	{
		this.VaccinationAmount = amt;
	}
	public void setPopulation(int pop)
	{
		this.Population = pop;
	}
	public void setAmount(int amt)
	{
		this.Amount =  amt;
	}
	
	public String getLocalName()
	{
		return this.LocalName;
	}
	public int getVaccinationAmount()
	{
		return this.VaccinationAmount;
	}
	public int getPopulation()
	{
		return this.Population;
	}
	public int getAmount()
	{
		return this.Amount;
	}
	
	
	
}
