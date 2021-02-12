package it.objectmethod.esercizio.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import it.objectmethod.esercizio.dao.ICityDao;
import it.objectmethod.esercizio.model.City;

public class CityDaoImpl implements ICityDao{

	private Connection getConnection() {
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
	public City findCityByName(String name) {
		Connection conn = getConnection();
		City city = null;
		
		String sql = "SELECT * FROM city WHERE Name = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				city = new City();
				city.setId(rs.getLong("ID"));
				city.setCountry(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setDistrict(rs.getString("District"));
				city.setPopulation(rs.getLong("Population"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return city;
	}

}
