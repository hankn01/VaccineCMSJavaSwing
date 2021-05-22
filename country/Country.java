package country;

public class Country {

	private String CountryName;
	private int CountryBudget;
	//백신릴리즈데이트 구현 예정
	private int CountryPopulation;
	private int InoculationablePopulation;
	
	
	
	
	public void AddVaccine(String Company, int amount)
	{
		
		//다른 조원의 클래스 내용과 연동 예정
		//클래스 종류 및 이름은 변경될 수 있음.
		
	}
	
	public void RemoveVaccine(String Company, int amount)
	{
		
	}
	public void VaccinationStart()
	{
		
	}
	public void VaccinationEnd()
	{
		
	}
	
	public void setCountryName(String name)
	{
		this.CountryName = name;
	}
	public void setCountryBudget(int budget)
	{
		this.CountryBudget = budget;
	}
	public void setCountryPopulation(int pop)
	{
		this.CountryPopulation = pop;
	}
	public void setInoculationablePopulation(int ino)
	{
		this.InoculationablePopulation = ino;
	}
	public void AlertExpirVaccine()
	{
		//전 클래스(리스트) 검사 후 유효기간이 만료되어가는 백신을 확인합니다.
	}
	
}
