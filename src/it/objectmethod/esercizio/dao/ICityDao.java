package it.objectmethod.esercizio.dao;

import it.objectmethod.esercizio.model.City;

public interface ICityDao {
	
	public City findCityByName(String name);
}
