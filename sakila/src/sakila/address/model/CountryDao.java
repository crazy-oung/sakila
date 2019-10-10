package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import sakila.customer.model.City;
import sakila.customer.model.Country;

public class CountryDao {
	public List<Country> selectCountryListAll(){
		System.out.println("::: selectCountryListAll 실행 :::");
		List<Country> list = new ArrayList<Country>(); 
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select country, country_id from country order by country_id asc ";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Country c = new Country();
				c.setCountry(rs.getString("country"));
				c.setCountryId(rs.getInt("country_id"));
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
	
	public List<Country> selectCountryList(int currentPage){
		System.out.println("::: selectCountryList 실행 :::");
		List<Country> list = new ArrayList<Country>(); 
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ROW_PER_PAGE = 10;
		int beginRow = (currentPage -1)*ROW_PER_PAGE;
		System.out.println("currnetPage: "+currentPage+" beginrow: "+beginRow);
		String sql = "select * from country order by country_id desc limit ?,?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, ROW_PER_PAGE);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Country c = new Country();
				c.setCountryId(rs.getInt("country_id"));
				c.setCountry(rs.getString("country"));
				c.setLastUpdate(rs.getString("last_update"));
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
	
	public void insertCountry(Country country) {
		System.out.println("::: insertCountry 실행 :::");
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into country(country, last_update) values(?, now())";		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, country.getCountry());
			int row = stmt.executeUpdate();
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
	}
	
	public int selectCountryCount(){
		System.out.println("::: selectCountryCount 실행 :::");
		Connection conn = null;
		PreparedStatement stmt = null;
		int count = 0;
		String sql = "select count(*) from country";		
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
