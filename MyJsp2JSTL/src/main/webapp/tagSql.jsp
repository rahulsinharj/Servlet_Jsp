<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>      
    
<!DOCTYPE html>
<html>
<head>
<title>JSTL SQL Tag</title>
</head>
<body>

	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/newdb" user="root" password="rahulrj" />

	<sql:query var="rs" dataSource="${db}" > select * from emp</sql:query>
	
	<c:forEach items="${rs.rows}" var="employee">			<!-- // taking each row as "items" , and putting that each row in "var"  -->
	
		<c:out value="${employee.empid}" /> : <c:out value="${employee.empname}" /> : <c:out value="${employee.city}" /> <br>
	
	</c:forEach>
	
</body>
</html>
