package com.jdbc;
																//STEP 1 : Import the SQL packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
	static String url = "jdbc:mysql://localhost:3306/newdb";
	static String dbUser = "root";
	static String dbPass = "rahulrj";
	
	static Connection con = null ; 
	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");						//STEP 2 : Load & register the driver 
			con = DriverManager.getConnection(url, dbUser, dbPass);			//STEP 3 : Establish the connection
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DRIVER CLASS
	public static void main(String[] args) 						
	{
//		int resultCount = inserUser(106, "veer" , "ver");
//		System.out.println(resultCount+" row/s affected !");
		
		boolean validUserResult = validateLoginCredentials("rahul", "rr");
		System.out.println("ValidUserResult : "+validUserResult);
		
		showAllEmp();
		
//		closeConnection();
	}

	public static int inserUser(int id, String uname, String pass) 
	{
		int count = 0;
		try {
			String query = "INSERT INTO emplogin VALUES (?,?,?)";			
			
			PreparedStatement ps = con.prepareStatement(query);				//STEP 4 : Create the Statement 
			ps.setInt(1, id);
			ps.setString(2, uname);
			ps.setString(3, pass);	
			count = ps.executeUpdate();										//STEP 5 : Execute the query
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
		
	}

	public static boolean validateLoginCredentials(String uname, String pass) {

		String sqlQuery = "select * from emplogin where username=? and password=?";

		try {
			
			PreparedStatement ps = con.prepareStatement(sqlQuery);			//STEP 4 : Create the Statement 
			ps.setString(1, uname);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();								//STEP 5 : Execute the query
			if (rs.next()) {												//STEP 6 : Process the result
				return true;
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
	public static void showAllEmp() {

		try {

//			String query1 = "SELECT * FROM newdb.emplogin where empid=101";
			String query1 = "SELECT * FROM emplogin";			// ORDER BY id DESC";

			Statement st = con.createStatement();						//STEP 4 : Create the Statement 
			ResultSet rs = st.executeQuery(query1);						//STEP 5 : Execute the query

			while (rs.next()) {											//STEP 6 : Process the result

				int empId = rs.getInt(1);  				System.out.print("empId : "+empId + "	| ");
				String empName = rs.getString(2);		System.out.print("empName : "+empName + "	| ");
				String empPass = rs.getString(3);		System.out.print("empPass : "+empPass + "	| ");

				System.out.println();
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally 
		{
			closeConnection();
		}
	}
	
	public static void closeConnection() 
	{
		try {
			con.close();											//STEP 7 : 	Close the connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
