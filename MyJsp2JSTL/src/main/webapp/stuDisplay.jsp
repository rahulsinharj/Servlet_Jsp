<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>  
<head>  
<title>JSTL Core Tag Example</title>  
</head>  
<body>  
Hi
		
<br> 	<c:out value="${'Welcome'}"/>  	
<br>	
<br>	Hello ${label}						<!-- All these  ${variable }  ${'text'} are EL_tags  -->

<br>	${stu1}
<br>	${stu1.name}						<!-- Here whenever we want to use student obj , we should be make sure that we use BEANS ; and to make a bean just we need is getters and setters in this Student class POJO -->
<br>	${stu1.rollno}
<br>
<br>	${students}	
<br>												<!-- Here 'items=' will ask for the reference of the List. So 'student' is the name of that list, and 'var s' will hold each student obj -->
<br>	<c:forEach items="${students}" var="s">		<!-- c:forEach   is the JSTL tag  // taking each row as "items" , and putting that each row in "var"  -->
			${s}  -----  ${s.name} <br/>
		</c:forEach>
		
 	

</body>  
</html>  