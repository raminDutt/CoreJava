package coreJava;

import java.io.Serializable;

public class Employee implements Serializable{
	String eId = null;
	Point point = null;
	
	
	public Employee()
	{
		
	}
	
	static public Employee getInstance()
	{
		return new Employee();
				
	}
	public String getName()
	{
		return "Ramin";
	}
	
	public int getAge()
	{
		return 10;
	}
	
	protected void name() {
		
	}

}
