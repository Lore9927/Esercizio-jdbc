package it.objectmethod.esercizio.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.esercizio.dao.ICityDao;
import it.objectmethod.esercizio.dao.impl.CityDaoImpl;
import it.objectmethod.esercizio.model.City;

public class CityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 4528198690144960123L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cityNameReq = req.getParameter("nomeCitta");
		String ris;
		ICityDao cityDao = new CityDaoImpl();
		
		City city = cityDao.findCityByName(cityNameReq);
		req.getSession().setAttribute("citta", city);
		
		ris = city.getName() + " " + city.getDistrict() + " " + city.getCountry() + " " + city.getPopulation();
		req.setAttribute("ris", ris);
		req.getRequestDispatcher("pages/city.jsp").forward(req, resp);
	}

}
