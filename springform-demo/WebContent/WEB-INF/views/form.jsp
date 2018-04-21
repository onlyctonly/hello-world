<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
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
	<form:form modelAttribute="org" action="showform">
		<form:input path="name" placeholder="Enter Orgnization Name" />
		<form:select path="country">
			<form:option value="China">China</form:option>
			<form:option value="Greece">Greece</form:option>
			<form:option value="Japan">Japan</form:option>
		</form:select>
		
		<form:select  path="turnover" items="${tlist}"></form:select>
		<form:select path="field" items="${fielddata}"></form:select>
		<input type="submit" value="提交" />
	</form:form>
</body>
</html>