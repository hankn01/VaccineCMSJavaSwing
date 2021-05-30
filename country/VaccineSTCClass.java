
package country;

import java.io.Serializable;

public class VaccineSTCClass implements Serializable{
	String Location;
	int AZstk, Modernastk, ChadOx1stk, PfizerStk, Yansenstk;
	
	
	public VaccineSTCClass()
	{
		Location = "";
		AZstk=0;
		Modernastk=0;
		ChadOx1stk=0;
		PfizerStk=0;
		Yansenstk=0;
		
	}
	public VaccineSTCClass(String name)
	{
		this.Location = name;
		AZstk=0;
		Modernastk=0;
		ChadOx1stk=0;
		PfizerStk=0;
		Yansenstk=0;
		
	}
	public void setAZStock(int stock)
	{
		this.AZstk = stock;
	}
	public void setModernaStock(int stock)
	{
		this.Modernastk = stock;
	}
	public void setChadOx1Stock(int stock)
	{
		this.ChadOx1stk = stock;
	}
	public void setPfizerStock(int stock)
	{
		this.PfizerStk = stock;
	}
	public void setYansenStock(int stock)
	{
		this.Yansenstk = stock;
	}
	
	
	public int getAZStock()
	{
		return this.AZstk;
	}
	public int getModernaStock()
	{
		return this.Modernastk;
	}
	public int getPfizerStock()
	{
		return this.PfizerStk;
	}
	public int getChadOx1Stock()
	{
		return this.ChadOx1stk;
	}
	public int getYansenStock()
	{
		return this.Yansenstk;
	}
	
	
	
	
	public void setLocation(String name)
	{
		this.Location = name;
	}
	
	public String getLocation()
	{
		return this.Location;
	}
	
}
