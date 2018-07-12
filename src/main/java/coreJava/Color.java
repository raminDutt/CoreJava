/**
 * 
 */
package coreJava;

/**
 * @author ramin
 *
 */
public enum Color {
	BLACK(0,0,0), RED(255,0,0), BLUE(0,255,0), GREEN(0,0,255), CYAN(0,255,255), MAGENTA(255,0,255), YELLOW(255,255,0), WHITE(255,255,255);
	int red;
	int blue;
	int green;

	
	private Color(int red, int blue, int green)
	{
		this.red=red;
		this.blue=blue;
		this.green=green;
	}
	
	public int getRed()
	{
		return red;
	}
	

	public int getBlue()
	{
		return blue;
	}
	
	public int getGreen()
	{
		return green;
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Red = " + red + "\n" + "Blue = " + blue + "\n" + "Green = " + green);
		return builder.toString();
	}
	

}
