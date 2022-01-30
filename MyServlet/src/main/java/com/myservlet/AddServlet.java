package com.myservlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*	Using :
	 		RequestDispatcher.forward() 
	 		HttpSession session
	 		Cookie cookie
	 		res.sendRedirect()
*/
public class AddServlet extends HttpServlet {

/* "Req" obj will have all the data that the servlet needs [data from client -> to servlet]
		i.e, the Servlet will use the "request" obj to FETCH the data from the client. 
			
   "Res" obj will have all the data that the client needs [data from servlet -> to client]
   		i.e, then the Servlet will use the "response" obj to SEND the data from the client. 


   #  Here inspite of writing code in doGet() , if we write code here code in doPost() => then clientUser Browser console se index.html me <form> action method type=POST ko maually "GET" likh ke bhi kuch bhi karke iss doPost() method ka run access nhi mil payega 
   											, kyuki ye method tabhi aur tabhi chalega -> jab tak ki index.html code me <form> action method type=POST ke through hi request aarahi ho iss servlet me.
    
*/
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {	 
	//	Here we have written things in doGet() because we want to send a GET request from the browser {see in index.html <form> action method type=GET}.
		
		int a = Integer.parseInt(req.getParameter("num1"));
		int b = Integer.parseInt(req.getParameter("num2"));

		int k = a + b;
				
		
//		req.setAttribute("k", k);								// Using REQUEST obj to set the ATTRIBUTE , Setting and sending data through RequestDispatcher
//		RequestDispatcher rd = req.getRequestDispatcher("sq");	// sending the control to /sq mapped Servlet
//		rd.forward(req, res);
		
		
//		res.sendRedirect("sq?k="+k);						// Setting and sending parameter data by URL rewriting through res.sendRedirect
		
		
		HttpSession session = req.getSession();				// Storing and sending data through session class obj
		session.setAttribute("k", k );						// Using SESSION obj to set the ATTRIBUTE
		res.sendRedirect("sq");
		
		
//		Cookie cookie = new Cookie("k", k+"" );				// 2nd parameter of cookie obj demands only String value ; You can also use String.valueOf() in caes of primitive values.
//		res.addCookie(cookie);								// res. means we are sending this response "cookie" obj to the client ; So here AddServlet will send this response to the client and then client will again send the request to the "sq" servlet with the cookie as well.. 
//		res.sendRedirect("sq");
		
		
		
	}

}
