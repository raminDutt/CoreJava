package coreJava;

import java.util.ArrayList;
import java.util.List;

public class CarSearch {
    private List<Car> cars = new ArrayList<Car>();

    public void addCar(Car car) {
	cars.add(car);
    }

    public List<Car> findSportCars() {
	List<Car> sportCars = new ArrayList<Car>();
	for (Car car : cars) {
	    if (car.getEngine().getNbOfCylinders() > 6
		    && Color.RED == car.getColor()
		    && "Ferrari".equals(car.getManufacturer().getName())) {
		sportCars.add(car);
	    }
	}
	return sportCars;
    }
    
    public List<Car> findSportCars2() {
   	List<Car> sportCars = new ArrayList<Car>();
   	for (Car car : cars) {
   	    if (car.isSportsCar()){
   		sportCars.add(car);   		    
   	    }
   	}
   	return sportCars;
       }
}
