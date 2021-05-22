package company;

public  abstract class Company {
	private String CompanyName;
	private String CEO;
	private Date DateOfEstablishment;
	private String HeadquatersLocation;
	private int NumberOfEmployee;
	
	public Company() {
		this.CompanyName = "";
		this.CEO = "";
		this.DateOfEstablishment = new Date();
		this.HeadquatersLocation = "";
		this.NumberOfEmployee = 0;
	}
	
	public Company(String Name, String CEO, Date aDate, String Location, int Num) {
		this.setCompanyName(Name);
		this.setCEO(CEO);
		this.setDate2(aDate);
		this.HeadquatersLocation = Location;
		this.NumberOfEmployee = Num;
	}
	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCEO() {
		return CEO;
	}
	public void setCEO(String cEO) {
		CEO = cEO;
	}
	public String getHeadquatersLocation() {
		return HeadquatersLocation;
	}
	public void setHeadquatersLocation(String headquatersLocation) {
		HeadquatersLocation = headquatersLocation;
	}
	public Date getDateOfEstablishment() {
		return new Date(this.DateOfEstablishment);
	}
	
	public String getDate() {
		return this.DateOfEstablishment.getDate();
	}
	public void setDateOfEstablishment(int year, int month, int Day) {
		this.DateOfEstablishment = new Date(month, Day, year);
	}
	
	public void setDate2(Date aDate) {
		this.DateOfEstablishment = new Date(aDate);
	}
	public int getNumberOfEmployee() {
		return NumberOfEmployee;
	}
	public void setNumberOfEmployee(int numberOfEmployee) {
		NumberOfEmployee = numberOfEmployee;
	}

	public abstract String comtype();
	
	

}
