/**
 * 
 */
package coreJava;

import java.util.Objects;

import javax.print.attribute.standard.MediaSize.Other;

/**
 * @author ramin
 *
 */
public class LabeledPoint extends Point{

	String label;
	
	public LabeledPoint(String label, int x, int y)
	{
		super(x, y);
		this.label = label;
	}
	
	public String getLabel()
	{
		return label;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("Label = " + label + "\n");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!super.equals(other))
		{
			return false;
		}

		LabeledPoint oth = (LabeledPoint)other;
		if(this.label == oth.label)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), label);
	}


}

