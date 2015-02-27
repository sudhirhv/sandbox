<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employees</title>
<style type="text/css">
	.errorClass {
		color : red;
	}
</style>
</head>
<body>
	Employee insert form <br/ >
	<form:form commandName="employee" action = "insertEmployee.view">
	<form:errors path="*" cssClass="errorClass" /> <!-- display errors of all fields -->			
			First Name : <form:input path="name"/>
						<form:errors path="name" cssClass="errorClass"></form:errors><br />
			Email : <form:input path="email"/>
						<form:errors path="email" cssClass="errorClass"></form:errors><br />			
			<button type ="submit">Add Employee</button>
	</form:form>
</body>
</html>