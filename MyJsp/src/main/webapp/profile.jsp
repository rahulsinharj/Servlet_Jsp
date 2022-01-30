<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
Hi Profile <br>

	<%
		String url = "jdbc:mysql://localhost:3306/newdb";
		String username = "root";
		String password = "rahulrj";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
	
		String query1 = "SELECT * FROM newdb.emp where empid=101";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query1);
		
		rs.next();
		
		out.println("Working fine..");
	%>
	<br><br>
	
	Emp_Id   : <%= rs.getInt(1) 	%>	<br>
	Emp_Name : <%= rs.getString(2) 	%>	<br>
	Emp_Age  : <%= rs.getInt(3) 	%>	<br>
	Emp_City : <%= rs.getString(4) 	%>	<br>


</body>
</html>