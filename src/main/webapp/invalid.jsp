<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error page</title>
</head>
<body>
	<%
		Integer errorCode = Integer.parseInt(request.getParameter("error"));
		if (errorCode == 1) {
			out.println("<h2> Username doesn't exist. Enter a valid username </h2>");
	
		} else if (errorCode == 2) {
			out.println("<h2> Your password is invalid. Please try again </h2>");
		}
	%>

	Click <a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> here</a> to login again.

</body>
</html>