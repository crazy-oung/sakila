package sakila.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.Address;
import sakila.address.model.City;
import sakila.customer.model.Customer;
import sakila.customer.service.CustomerService;

@WebServlet("/customer/InsertCustomer")
public class InsertCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: InsertCustomer Servlet 실행 :::");
		
		response.setContentType("application/json;charset=utf-8");
		
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		System.out.println("city: "+ cityId);
		String address = request.getParameter("address");
		System.out.println("address: "+ address);
		String address2 = request.getParameter("address2");
		System.out.println("address2: "+ address2);
		String district = request.getParameter("district");
		System.out.println("district: "+ district);
		String postalCode = request.getParameter("postalCode");
		System.out.println("postalCode: "+ postalCode);
		String phone = request.getParameter("phone");
		System.out.println("phone: "+ phone);
		
		int storeId = Integer.parseInt(request.getParameter("storeId"));
		System.out.println("storeId: "+ storeId);
		String firstName = request.getParameter("firstName");
		System.out.println("firstName: "+ firstName);
		String lastName = request.getParameter("lastName");
		System.out.println("lastName: "+ lastName);
		String email = request.getParameter("email");
		System.out.println("email: "+ email);
	
		Address a = new Address();
		a.setCity(new City());
		a.getCity().setCityId(cityId);
		a.setAddress(address);
		a.setAddress2(address2);
		a.setDistrict(district);
		a.setPostalCode(postalCode);
		a.setPhone(phone);
		
		Customer c = new Customer();
		c.setStoreId(storeId);
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setEmail(email);
		
		CustomerService cs = new CustomerService();
		int TF = cs.insertCustomer(a, c);
		
		Gson gson = new Gson();
		String jsonCount = gson.toJson(TF);
		response.getWriter().write(jsonCount);
	}

}
