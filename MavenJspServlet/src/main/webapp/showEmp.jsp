<%@page import="com.mavenJspServlet.model.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Emp</title>
</head>
<body bgcolor="#ffd9b3">

<h1> In show Emp </h1>
<h2>	
	<%
		Emp e1 = (Emp)request.getAttribute("emp1");
		out.println(e1);	
		
	%>
</h2>	

</body>
</html>