package sakila.inventory.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBHelper;

public class InventoryDao {
	public int selectInventoryCount(){
		System.out.println("::: selectInventoryCount 실행 :::");
		Connection conn = null;
		PreparedStatement stmt = null;
		int count = 0;
		String sql = "select count(*) from inventory";		
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
