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

import sakila.address.model.CountryDao;
import sakila.customer.model.Country;

@WebServlet("/address/SelectCountryList")
public class SelectCountryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountryDao countryDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		System.out.println(request.getParameter("currentPage")+"<- currentPage");
		
		int currentPage = 1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		countryDao = new CountryDao();
		List<Country> list = new ArrayList<Country>();
		list = countryDao.selectCountryList(currentPage);
		System.out.println("list size() : "+list.size());
		
		Gson gson = new Gson();
		String json = gson.toJson(list); 
//		System.out.println(json);
		
		response.getWriter().write(json);
	}

}
