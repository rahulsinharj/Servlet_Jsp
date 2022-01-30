package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class SqServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//		int k = (int)req.getAttribute("k");					// used when data coming from Request Dispatcher  
		
		
//		int k = Integer.parseInt(req.getParameter("k"));	// used when Parameter Data coming, either from browser URL rewriting and passing value through ? query symbol ; or through res.sendRedirect("sq?k="+k) URL redirecting.
		
		
		HttpSession session = req.getSession();				// Only used when data is passed through res.sendRedirect("sq") , in that case we have stored our data into Session class obj
		int k = (int)session.getAttribute("k");		   		// Fetching stored attribute value from Session.
		
		
//		int k = 0;
//		Cookie[] cookies = req.getCookies();				// Client will not send any single cookie, but it will send all the cookies in Cookie[] array
//		for(Cookie c : cookies) {
//			if(c.getName().equals("k"))
//				k = Integer.parseInt(c.getValue());
//		} 
		
		
		k= k*k;
		PrintWriter out = res.getWriter();
		out.println("Result is : " +k);
		
		myconnection(res);					// Just checking and ensuring working of JDBC; Do include mySqlConnector JAR file in "/MyJsp2Servlet/src/main/webapp/WEB-INF/lib/mysql-connector-java-8.0.28.jar"
		
		
//		session.removeAttribute("k");		// At last for removing that stored attribute "k" from Session
		
	}

	public void myconnection(HttpServletResponse res) throws IOException 
	{
		try {
			
			PrintWriter out = res.getWriter();
			out.println("Inside MYConnection");
			
			String url = "jdbc:mysql://localhost:3306/newdb";
			String username = "root";
			String password = "rahulrj";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);

//			String query1 = "SELECT * FROM newdb.emp where empid=101";
			String query1 = "SELECT * FROM emp";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);

			while(rs.next()) {
				
				int empid = rs.getInt(1);			out.print(empid +" ");
				String ename = rs.getString(2);		out.print(ename +" ");
				int age = rs.getInt(3);				out.print(age +" ");
				String city = rs.getString(4);		out.print(city +" ");
				String dept = rs.getString(5);		out.print(dept +" ");	
				
				out.println();
			}
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
