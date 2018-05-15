package coreJava;

import javax.sound.midi.Receiver;

public class Rectangle extends Shape{
	
	private Point topLeft;
	double height;
	double width;
	
	public Rectangle()
	{
		
		this(new Point(0,0),1,1);
	}
	
	public Rectangle(Point topLeft, double width, double height)
	{
		this.topLeft = topLeft;
		this.width = width;
		this.height = height;
		center = new Point(topLeft.getX(), topLeft.getY());
		moveBy(width/2, height/2);
	}

	
	@Override
	public Point getCenter() {
		return center;
	}
	
	@Override
	public Rectangle clone() throws CloneNotSupportedException
	{
		Shape shape = super.clone();
		Rectangle rectangle = (Rectangle) shape;
		rectangle.topLeft = new Point(topLeft.getX(), topLeft.getY());
		rectangle.height = this.height;
		rectangle.width = this.width;
		return rectangle;
		
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(other == null) return false;
		if(this.getClass().getName() == other.getClass().getName())
		{
			Rectangle rectangle = (Rectangle)other;
			if(this.topLeft.equals(rectangle.topLeft) && this.center.equals(rectangle.center) && this.height == rectangle.height && this.width == rectangle.width)
			{
				return true;
			}
			
		}
		return false;
		
	}
	

}
