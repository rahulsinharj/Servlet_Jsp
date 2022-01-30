<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   errorPage="errorHandler.jsp"  %>			
    																<!-- errorPage="" se tomcat Server ko bata rahe hai ki jab bhi error aaye iss jsp page me error aaye to "errorHandler.jsp" ka conten t ko call kar do -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exception check</title>
</head>
<body bgcolor = "#C3EDDA">


Hii Exception 	<br>
	
	<%
		out.println("pp");
		
		int m = 5/2;
		out.println("M is = " +m);
	%>

</body>
</html>
