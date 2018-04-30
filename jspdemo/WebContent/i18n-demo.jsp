<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="theLocale" 
value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale }" 
scope="session">
</c:set>

<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="com.bashfan.resources.mylabel"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>i18n</title>
</head>
<body>

<a href="i18n-demo.jsp?theLocale=en_US">US</a> |
<a href="i18n-demo.jsp?theLocale=es_ES">ES</a> |
<a href="i18n-demo.jsp?theLocale=de_DE">DE</a>
<hr>
 <fmt:message key="label.greeting"></fmt:message><br>
 <fmt:message key="label.firstname"></fmt:message><br>
 <fmt:message key="label.lastname"></fmt:message><br>
 <fmt:message key="label.welcome"></fmt:message><br> 
</body>
</html>