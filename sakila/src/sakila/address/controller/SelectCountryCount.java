package sakila.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.CountryDao;

@WebServlet("/addrerss/selectCountryCount")
public class SelectCountryCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountryDao countryDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: SelectCountryCount 실행 :::");
		response.setContentType("application/json");
		countryDao = new CountryDao();
		int count = countryDao.selectCountryCount();
		
		Gson gson = new Gson();
		String jsonCount = gson.toJson(count);
		System.out.println(jsonCount);
		response.getWriter().write(jsonCount);
	}
}
