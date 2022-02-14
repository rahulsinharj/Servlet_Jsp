package servletfilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
   Servlet FILTER - writing a code for validating something ,  and using that same code like plug and use it on different diff other servlets as well.
   Also one filter is not dependent is not other filter.

*/
@WebServlet("/addme")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
		int uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		
		out.println("Welcome  "+uname);
	}

}
