package com.mavenJspServlet;

import java.io.IOException;

import com.mavenJspServlet.dao.EmpDao;
import com.mavenJspServlet.model.Emp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetEmpController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int empid =  Integer.parseInt(request.getParameter("eid"));
		EmpDao empd = new EmpDao();
		Emp e1 = empd.getEmp(empid);
		
		request.setAttribute("emp1", e1);
		RequestDispatcher rd = request.getRequestDispatcher("showEmp.jsp");
		rd.forward(request, response);
		

	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

}
