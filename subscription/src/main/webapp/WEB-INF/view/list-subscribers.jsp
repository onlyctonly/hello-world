<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subscribers</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border-spacing: 0px;
}

table, th, td {
	padding: 5px;
	border: 1px solid black;
}
</style>
</head>
<body>

	<h2>Subscribers List</h2>
	<h3><a href="/greek/add">Add</a></h3>

	<table>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>given name</th>
			<th>surname</th>
			<th>department</th>
			<th>street</th>
			<th>street number</th>
			<th>area</th>
			<th>tk</th>
			<th>copies</th>
			<th>start_date</th>
			<th>end_date</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="tempvar" items="${greeksubscribers}">
		
				<c:url var="updateLink" value="/greek/update">
					<c:param name="id" value="${tempvar.id}"></c:param>
				</c:url>
				
				<c:url var="deleteLink" value="/greek/delete">
					<c:param name="id" value="${tempvar.id}"></c:param>
				</c:url>
		
			<tr>
				<td>${tempvar.id}</td>
				<td>${tempvar.title}</td>
				<td>${tempvar.givenname}</td>
				<td>${tempvar.surname}</td>
				<td>${tempvar.department}</td>
				<td>${tempvar.street}</td>
				<td>${tempvar.street_number}</td>
				<td>${tempvar.area}</td>
				<td>${tempvar.tk}</td>
				<td>${tempvar.copies}</td>
				<td>${tempvar.start_date}</td>
				<td>${tempvar.end_date}</td>
				<td><a href="${updateLink}">Edit</a> | <a href="${deleteLink}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>