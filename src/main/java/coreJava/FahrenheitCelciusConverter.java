package coreJava;

public class FahrenheitCelciusConverter {

    public static double toFahrenheit(double celisuis)
    {
	double fahrenheit = celisuis * 1.8 + 32;
	return fahrenheit;
    }

    public static double toCelcius(double fahrenheit ) {
	double celisuis = (fahrenheit-32)*(double)5/9;
	return celisuis;
    }
}
