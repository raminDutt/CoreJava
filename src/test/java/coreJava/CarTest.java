package coreJava;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;

@RunWith(JUnitParamsRunner.class)
public class CarTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnTrueForSportsCar() {
	Car redFerrari = mock(Car.class,Answers.RETURNS_DEEP_STUBS);
	when(redFerrari.getEngine().getNbOfCylinders()).thenReturn(10);
	when(redFerrari.getColor()).thenReturn(Color.RED);
	when(redFerrari.getManufacturer().getName()).thenReturn("Ferrari");
	when(redFerrari.isSportsCar()).thenCallRealMethod();
	Assertions.assertThat(redFerrari.isSportsCar()).isEqualTo(true);

    }
    
    private static final Object[] parametersForShouldReturnFalseForNonSportsCar() {
	return new Object[] {
		new Object[] { 2, Color.RED, "Ferrari" },
		new Object[] { 8, Color.BLACK, "Ferrari" },
		new Object[] { 8, Color.RED, "BMW" }};
    }
    @Test
    @Parameters
    public void shouldReturnFalseForNonSportsCar(int numberOfCylinders, Color color, String mfg)
    {
	Car blueFerrari = mock(Car.class,Answers.RETURNS_DEEP_STUBS);
	when(blueFerrari.getEngine().getNbOfCylinders()).thenReturn(numberOfCylinders);
	when(blueFerrari.getColor()).thenReturn(color);
	when(blueFerrari.getManufacturer().getName()).thenReturn(mfg);
	when(blueFerrari.isSportsCar()).thenCallRealMethod();
	Assertions.assertThat(blueFerrari.isSportsCar()).isEqualTo(false);
    }

}
