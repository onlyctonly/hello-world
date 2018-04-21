<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/test.css" var="testCss"></spring:url>
<link href="${testCss}" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form Page</title>
</head>
<body>
	<p>${org.name}</p>
	<p>${org.country}</p>
	<c:forEach var="t" items="${tlist}">
		<c:if test="${org.turnover eq t.key}">
			<p>${t.value}</p>
		</c:if>
	</c:forEach>
	<c:forEach var="t" items="${fielddata}">
		<c:if test="${org.field eq t.key}">
			<p>${t.value}</p>
		</c:if>
	</c:forEach>
</body>
</html>