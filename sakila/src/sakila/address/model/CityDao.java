package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import db.DBHelper;
import sakila.customer.model.City;
import sakila.customer.model.Country;

public class CityDao {
	
	public List<City> selectCityListByCountry(int countryId){
		System.out.println("::: selectCityListByCountry 실행 :::");
		List<City> list = new ArrayList<City>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT city_id, city FROM city WHERE country_id = ?";
		try {
			conn = DBHelper.getConncetion();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, countryId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				City c = new City();
				c.setCityId(rs.getInt("city_id"));
				c.setCity(rs.getString("city"));
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
	
	public List<City> selectCityList(int currentPage){
		System.out.println("::: selectCityList 실행 :::");
		List<City> list = new ArrayList<City>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ROW_PER_PAGE = 10;
		int beginRow = (currentPage -1)*ROW_PER_PAGE;
		System.out.println("currnetPage: "+currentPage+" beginrow: "+beginRow);
		String sql = "select ct.city, ct.city_id, ct.last_update, c.country, c.country_id, c.last_update"
				+ " from city ct inner join country c on c.country_id = ct.country_id order by ct.city_id desc limit ?,?";
		try {
			conn = DBHelper.getConncetion();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, ROW_PER_PAGE);
			rs = stmt.executeQuery();
			while(rs.next()) {
				City c = new City();
				c.setCityId(rs.getInt("ct.city_id"));
				c.setCity(rs.getString("ct.city"));
				c.setLastUpdate(rs.getString("ct.last_update"));
				c.setCountry(new Country());
				c.getCountry().setCountryId(rs.getInt("c.country_id"));
				c.getCountry().setCountry(rs.getString("c.country"));
				c.getCountry().setLastUpdate(rs.getString("c.last_update"));
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
	
	public void insertCity(City city) {
		System.out.println("::: insertCity실행 :::");
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into city(city, last_update, country_id) values(?, now(), ?)";		
		try {
			conn = DBHelper.getConncetion();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getCity());
			stmt.setInt(2, city.getCountry().getCountryId());
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
	
	public int selectCityCount(){
		System.out.println("::: selectCityCount 실행 :::");
		Connection conn = null;
		PreparedStatement stmt = null;
		int count = 0;
		String sql = "select count(*) from city";		
		try {
			conn = DBHelper.getConncetion();
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
