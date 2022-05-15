package com.jdbcDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDao {

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
		Emp s1 = new Emp(108, "Sneha Sinha", "snehaaa");
		int resultCount = saveEmpUser(s1);
		System.out.println(resultCount+" row/s affected !");
		
		ArrayList<Emp> allEmp = getAllEmp();
		
		for(Emp e : allEmp) {
			System.out.println(e);
		}
	
	}

	private static int saveEmpUser(Emp s1) 
	{
		int count = 0;
		try {
			String query = "INSERT INTO emplogin VALUES (?,?,?)";			
			
			PreparedStatement ps = con.prepareStatement(query);				//STEP 4 : Create the Statement 
			ps.setInt(1, s1.getId());
			ps.setString(2, s1.getUsername());
			ps.setString(3, s1.getPassword());	
			count = ps.executeUpdate();										//STEP 5 : Execute the query
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;	
	}
	
	private static ArrayList<Emp> getAllEmp() 
	{
		ArrayList<Emp> empList = new ArrayList<Emp>();
		try {

//			String query1 = "SELECT * FROM newdb.emplogin where id=101";
			String query1 = "SELECT * FROM emplogin";			// ORDER BY id DESC";

			Statement st = con.createStatement();						//STEP 4 : Create the Statement 
			ResultSet rs = st.executeQuery(query1);						//STEP 5 : Execute the query

			while (rs.next()) {											//STEP 6 : Process the result

				int empId = rs.getInt(1);  				
				String empName = rs.getString(2);		
				String empPass = rs.getString(3);		
				
				empList.add(new Emp(empId, empName, empPass));
			
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally 
		{
			closeConnection();
		}
		
		return empList;
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
