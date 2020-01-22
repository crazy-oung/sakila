package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {	
	// db瑜� �뿰寃고빐二쇰뒗 硫붿냼�뱶
	   public static Connection getConnection() throws Exception{
	       Class.forName("org.mariadb.jdbc.Driver");
	       // test db
	       Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/ho","root","java1234");
//	       Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/ho","root","java1234");
	       // cafe24 db	
//	       Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/crazyoung","crazyoung","gksekdud5610@");
	       return conn;
	   }
	   
	   // db瑜� 醫낅즺�븯�뒗 硫붿냼�뱶
	   public static void close(ResultSet rs, Statement stmt, Connection conn) {
	      if(rs != null) {
	         try {
	            rs.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      if(stmt != null) {
	         try {
	            stmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      if(conn != null) {
	         try {
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }
	

}
