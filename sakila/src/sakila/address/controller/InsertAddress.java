package sakila.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.AddressDao;
import sakila.customer.model.Address;
import sakila.customer.model.City;

@WebServlet("/address/InsertAddress")
public class InsertAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressDao addressDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("::: InsertAddress Servlet 실행 :::");
		response.setContentType("application/json;charset=utf-8");
		int addressId = Integer.parseInt(request.getParameter("addressId"));
		System.out.println("addressId: "+ addressId);
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		System.out.println("city: "+ cityId);
		String address = request.getParameter("address");
		System.out.println("address"+ address);
		String address2 = request.getParameter("address2");
		System.out.println("address2: "+ address2);
		String district = request.getParameter("district");
		System.out.println("district: "+ district);
		String postalCode = request.getParameter("postalCode");
		System.out.println("postalCode: "+ postalCode);
		String phone = request.getParameter("phone");
		System.out.println("phone: "+ phone);
		
		addressDao = new AddressDao();
		Address a = new Address();
		a.setCity(new City());
		a.getCity().setCityId(cityId);
		a.setAddressId(addressId);
		a.setAddress(address);
		a.setAddress2(address2);
		a.setDistrict(district);
		a.setPostalCode(postalCode);
		a.setPhone(phone);
		int row = addressDao.insertAddress(a);
		
		Gson gson = new Gson();
		String jsonCount = gson.toJson(row);
		response.getWriter().write(jsonCount);
	}

}
