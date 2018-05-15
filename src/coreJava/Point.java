
package coreJava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Point implements Serializable, Cloneable {
	double coordinate[] = new double[2];
	private static final long serialVersionUID = 841912001828677276L;
	protected double x=0;
	protected double y=0;
	static public volatile int age;

	public Point()
	{
		this(0,0);
	}
	
	
	public Point(double x, double y)
	{
		//this.x=x;
		//this.y=y;
		this.coordinate[0]=x;
		this.coordinate[1]=y;
	}
	

	
	public double getX()
	{
		//return x;
		return this.coordinate[0];
	}
	
	public double getY()
	{
		//return y;
		return this.coordinate[1];
	}
	
	public void setX(double x)
	{
		//this.x=x;
		this.coordinate[0]=x;
	}
	
	public void setY(double y)
	{
		//this.y=y;
		this.coordinate[1]=y;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		/*builder.append("X = " + x + "\n");
		builder.append("Y = " + y + "\n");*/
		builder.append("X = " + this.coordinate[0] + "\n");
		builder.append("Y = " + this.coordinate[1] + "\n");
		return builder.toString();
	}
	
	
	private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException
	{
		inputStream.defaultReadObject();
		coordinate=new double[2];
		coordinate[0]=x;
		coordinate[1]=y;
	}
	
	
	@Override
	public boolean equals(Object other)
	{
		if(this == other)
		{
			return true;
		}
		
		if(other == null)
		{
			return false;
		}
		
				
		System.out.println("This = " + this.getClass().getName());
		
		System.out.println("Other = " + other.getClass().getName());
		
		if(this.getClass().getName() != other.getClass().getName())
		{
			return false;
		}
		
		Point oth = (Point)other;
/*		if(this.x == oth.x && this.y == oth.y)
		{
			return true;
		}
		else
		{
			return false;
	
		}*/
		if(this.coordinate[0]==oth.coordinate[0] && this.coordinate[1]==oth.coordinate[1])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	@Override
	public int hashCode()
	{
		return Arrays.hashCode(coordinate);
	}
	
	public int f(Object... values)
	{
		System.out.println(values[0]);
		int x = Arrays.hashCode((double[])values[0]);
		System.out.println("x=" + x);
		return x;
	}

	@Override
	public Point clone() throws CloneNotSupportedException
	{
		//return new Point(this.x, this.y);
		return new Point(this.coordinate[0], this.coordinate[1]);
	}

}
