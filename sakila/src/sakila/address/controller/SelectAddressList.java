package sakila.address.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.AddressDao;
import sakila.customer.model.Address;

@WebServlet("/address/SelectAddressList")
public class SelectAddressList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressDao addressDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: SelectAddressList SERVLET 실행 :::");
		response.setContentType("application/json;charset=utf-8");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		addressDao = new AddressDao();
		List<Address> list = addressDao.selectAddressList(currentPage);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		response.getWriter().write(jsonStr);
		
	}

}
