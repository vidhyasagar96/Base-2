package com.learnersacademy.servlets;

import java.io.IOException;
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

import com.learnersacademy.modal.Subject;
import com.learnersacademy.util.HibernateUtil;
public class ReadSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadSubject() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Subject> subjectsList = session.createQuery("select _subject from Subject _subject").getResultList();

			List<HashMap<Object, Object>> subjectsMapList = new ArrayList<>();
			for (Subject subject : subjectsList) {
				HashMap<Object, Object> subjectMap = new HashMap<>();
				subjectMap.put("subjectName", subject.getSubjectName());
				subjectMap.put("subjectId", subject.getSubjectId());
				subjectsMapList.add(subjectMap);
				//System.out.println(subject.getClass1().getClassName());
			}
			JSONArray jsonArray = new JSONArray(subjectsMapList);
			request.getRequestDispatcher("Dashboard.jsp?subjects=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	
	
	}

}
