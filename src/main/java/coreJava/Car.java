package coreJava;

public interface Car {
    Engine getEngine();
    Color getColor();
    Manufacturer getManufacturer();
    public default boolean isSportsCar()
    {
	if(getEngine().getNbOfCylinders() > 6
	    && Color.RED == getColor()
	    && "Ferrari".equals(getManufacturer().getName()))
	{
	    return true;
	}
	return false;
    }
}
