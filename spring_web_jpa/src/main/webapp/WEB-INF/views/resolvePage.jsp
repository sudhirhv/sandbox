<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri  = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resolve bugs</title>
</head>
<body>
	<h3> Resolve a bug </h3>
	<form:form commandName="bug" action="closeBug.view">
			Resolved by : <form:select path="resolvedBy.id">
								<form:option value="-1">--select--</form:option>
								<form:options items = "${employees}" itemLabel="name" itemValue="id"/>					
						  </form:select><br />	
		
			<table border="1">
				<tr>
					<th>Bug Id</th><th>Descrption</th>
					<th>Raised by</th><th>Raised Date</th>
				</tr>
				<c:forEach items="${bugs}" var ="b">
					<tr>
						<td>${b.bugId} </td>
						<td>${b.description} </td>
						<td>${b.raisedBy.name} </td>						
						<td>${b.raisedDate} </td>
						<td><form:radiobutton path="bugId" value="${b.bugId}"/></td>						
					</tr>			
				</c:forEach>			
			</table>			
			<button type = "submit">Close bug</button>
	
	</form:form>
</body>
</html>