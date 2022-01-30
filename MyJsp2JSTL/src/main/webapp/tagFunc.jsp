<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<title>JSTL Function Tag</title>
</head>
<body>

	<c:set var="str" value="Rahul is a Java software Engineer" />
	
	Length of str : ${fn:length(str)}		<br>						<!-- Length method() in JSTL  -->

	<c:forEach items="${fn:split(str,' ')}" var="s">
	<br>	${s}														<!-- Split method() in JSTL  -->
	</c:forEach>
	
<br>
<br>  Index of word "software" :  ${fn:indexOf(str,"software")}			<!-- IndexOf method() in JSTL  -->
	
<br>  If str contains "Java" : ${fn:contains(str,"Java")}				<!-- Contains method() in JSTL  -->
<br>
<br>  <c:if test="${fn:contains(str,'Java')}">				<!-- If this str contains 'Java'  => using Contains method() inside IF() - JSTL tag  -->
		  Yes, IF-Condition TRUE , Java is there in str.
	  </c:if>		
<br>	
	  <c:if test="${fn:endsWith(str,'Engineer')}">			<!-- If this str endsWith 'Engineer' => using Contains method() inside IF() - JSTL tag  -->
			Yes correct, str ends with word 'Engineer'
	  </c:if>
	
<br>	
<br>	${fn:toLowerCase(str)}
<br>	${fn:toUpperCase(str)}	
	
	
	<%--  	For more methods of JSTL Fn , use CTRL+SPACE by writing 	${fn: } 		--%>
	
	
	
	
</body>
</html>
