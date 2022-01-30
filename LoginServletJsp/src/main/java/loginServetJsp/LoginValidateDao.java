package loginServetJsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginValidateDao {

	public boolean validateLoginCredentials(String uname, String pass) {
		
		String url = "jdbc:mysql://localhost:3306/newdb";
		String dbUser = "root";
		String dbPass = "rahulrj";
		
		String sqlQuery = "select * from login where username=? and password=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbUser, dbPass);
			
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return false; 
	}
}
