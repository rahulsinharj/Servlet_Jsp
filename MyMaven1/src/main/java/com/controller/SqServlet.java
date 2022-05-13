package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		int k = (int)req.getAttribute("k");					// used when data coming from Request Dispatcher  
		
		
//		int k = Integer.parseInt(req.getParameter("k"));	// used when Parameter Data coming, either from browser URL rewriting and passing value through ? query symbol ; or through res.sendRedirect("sq?k="+k) URL redirecting.
		
		
		HttpSession session = req.getSession();				// Only used when data is passed through res.sendRedirect("sq") , in that case we have stored our data into Session class obj
		int k = (int)session.getAttribute("k");		   		// Fetching stored attribute value from Session.
		
		
//		int k = 0;
//		Cookie[] cookies = req.getCookies();				// Client will not send any single cookie, but it will send all the cookies in Cookie[] array
//		for(Cookie c : cookies) {
//			if(c.getName().equals("k"))
//				k = Integer.parseInt(c.getValue());
//		} 
		
		
		k= k*k;
		PrintWriter out = res.getWriter();
		out.println("Result is : " +k);
		
	}


}
