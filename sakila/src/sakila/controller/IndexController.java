package sakila.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.CityDao;
import sakila.address.model.CountryDao;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 14개의 DAO 추가 
		 */
		response.setContentType("application/json;charset/utf-8");
		
		CountryDao countryDao = new CountryDao();
//		List<Integer> list = new ArrayList<Integer>(); 
		Map<String, Integer> map = new HashMap<String, Integer>();
		int countryRow = countryDao.selectCountryCount();
//		list.add(countryRow);	//autoboxing
		map.put("countryRow", countryRow);
		CityDao cityDao = new CityDao();
		int cityRow = cityDao.selectCityCount();
		map.put("cityRow", cityRow);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		response.getWriter().write(jsonStr);
		
	}
}
