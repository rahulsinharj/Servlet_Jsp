package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// Here we have written things in doGet() because we want to send a GET request
		// from the browser {see in index.html <form> action method type=GET}.

		int a = Integer.parseInt(req.getParameter("num1"));
		int b = Integer.parseInt(req.getParameter("num2"));

		int k = a + b;

//		req.setAttribute("k", k);								// Using REQUEST obj to set the ATTRIBUTE , Setting and sending data through RequestDispatcher
//		RequestDispatcher rd = req.getRequestDispatcher("sq");	// sending the control to /sq mapped Servlet
//		rd.forward(req, res);

//		res.sendRedirect("sq?k="+k);						// Setting and sending parameter data by URL rewriting through res.sendRedirect

		HttpSession session = req.getSession(); // Storing and sending data through session class obj
		session.setAttribute("k", k); // Using SESSION obj to set the ATTRIBUTE
		res.sendRedirect("sq");

//		Cookie cookie = new Cookie("k", k+"" );				// 2nd parameter of cookie obj demands only String value ; You can also use String.valueOf() in caes of primitive values.
//		res.addCookie(cookie);								// res. means we are sending this response "cookie" obj to the client ; So here AddServlet will send this response to the client and then client will again send the request to the "sq" servlet with the cookie as well.. 
//		res.sendRedirect("sq");
	
	
	}

}
