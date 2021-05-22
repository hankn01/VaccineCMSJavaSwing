
public class LocalGov {
	private String LocalName;
	private String VaccinationLocation; //다른 조원의 결과와 연동
	private int VaccinationAmount;
	private int Population;
	private int Amount;
	public LocalGov()
	{
		Amount = 0;
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
