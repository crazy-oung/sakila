package sakila.address.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.City;
import sakila.address.model.CityDao;

@WebServlet("/address/SelectCityListByCountry")
public class SelectCityListByCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: SelectCityListByCountry SERVLET 실행 :::");
		response.setContentType("application/json;charset=utf-8");
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		System.out.println("countryId : " + countryId);
		cityDao = new CityDao();
		List<City> list = cityDao.selectCityListByCountry(countryId);
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		response.getWriter().write(jsonList);
	}

}
