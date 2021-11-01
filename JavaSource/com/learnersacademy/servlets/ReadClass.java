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

import com.learnersacademy.modal.Class1;
import com.learnersacademy.util.HibernateUtil;

public class ReadClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Class1> classList = session.createQuery("select _class from Class1 _class").getResultList();

			List<HashMap<Object, Object>> classesMapList = new ArrayList<>();
			for (Class1 class1 : classList) {
				HashMap<Object, Object> classMap = new HashMap<>();
				classMap.put("className", class1.getClassName());
				classMap.put("classId", class1.getClassId());
				classesMapList.add(classMap);
				//System.out.println(class1.getClass1().getClassName());
			}
			JSONArray jsonArray = new JSONArray(classesMapList);
			request.getRequestDispatcher("Dashboard.jsp?classes=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}


}
