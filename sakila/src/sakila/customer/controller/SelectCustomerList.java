package sakila.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.customer.model.Customer;
import sakila.customer.model.CustomerDao;

@WebServlet("/customer/SelectCustomerList")
public class SelectCustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: SelectCustomerList SERVLET 실행 :::");
		response.setContentType("application/json;charset=utf-8");
		customerDao = new CustomerDao();
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.println("currentPage: "+currentPage);
		List<Customer> list = customerDao.selectCustomerList(currentPage);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		response.getWriter().write(jsonStr);
		
	}

}
