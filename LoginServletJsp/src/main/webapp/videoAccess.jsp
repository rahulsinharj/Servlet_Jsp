<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Video Access</title>
</head>
<body bgcolor =#ffd9b3>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	//Only supported by HTML 1.1v and later.	// so that when user clicks "logout" , after that even if user tries to back button, it wil not show its previous page content after logout.
		
		response.setHeader("Pragma", "no-cache");			// for handling back-button cache control in HTML older version before 1.1v
							
		response.setHeader("Expires", "0");		// When we are also using any PROXIES servers ,  we have to told the proxy to expire this page in 0sec, after this page visit it will be gone/expire
	
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	%>
	
<h2> ${username} is accessing Video !!   </h2>

	
	<iframe width="560" height="315" 
			src="https://www.youtube.com/embed/OuBUUkQfBYM" 
			title="YouTube video player" 
			frameborder="0" 
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
			allowfullscreen>
	</iframe>


<br><br>
	<form action="logout">
		<input type="submit" value="logout" >
	</form>
	
	
	
</body>
</html>