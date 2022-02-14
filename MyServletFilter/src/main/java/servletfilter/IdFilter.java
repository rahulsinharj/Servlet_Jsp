package servletfilter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

/*
  Servlet FILTER - writing a code for validating something ,  and using that same code like plug and use it on different diff other servlets as well.
   Also one filter is not dependent is not other filter.
*/


// Also instead of web.xml mapping for filter , we can use @WebFilter("/addme") ; the filter mapping should be same as servlet mapping. 
public class IdFilter extends HttpFilter {
       
 
	public void destroy() {

	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		int uid = Integer.parseInt(request.getParameter("uid"));
		if(uid >1)
			chain.doFilter(request, response);
		else
			out.println("Invalid input");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
