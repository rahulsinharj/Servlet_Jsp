<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Add</title>
</head>
<body bgcolor="yellow">
	<!-- Here we write java code inside HTML using -->
	
 	<% 	
		int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));

		int k = a + b;
		
		out.println("Output is = " + k);
  	%>
  	
</body>
</html>