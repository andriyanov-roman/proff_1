package carrentals.dao.entitiesinterface;


import carrentals.entities.Place;

import java.util.ArrayList;

public interface IPlaceDAO {
	public Place getPlace(Integer idPlace);
	public ArrayList<Place> getListPlaceSortedByCity();
}
