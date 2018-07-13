package coreJava;

import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest {
    
    private static final Object[] getDegrees() {
	// {celsius,fahrenheit}
	return new Object[] {
		new Object[] { 0, 32 },
		new Object[] { 37, 98.6 },
		new Object[] { 100, 212 } };
    }


    @Test
    @Parameters(method = "getDegrees")
    public void shouldConvertCelciusToFahrenheit(double celsius,
	    double fahrenheit) {

	assertEquals(fahrenheit,
		FahrenheitCelciusConverter.toFahrenheit(celsius), 0.1);
    }

    @Test
    @Parameters(method = "getDegrees")
    public void shouldConvertFahrenheitToCelcius(double celsius,
	    double fahrenheit) {

	assertEquals(celsius, FahrenheitCelciusConverter.toCelcius(fahrenheit),
		0.1);
    }

}
