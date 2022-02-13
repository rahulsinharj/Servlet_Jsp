package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
  Using : ServletContext and ServletConfig
  		  				We use these two things to get the initial values for the servlet.
						For that we can specify some parameters in web.xml Deployment Descriptor.
						
  ServletContext - is an obj which will be shared by ALL the servlets. So if you have multiple servlets which will share any same value of any variable/property, then go with ServletContext. 
  ServletConfig - If we have 5 servlets, then in total we will have 5 diff ServletConfig object;  but we will have only one shared ServletContext obj. So if you have different values for different servlets of any property, good to go for ServletConfig.
	
 # How to RUN this for checking MyServlet_ContextConfig woking ??
   Ans = RightClick application "MyServlet" -> Run as -> Run on Server 
   		 Change the url to http://localhost:2000/MyServlet/home
				
*/
public class MyServlet_ContextConfig extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		out.println("Hi Home ");
		
		
		ServletConfig cfg = getServletConfig();
		String str =  cfg.getInitParameter("name");
		out.println("ServletConfig - init-param : "+str);
		
		
		ServletContext ctx = getServletContext(); 		// We are getting this method from HttpServlet class
		String nm = ctx.getInitParameter("name");
		String ph = ctx.getInitParameter("phone");
		
		out.println("ServletContext - context-param : " +nm +" ---- "+ph);
				
/*
 * Also instead of using => ctx.getInitParameter("name"); through mapped <context-param><param-name><param-value> in web.xml
 	, We can also add values directly from ServletJava Class through ServletContext by using  => context.setAttribute("list",list);  
 	
 * Refer this video -  https://youtu.be/-AH4yV2FGwM																	
*/
 

		
	}
}
