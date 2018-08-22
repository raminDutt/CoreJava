package coreJava;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.MockSettings;

public class CarSearchTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldOnlyreturnRedFerrariWithMoreThan6Cylinders() {
	Car blueFerrari = mock(Car.class,Answers.RETURNS_DEEP_STUBS);
	when(blueFerrari.getEngine().getNbOfCylinders()).thenReturn(10);
	when(blueFerrari.getColor()).thenReturn(Color.BLUE);
	when(blueFerrari.getManufacturer().getName()).thenReturn("Ferrari");
	
	Car redFerrari = mock(Car.class,Answers.RETURNS_DEEP_STUBS);
	when(redFerrari.getEngine().getNbOfCylinders()).thenReturn(10);
	when(redFerrari.getColor()).thenReturn(Color.RED);
	when(redFerrari.getManufacturer().getName()).thenReturn("Ferrari");
	
	CarSearch carSearch = new CarSearch();
	carSearch.addCar(redFerrari);
	carSearch.addCar(blueFerrari);
	List<Car> sportCars = carSearch.findSportCars();
	Assertions.assertThat(sportCars).containsOnly(redFerrari);
	
    }
    

    @Test
    public void shouldOnlyreturnRedFerrariWithMoreThan6Cylinders2() {
	Car blueFerrari = mock(Car.class);
	when(blueFerrari.isSportsCar()).thenReturn(false);

	
	Car redFerrari = mock(Car.class);
	when(redFerrari.isSportsCar()).thenReturn(true);

	
	CarSearch carSearch = new CarSearch();
	carSearch.addCar(redFerrari);
	carSearch.addCar(blueFerrari);
	List<Car> sportCars = carSearch.findSportCars2();
	Assertions.assertThat(sportCars).containsOnly(redFerrari);
	
    }

}
