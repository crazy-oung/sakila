package sakila.customer.service;

import java.sql.Connection;

import db.DBHelper;
import sakila.address.model.Address;
import sakila.address.model.AddressDao;
import sakila.customer.model.Customer;
import sakila.customer.model.CustomerDao;

public class CustomerService {
   private AddressDao addressDao;
   private CustomerDao customerDao;
   
   public int insertCustomer(Address address, Customer customer) {
	   System.out.println("::: insertCustomer From SERVICE 실행:::");
	   
      Connection conn = null;      
	   try {
	      conn = DBHelper.getConnection();
	      conn.setAutoCommit(false);
	      
	      addressDao = new AddressDao();  
	      int addressId = addressDao.insertAddress(conn,address);
	      customer.setAddressId(addressId);
	      
	      customerDao = new CustomerDao();
	      customerDao.insertCustomer(customer);
	      conn.commit();
	   }catch(Exception e) {
		   //예외 발생시 롤백
	      try {
	         conn.rollback();
	         return 0;
	      }catch(Exception e1) {
	    	  e.printStackTrace();
	      }finally {
	    	  return 0;
	      }
	   } finally {
		   // 성공시 닫아줌
		   DBHelper.close(null, null, conn);
		   return 1;
	   }
   }
   
}