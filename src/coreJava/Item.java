package coreJava;

import java.util.Objects;

public class Item //extends Employee
{
	private String description;
	private double price;
	
	public Item()
	{
		description=null;
		price=0;
	}
	
	public Item(String description, double price)
	{
		this.description=description;
		this.price=price;
	}

	public boolean equals(Object otherObject) 
	{
		// A quick test to see if the objects are identical
		if (this == otherObject) return true;
		// Must return false if the parameter is null
		if (otherObject == null) return false;
		
		if (!(otherObject instanceof Item)) return false;
		
		// Test whether the instance variables have identical values
		Item other = (Item) otherObject;
		return Objects.equals(description, other.description) && price == other.price;
		
	}
	
	
}

