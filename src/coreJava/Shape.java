package coreJava;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class Shape<T> implements Cloneable{
	protected Point center;
	
	public void moveBy(double dx, double dy)
	{
/*		center.x = center.x + dx;
		center.y += dy;*/
		center.coordinate[0] = center.coordinate[0] + dx;
		center.coordinate[1] += dy;
	}
	
	public abstract Point getCenter();
	
/*	//Shallow copy
	@Override
	public Shape clone() throws CloneNotSupportedException
	{
		return (Shape)super.clone();
	}*/
	
	@Override
	public Shape clone() throws CloneNotSupportedException
	{
		System.out.println(this.getClass().getName());
		Shape shape = null;
		try {
			
			Class<?> cl = Class.forName(this.getClass().getName());
			shape = (Shape)cl.newInstance(); 
			shape.center = new Point(this.getCenter().getX(), this.getCenter().getY());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return shape;

	}

}
