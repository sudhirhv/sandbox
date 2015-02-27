<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Bug Tracker application</title>
</head>
<body>
	<h3>Bug Tracker application</h3>
	${message} <br>
	${param.message} <br>
	<a href="addEmployee.view">Add a new employee</a> <br>
	<a href="reportBug.view">Report bug</a><br>
	<a href="resolveBug.view">Resolve bug</a><br>
	<a href="viewBugs.view">Show all bugs</a><br>	
</body>
</html>