package com.mavenJspServlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mavenJspServlet.model.Emp;

public class EmpDao {

	public Emp getEmp(int eid) {
		
		Emp e = new Emp();
				
		String url = "jdbc:mysql://localhost:3306/newdb";
		String dbUser = "root";
		String dbPass = "rahulrj";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbUser, dbPass);
		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM emp where empid=" +eid);

			if(rs.next()){

				e.setEmpid(rs.getInt("empid"));
				e.setEmpname(rs.getString("empname"));
				e.setAge(rs.getInt("age"));
				e.setCity(rs.getString("city"));
			}	

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return e;
	}
	
}
  