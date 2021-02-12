package it.objectmethod.esercizio.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.esercizio.dao.ICountryDao;
import it.objectmethod.esercizio.dao.impl.CountryDaoImpl;
import it.objectmethod.esercizio.model.Country;

public class CountryServlet extends HttpServlet {

	private static final long serialVersionUID = -8005306669362902452L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nameCountryReq = req.getParameter("nomeNazione");
		String continentReq = req.getParameter("continente");
		String ris;
		ICountryDao countryDao = new CountryDaoImpl();
	
		Country country = countryDao.findCountryByNameAndContinent(nameCountryReq, continentReq);
		req.getSession().setAttribute("nazione", country);
		ris = country.getCode() + " " + country.getName() + " " + country.getContinent() + " " 
				+ country.getPopulation() + " " + country.getSurfaceArea();
		req.setAttribute("ris", ris);
		req.getRequestDispatcher("pages/country.jsp").forward(req, resp);
	}
	

}
