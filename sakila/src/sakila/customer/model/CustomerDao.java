package sakila.customer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;

public class CustomerDao {

	public List<Customer> selectCustomerList(int currentPage){
		System.out.println("::: selectCustomerList 실행 :::");
		List<Customer> list = new ArrayList<Customer>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ROW_PER_PAGE = 10;
		int beginRow = (currentPage -1)*ROW_PER_PAGE;
		System.out.println("currnetPage: "+currentPage+" beginrow: "+beginRow);
		String sql = "SELECT c.customer_id, c.store_id, c.first_name, c.last_name, c.email, c.active, c.create_date, c.last_update, c.address_id"
				+ " FROM customer c left outer join address a on a.address_id = c.customer_id order by c.customer_id desc limit ?, ?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, ROW_PER_PAGE);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerId(rs.getInt("c.customer_id"));
				c.setStoreId(rs.getInt("c.store_id"));
				c.setFirstName(rs.getString("c.first_name"));
				c.setLastName(rs.getString("c.last_name"));
				c.setEmail(rs.getString("c.email"));
				c.setActive(rs.getInt("c.active"));
				c.setAddressId(rs.getInt("c.address_id"));
				c.setCreateDate(rs.getString("c.create_date"));
				c.setLastUpdate(rs.getString("c.last_update"));
				list.add(c);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {				
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return list;
	}
	
	public int insertCustomer(Customer customer){
		System.out.println("::: insertCustomer 실행 :::");
		Connection conn = null;
		PreparedStatement stmt = null;
		int row =0;
		String sql = "insert into customer(store_id, first_name, last_name, email, active, create_date, last_update, address_id)"
				+ " values(?,?,?,?,1,now(), now(),?)";		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, customer.getStoreId());
			stmt.setString(2, customer.getFirstName());
			stmt.setString(3, customer.getLastName());
			stmt.setString(4, customer.getEmail());
			stmt.setInt(5, customer.getAddressId());
			row = stmt.executeUpdate();
			System.out.println(row);
		}catch (Exception e) {
			e.printStackTrace();
		}finally { 
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return row;
	}
	
	public int selectCustomerCount(){
		System.out.println("::: selectCustomerCount 실행 :::");
		Connection conn = null;
		PreparedStatement stmt = null;
		int count = 0;
		String sql = "select count(*) from customer";		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);	
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return count;
	}
	

}
