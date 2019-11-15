package sakila.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.Country;
import sakila.address.model.CountryDao;

@WebServlet("/address/InsertCountry")
public class InsertCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountryDao countryDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: InsertCountryServlet 실행 :::");
		response.setContentType("application/json;charset=utf-8");
		String country = request.getParameter("country");
		System.out.println("country: "+country);
		
		countryDao = new CountryDao();
		Country c = new Country();
		c.setCountry(country);
		countryDao.insertCountry(c);
		
		Gson gson = new Gson();
		String jsonCount = gson.toJson(c);
		response.getWriter().write(jsonCount);
	}

}
