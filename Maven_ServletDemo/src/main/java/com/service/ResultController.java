package com.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/result")
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResultController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int k = (int)request.getAttribute("k");	
		int res = k*k;
		System.out.println("res : "+res);
		
		request.setAttribute("res", res);
		RequestDispatcher rd = request.getRequestDispatcher("showResult.jsp");
		rd.forward(request, response);
	}

	
}
