package evoting.contoller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));

		int k = a + b;
		System.out.println("K : "+k);
		
//		PrintWriter out = response.getWriter();
//		out.println("Output is = " + k);
    
		request.setAttribute("k", k);
		RequestDispatcher rd = request.getRequestDispatcher("showResult.jsp");
		rd.forward(request, response);
		
    }

}
