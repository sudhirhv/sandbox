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
	Bug report form <br/ >
	<form:form commandName="bug" action = "addBug.view">
	<form:errors path="*" cssClass="errorClass" /> <!-- display errors of all fields --> 
			Description: <form:input path="description" />
					<form:errors path="description" cssClass="errorClass"></form:errors><br />			
			Raised by : <form:select path="raisedBy.id">
							<form:option value="-1">--select--</form:option>
							<form:options items = "${employees}" itemLabel="name" itemValue="id"/>					
						</form:select><br />
			Select Project : <form:select path="project.projectId">
							<form:option value="-1">--select--</form:option>
							<form:options items = "${projects}" itemLabel="name" itemValue="projectId"/>					
						</form:select><br />
			
			
			
			<button type ="submit">Add Bug</button>
	</form:form>
</body>
</html>