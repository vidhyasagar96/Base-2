package com.learnersacademy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		// Username is admin and password is learning
		if (!uname.equalsIgnoreCase("admin"))
			response.sendRedirect("invalid.jsp?error=1");
		
		else if (!password.equals("learning"))
			response.sendRedirect("invalid.jsp?error=2");
		
		else if (uname.equalsIgnoreCase("admin") && (password.equals("learning"))){
			
			HttpSession session = request.getSession();
			session.setAttribute("username",uname);
			
			response.sendRedirect("Dashboard.jsp");
			
			}
		}
		
	}
