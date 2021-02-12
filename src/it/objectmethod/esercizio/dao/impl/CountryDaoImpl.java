package it.objectmethod.esercizio.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.esercizio.dao.ICountryDao;
import it.objectmethod.esercizio.model.Country;

public class CountryDaoImpl implements ICountryDao {

	private Connection getConnection()
	{
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33060/world", "omdev", "omdev");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	@Override
	public Country findCountryByNameAndContinent(String name, String continent) {
		Connection conn = getConnection();
		Country country = null;
		
		String sql = "SELECT Code, Name, Continent, Population, SurfaceArea FROM country WHERE Name = ? AND Continent = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, continent);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				country = new Country();
				country.setCode(rs.getString("Code"));
				country.setName(rs.getString("Name"));
				country.setContinent(rs.getString("Continent"));
				country.setPopulation(rs.getLong("Population"));
				country.setSurfaceArea(rs.getLong("SurfaceArea"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return country;
	}

}
