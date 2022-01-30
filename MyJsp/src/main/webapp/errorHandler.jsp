<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"  %>	<%-- Mentioning that this is EXCEPTION HANDLING page --%>
    												
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Handler</title>
</head>
<body bgcolor= "red">


<h1>
Error :  <br>

	<%=	exception.getMessage() %>
	
</h1>
</body>
</html>