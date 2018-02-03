<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"></link>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer list</h2>
		</div>
	</div>
	
	<div id="container">
		<input type="button" value="add customer" onclick="window.location.href='showFormForAdd'; return false;" />
		<table>
			<tr>		
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempvar" items="${customers}">
			
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempvar.id}"></c:param>
				</c:url>
				
				<c:url var="deletelink" value="/customer/delete">
					<c:param name="customerId" value="${tempvar.id}"></c:param>
				</c:url>
				
				<tr>
				<td>${tempvar.firstName}</td>
				<td>${tempvar.lastName}</td>
				<td>${tempvar.email}</td>
				<td>
				<a href="${updateLink}">update</a> | <a href="${deletelink}" onclick="if(!(confirm('delete?'))) return false;">Delete</a>
				</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>