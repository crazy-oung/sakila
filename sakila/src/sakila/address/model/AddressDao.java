package sakila.address.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import sakila.customer.model.Address;
import sakila.customer.model.City;

public class AddressDao {
	public List<Address> selectAddressListByCountry(int countryId){
		System.out.println("::: selectAddressListByCountry 실행 :::");
		List<Address> list = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT address_id, address, address2, city_id, district, postal_code, phone, last_update  FROM address limit ?, ?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, countryId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Address c = new Address();
				c.setAddressId(rs.getInt("Address_id"));
				c.setAddress(rs.getString("Address"));
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
	
	public List<Address> selectAddressList(int currentPage){
		System.out.println("::: selectAddressList 실행 :::");
		List<Address> list = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ROW_PER_PAGE = 10;
		int beginRow = (currentPage -1)*ROW_PER_PAGE;
		System.out.println("currnetPage: "+currentPage+" beginrow: "+beginRow);
		String sql = "SELECT a.address_id, a.address, a.address2, c.city_id, a.district, a.postal_code, a.phone, a.last_update"
				+ " FROM address a inner join city c on c.city_id = a.address_id order by a.address_id desc limit ?, ?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, ROW_PER_PAGE);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Address a = new Address();
				a.setAddressId(rs.getInt("a.address_id"));
				a.setAddress(rs.getString("a.address"));
				a.setAddress2(rs.getString("a.address2"));
				a.setCity(new City());
				a.getCity().setCityId(rs.getInt("c.city_id"));
				a.setDistrict(rs.getString("a.district"));
				a.setPostalCode(rs.getString("a.postal_code"));
				a.setPhone(rs.getString("a.phone"));
				a.setLastUpdate(rs.getString("a.last_update"));
				list.add(a);
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
	
	public int insertAddress(Connection conn, Address Address) {
		System.out.println("::: insertAddress실행 :::");
		int addressId = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int row =0;
		String sql = "insert into Address(address, address2, city_id, district, postal_code, phone, last_update)"
				+ " values(?,?,?,?,?,?, now())";		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, Address.getAddress());
			stmt.setString(2, Address.getAddress2());
			stmt.setInt(3, Address.getCity().getCityId());
			stmt.setString(4, Address.getDistrict());
			stmt.setString(5, Address.getPostalCode());
			stmt.setString(6, Address.getPhone());
			row = stmt.executeUpdate();
			System.out.println("영향을 받은 행:" + row);
			rs =  stmt.getGeneratedKeys();
			if(rs.next()) {
				addressId = rs.getInt(1);
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
		return row;
	}
	
	public int selectAddressCount(){
		System.out.println("::: selectAddressCount 실행 :::");
		Connection conn = null;
		PreparedStatement stmt = null;
		int count = 0;
		String sql = "select count(*) from Address";		
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
