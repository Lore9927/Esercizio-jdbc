package it.objectmethod.esercizio.dao;

import it.objectmethod.esercizio.model.Country;

public interface ICountryDao {
	
	public Country findCountryByNameAndContinent(String name, String continent);
}
