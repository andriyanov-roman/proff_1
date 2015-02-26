package carrentals.dao.entitiesinterface;


import carrentals.entities.Car;

import java.util.ArrayList;

public interface ICarDAO {
	public Car getCar(Integer idCar);
	public ArrayList<Car> getListCarSortedBy(String str);
	public ArrayList<Car> getSearchCarsSortedBy(String str, Integer idplace, Integer price);
	
}
