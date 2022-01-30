
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Scanner, java.util.Calendar " %>		<!-- JSP DIRECTIVES "import" -->
<%@ page import="java.sql.Statement" %>


<%@ include file="header.jsp" %>								<!-- JSP DIRECTIVES "include" -->


<!DOCTYPE html>
<html>
<head>
<title>JSP Home</title>
</head>
<body bgcolor = "#D5EBEE" >

	<%!										/* JSP DECLARATION tag ! */		
		Scanner kb;
		int m = 5;
	%>
	
	<%										/* JSP SCRIPTLET tag */
		int k = 4 + 5;
		out.println("Home Output is = " + k);
		
		pageContext.setAttribute("name", "rahul" , PageContext.SESSION_SCOPE);			// "pageContext" implicit obj in jsp
		
	 /* config.getInitParameter("phone"); */
		
	%>
	
	<br><br>
	My instance number is = <%= m %>		<!-- JSP EXPRESSION tag = -->

	
	
</body>
</html>