package sakila.address.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.City;
import sakila.address.model.CityDao;
import sakila.address.model.Country;
import sakila.address.model.CountryDao;

@WebServlet("/address/InsertCity")
public class InsertCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: InsertCityServlet 실행 :::");
		response.setContentType("application/json;charset=utf-8");
		String city = request.getParameter("city");
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		System.out.println("city: "+city+", countryId: "+countryId);
		
		cityDao = new CityDao();
		City c = new City();
		c.setCity(city);
		c.setCountry(new Country());
		c.getCountry().setCountryId(countryId);
		cityDao.insertCity(c);
		
		Gson gson = new Gson();
		String jsonCount = gson.toJson(c);
		response.getWriter().write(jsonCount);
	}

}
