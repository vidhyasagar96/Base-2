package com.learnersacademy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;

import com.learnersacademy.modal.Student;
import com.learnersacademy.util.HibernateUtil;


public class ReadStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ReadStudent() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Student> studentsList = session.createQuery("select _student from Student _student").getResultList();

			List<HashMap<Object, Object>> studentsMapList = new ArrayList<>();
			for (Student student : studentsList) {
				HashMap<Object, Object> studentMap = new HashMap<>();
				studentMap.put("studentName", student.getStudentName());
				studentMap.put("studentId", student.getStudentId());
				studentsMapList.add(studentMap);
				}
			
			JSONArray jsonArray = new JSONArray(studentsMapList);
			request.getRequestDispatcher("Dashboard.jsp?students=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
