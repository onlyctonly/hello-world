<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Customer Form</h2>
	<form:form action="saveCustomer" method= "POST" modelAttribute="customer">
		<form:hidden path="id" />
		<form:input path="firstName" placeholder="firstname"  />
		<form:input path="lastName" placeholder="lastname"/>
		<form:input path="email" placeholder="email"/>
		<input type="submit" value="保存">
	</form:form>
</body>
</html>