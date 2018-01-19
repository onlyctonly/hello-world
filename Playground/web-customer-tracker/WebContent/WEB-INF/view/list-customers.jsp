<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer list</h2>
		</div>
	</div>
	
	<div id="container">
		<table>
			<tr>		
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
			</tr>
			<c:forEach var="tempvar" items="${customers}">
				<tr>
				<td>${tempvar.firstName}</td>
				<td>${tempvar.lastName}</td>
				<td>${tempvar.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>