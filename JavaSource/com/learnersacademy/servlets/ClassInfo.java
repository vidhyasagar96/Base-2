package com.learnersacademy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learnersacademy.modal.Class1;
import com.learnersacademy.util.HibernateUtil;

public class ClassInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassInfo() {
        super();
    }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int classId = Integer.parseInt(request.getParameter("id"));
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction  = session.beginTransaction();

        Class1 class1 = session.get(Class1.class, classId);
		transaction.commit();
		request.setAttribute("classInfo", class1);
		request.getRequestDispatcher("classdetails.jsp?classId="+ classId).forward(request, response);
		
	}


}
