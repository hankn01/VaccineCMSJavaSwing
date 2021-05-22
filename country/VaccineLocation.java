package country;

public class VaccineLocation {
	private String LocName;
	private String Address;
	
	public VaccineLocation()
	{
		LocName = "";
		Address = "";
	}
	public VaccineLocation(String Name, String Addr)
	{
		this.LocName = Name;
		this.Address = Addr;
	}
	public void setLocName(String Name)
	{
		this.LocName = Name;
	}
	public void setAddress(String Addr)
	{
		this.Address= Addr;
	}
	
	public String getLocName()
	{
		return this.LocName;
	}
	public String getAddress()
	{
		return this.Address;
	}
	
}
