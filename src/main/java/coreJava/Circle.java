package coreJava;

public class Circle  extends Shape{

	private double radius;
	
	public static int counter;
	static 
	{
		System.out.println("static initializer has been called: " + Thread.currentThread().getName());
		counter = 1;
	}
	
	public static void  f()
	{
		System.out.println("Static Circle");
	}
	public Circle()
	{
		this(null,0);
	}
	
	public Circle(Point center, double radius)
	{
		this.center = center;
		this.radius=radius;
	}

	@Override
	public Point getCenter() {

		return center;
	}
	
	
	@Override
	public Circle clone() throws CloneNotSupportedException
	{
		Circle circle = (Circle)super.clone();
		circle.radius=radius;
		return circle;
		
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == null)
		{
			return false;
		}
		
		if(other == this)
		{
			return true;
		}
		
		if(this.getClass().getName() == other.getClass().getName())
		{
			Circle circle = (Circle)other;
			if(circle.radius == this.radius && circle.center.equals(this.center))
			{
				return true;
			}
		}
		return false;
	}


}
