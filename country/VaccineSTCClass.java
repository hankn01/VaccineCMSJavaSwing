
package country;

import java.io.Serializable;

public class VaccineSTCClass implements Serializable{
	String Companyname;
	int stock;	
	
	public VaccineSTCClass()
	{
		Companyname = "";
		stock = 0;
		
	}
	public VaccineSTCClass(String name, int stock)
	{
		this.Companyname = name;
		this.stock = stock;
		
	}
	public VaccineSTCClass(String name)
	{
		this.Companyname = name;
	}
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	public void setName(String name)
	{
		this.Companyname = name;
	}
	public int getStock()
	{
		return this.stock;
	}
	public String getName()
	{
		return this.Companyname;
	}
	
}
