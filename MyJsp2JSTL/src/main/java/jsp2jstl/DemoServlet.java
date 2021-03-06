package jsp2jstl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = "Rahul";
		req.setAttribute("label", name);
		
		Student s1 = new Student(201,"Shubham");
		req.setAttribute("stu1", s1);
		
		List<Student> students = Arrays.asList(new Student(102,"Vikash"),new Student(103,"Ramu"),new Student(104,"Ramesh"));
		req.setAttribute("students", students);
		
		RequestDispatcher rd = req.getRequestDispatcher("stuDisplay.jsp");		// req me set Attributes ko leke RequestDispatcher control ko forward kar dega "stuDisplay.jsp" ko  
		rd.forward(req, res);
		
		// or otherwise RD kisi @WebServlet("/servlet2"") wale url mapped servlet ko bhi request forward kar skta hai like -
		
//			RequestDispatcher rd = req.getRequestDispatcher("servlet2");	
//			rd.forward(req, res);
	}

}
