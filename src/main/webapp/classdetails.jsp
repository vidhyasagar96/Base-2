<%@page import="com.learnersacademy.modal.Subject"%>
<%@page import="com.learnersacademy.modal.Teacher"%>
<%@page import="com.learnersacademy.modal.Student"%>
<%@page import="com.learnersacademy.modal.Class1"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.HashMap"%><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h2 {
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Class Info</title>
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
	<h2>Class Report</h2>

	<form action="Logout">
		<input type="submit" value="Logout" style="margin-left: 85%">
	</form>
	
	<%
	Class1 classInfo= (Class1)request.getAttribute("classInfo");
	classInfo.getClassId();
	%>

	
	<h2><%=classInfo.getClassName()%> </h2>
	<h4>List of students</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Student Id</th>
				<th>Student names</th>
			</tr>
		</thead>
		<tbody>
			<%

			for (Student student : classInfo.getStudents()) {
		
			%>
			<tr>
				<td><%=student.getStudentId()%></td>
				<td><%=student.getStudentName()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<h4>List of teachers</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Teacher Id</th>
				<th>Teacher names</th>
			</tr>
		</thead>
		<tbody>
			<%

			for (Teacher teacher : classInfo.getTeachers()) {
		
			%>
			<tr>
				<td><%=teacher.getTeacherId()%></td>
				<td><%=teacher.getTeacherName()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	
	<h4>List of Subjects</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Subject Id</th>
				<th>Subject names</th>
			</tr>
		</thead>
		<tbody>
			<%

			for (Subject subject : classInfo.getSubjects()) {
		
			%>
			<tr>
				<td><%=subject.getSubjectId()%></td>
				<td><%=subject.getSubjectName()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	</div> 
</body>
</html>