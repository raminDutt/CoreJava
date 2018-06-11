package coreJava;

@Serializable
public class Line {
	
	Point from;
	Point to;
	Point center;
	
	public Line()
	{
		this(null,null);
	}
	
	public Line(Point from, Point to)
	{
		this.from=from;
		this.to=to;
	}

	//@Override
	public Point getCenter() {
		double cx = (to.getX()+from.getX())/2;
		double cy = (from.getY()+from.getY())/2;
		center = new Point(cx, cy);
		return center;
	}
	
	@Override
	public Line clone() throws CloneNotSupportedException
	{
		Line line = (Line)super.clone();
		line.from = this.from.clone();
		line.to=this.to.clone();
		return line;
	}
	
	public String toString()
	{
		String result = "[from=" + to + " " + "to=" + to + " " + "center=" + center +"]";
		return result;
	}

}
