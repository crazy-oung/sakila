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

@WebServlet("/address/SelectCityList")
public class SelectCityList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		System.out.println(request.getParameter("currentPage")+"<- currentPage");
		
		int currentPage = 1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		cityDao = new CityDao();
		List<City> list = new ArrayList<City>();
		list = cityDao.selectCityList(currentPage);
		System.out.println("list size() : "+list.size());
		
		Gson gson = new Gson();
		String json = gson.toJson(list); 
		
		response.getWriter().write(json);
	}

}
