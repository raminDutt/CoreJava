package coreJava;


public class DiscountedItem extends Item 
{
	private double discount;
	
	public DiscountedItem()
	{
		discount=0;
	}
	
	public DiscountedItem(double discount)
	{
		this.discount=discount;
	}

	public boolean equals(Object otherObject) 
	{
		if(otherObject.getClass().getName() == Item.class.getName())
		{
			if (super.equals(otherObject))
			{
				return true;
			}
			return false;
		}
		
		if(this.getClass().getName() == otherObject.getClass().getName())
		{
			DiscountedItem other = (DiscountedItem) otherObject;
			return discount == other.discount;
		}
		return false;
	}
	
	
	

}