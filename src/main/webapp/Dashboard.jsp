<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.HashMap"%><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<style>
h2 {
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<div class="container mt-3">

		<h2>Welcome to Learner's academy</h2>

		<a href="students">
			<button class="btn btn-primary">View students</button>
		</a> <a href="teachers">
			<button class="btn btn-primary">View teachers</button>
		</a> <a href="subjects">
			<button class="btn btn-primary">View subjects</button>
		</a> <a href="classes">
			<button class="btn btn-primary">View class info</button>
		</a>

		<form action="Logout">
			<input type="submit" value="Logout" style="margin-left: 85%">
		</form>

		<%
		String students = request.getParameter("students");
		if (Objects.nonNull(students)) {
		%>
		<h3>List of Students</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Student Id</th>
					<th>Student name</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<HashMap<Object, Object>> studentsList = new ObjectMapper().readValue(students, List.class);

				for (HashMap<Object, Object> eachMap : studentsList) {
					int studentId = (Integer) eachMap.get("studentId");
					String studentName = (String) eachMap.get("studentName");
				%>
				<tr>
					<td><%=studentId%></td>
					<td><%=studentName%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>


		<%
		String teachers = request.getParameter("teachers");
		if (Objects.nonNull(teachers)) {
		%>
		<h3>List of Teachers</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Teacher Id</th>
					<th>Teacher name</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<HashMap<Object, Object>> teachersList = new ObjectMapper().readValue(teachers, List.class);

				for (HashMap<Object, Object> eachMap : teachersList) {
					int teacherId = (Integer) eachMap.get("teacherId");
					String teacherName = (String) eachMap.get("teacherName");
				%>
				<tr>
					<td><%=teacherId%></td>
					<td><%=teacherName%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>

		<%
		String classes = request.getParameter("classes");
		if (Objects.nonNull(classes)) {
		%>
		<h3>List of Classes</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Class Id</th>
					<th>Class name</th>
					<th>Detailed view</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<HashMap<Object, Object>> classesList = new ObjectMapper().readValue(classes, List.class);

				for (HashMap<Object, Object> eachMap : classesList) {
					int classId = (Integer) eachMap.get("classId");
					String className = (String) eachMap.get("className");
				%>
				<tr>
					<td><%=classId%></td>
					<td><%=className%></td>
					<td><a href="classinfo?id=<%=classId%>">View</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>

		<%
		String subjects = request.getParameter("subjects");
		if (Objects.nonNull(subjects)) {
		%>
		<h3>List of Subjects</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Subject Id</th>
					<th>subject name</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<HashMap<Object, Object>> subjectsList = new ObjectMapper().readValue(subjects, List.class);

				for (HashMap<Object, Object> eachMap : subjectsList) {
					int subjectId = (Integer) eachMap.get("subjectId");
					String subjectName = (String) eachMap.get("subjectName");
				%>
				<tr>
					<td><%=subjectId%></td>
					<td><%=subjectName%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>

		<%
		String classId = request.getParameter("classId");
		if (Objects.nonNull(classId)) {
		%>
		<h3>List of class details</h3>
		<p><%=classId%></p>
		<%
		}
		%>

	</div>

</body>
</html>