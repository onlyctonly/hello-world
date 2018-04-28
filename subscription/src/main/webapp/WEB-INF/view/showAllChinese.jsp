<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chinese Subscriber</title>
</head>
<body>
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
			<th>city</th>
			<th>tk</th>
			<th>start_date</th>
			<th>end_date</th>
			<th>copies</th>
			<th>comment</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="entry" items="${allChinese}">

			<c:url var="updateLink" value="/china/update">
				<c:param name="id" value="${entry.id}"></c:param>
			</c:url>

			<c:url var="deleteLink" value="/china/delete">
				<c:param name="id" value="${entry.id}"></c:param>
			</c:url>
			<tr>
				<td>${entry.id}</td>
				<td>${entry.title}</td>
				<td>${entry.given_name}</td>
				<td>${entry.surname}</td>
				<td>${entry.department}</td>
				<td>${entry.street}</td>
				<td>${entry.street_number}</td>
				<td>${entry.area}</td>
				<td>${entry.city}</td>
				<td>${entry.tk}</td>
				<td>${entry.start_date}</td>
				<td>${entry.end_date}</td>
				<td>${entry.copies}</td>
				<td>${entry.comment}</td>
				<td><a href="${updateLink}">Edit</a> | <a href="${deleteLink}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>