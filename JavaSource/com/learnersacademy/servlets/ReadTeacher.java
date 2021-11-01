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

import com.learnersacademy.modal.Teacher;
import com.learnersacademy.util.HibernateUtil;

public class ReadTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ReadTeacher() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Teacher> teachersList = session.createQuery("select _teacher from Teacher _teacher").getResultList();
			PrintWriter out = response.getWriter();
			out.println("teachersList" + teachersList);

			List<HashMap<Object, Object>> teachersMapList = new ArrayList<>();
			for (Teacher teacher : teachersList) {
				HashMap<Object, Object> teacherMap = new HashMap<>();
				teacherMap.put("teacherName", teacher.getTeacherName());
				teacherMap.put("teacherId", teacher.getTeacherId());
				teachersMapList.add(teacherMap);
			}
			JSONArray jsonArray = new JSONArray(teachersMapList);
			request.getRequestDispatcher("Dashboard.jsp?teachers=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
