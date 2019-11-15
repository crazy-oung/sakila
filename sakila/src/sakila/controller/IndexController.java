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

import sakila.address.model.AddressDao;
import sakila.address.model.CityDao;
import sakila.address.model.CountryDao;
import sakila.business.model.PaymentDao;
import sakila.business.model.RentalDao;
import sakila.business.model.StaffDao;
import sakila.business.model.StoreDao;
import sakila.customer.model.CustomerDao;
import sakila.inventory.model.ActorDao;
import sakila.inventory.model.CategoryDao;
import sakila.inventory.model.FilmActorDao;
import sakila.inventory.model.FilmCategoryDao;
import sakila.inventory.model.FilmDao;
import sakila.inventory.model.FilmTextDao;
import sakila.inventory.model.InventoryDao;
import sakila.inventory.model.LanguageDao;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 14개의 DAO 추가 
		 */
		response.setContentType("application/json;charset/utf-8");	// 캐릭터 셋
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		ActorDao actorDao = new ActorDao();
		int actorRow = actorDao.selectActorCount();
		map.put("actorRow", actorRow);
		
		AddressDao addressDao = new AddressDao();
		int addressRow = addressDao.selectAddressCount();
		map.put("addressRow", addressRow);

		CategoryDao categoryDao = new CategoryDao();
		int categoryRow = categoryDao.selectCategoryCount();
		map.put("categoryRow", categoryRow);
		
		CityDao cityDao = new CityDao(); 
		int cityRow = cityDao.selectCityCount();
		map.put("cityRow", cityRow);
		
		CountryDao countryDao = new CountryDao();
		int countryRow = countryDao.selectCountryCount();
		map.put("countryRow", countryRow);
		
		CustomerDao customerDao = new CustomerDao();
		int customerRow = customerDao.selectCustomerCount();
		map.put("customerRow", customerRow);
		
		FilmDao filmDao = new FilmDao();
		int filmRow = filmDao.selectFilmCount();
		map.put("filmRow", filmRow);
		
		FilmActorDao filmActorDao = new FilmActorDao();
		int filmActorRow = filmActorDao.selectFilmActorCount();
		map.put("filmActorRow", filmActorRow);
		
		FilmCategoryDao filmCategoryDao = new FilmCategoryDao();
		int filmCategoryRow = filmCategoryDao.selectFilmCategoryCount();
		map.put("filmCategoryRow", filmCategoryRow);
		
		FilmTextDao filmTextDao = new FilmTextDao();
		int filmTextRow = filmTextDao.selectFilmTextCount();
		map.put("filmTextRow", filmTextRow);
		
		InventoryDao inventoryDao = new InventoryDao();
		int inventoryRow = inventoryDao.selectInventoryCount();
		map.put("inventoryRow", inventoryRow);
		
		LanguageDao languageDao = new LanguageDao();
		int languageRow = languageDao.selectLanguageCount();
		map.put("languageRow", languageRow);
		
		PaymentDao paymentDao = new PaymentDao();
		int paymentRow = paymentDao.selectPaymentCount();
		map.put("paymentRow", paymentRow);
		
		RentalDao rentalDao = new RentalDao();
		int rentalRow = rentalDao.selectRentalCount();
		map.put("rentalRow", rentalRow);
		
		StaffDao staffDao = new StaffDao();
		int staffRow = staffDao.selectStaffCount();
		map.put("staffRow", staffRow);
		
		StoreDao storeDao = new StoreDao();
		int storeRow = storeDao.selectStoreCount();
		map.put("storeRow", storeRow);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		response.getWriter().write(jsonStr);
		
	}
	 
}
