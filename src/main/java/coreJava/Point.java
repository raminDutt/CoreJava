
package coreJava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

import annotations.Serializable;
import annotations.Todo;
import annotations.Transient;

@Serializable
public class Point implements Cloneable {
	double coordinate[] = new double[2];
	private static long serialVersionUID = 841912001828677276L;
	protected double x=0;
	protected double y=0;
	static public volatile int age;
	@Transient public Point cyclic  = null;

	public Point()
	{
		this(0,0);
	}
	
	
	public Point(double x, double y)
	{
		this.x=x;
		this.y=y;
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
	
	@Todo(message="Reminder message 6", description="Point class, Methode: setX")
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
		String a = "coordinate[]=" + Arrays.toString(coordinate);
		String b = "serialVersionUID=" + serialVersionUID;
		String c = "x=" + x;
		String d = "y=" + y;
		String e = "age=" + age;
		String f = "cyclic=" + cyclic;
		
		String result = "("+a+" "+b+" "+c+" "+d+" "+e+" "+f+")"; 

		return result;
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
