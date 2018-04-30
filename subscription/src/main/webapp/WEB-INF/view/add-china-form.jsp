<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Greek Subscriber</title>
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
	<h2>Customer Form</h2>
	
	<form:form method="POST" modelAttribute="chinaSubscriber" action="save">
		<form:hidden path="id" />
		<form:input path="title" placeholder="title"  />
		<form:input path="given_name" placeholder="given name"/>
		<form:input path="surname" placeholder="surname"/>
		<form:input path="department" placeholder="department"/>
		<form:input path="street" placeholder="street"/>
		<form:input path="street_number" placeholder="street_number"/>
		<form:input path="area" placeholder="area"/>
		<form:input path="tk" placeholder="tk"/>
		<form:input path="copies" placeholder="copies"/>
		<form:input path="start_date" placeholder="start_date"/>
		<form:input path="end_date" placeholder="end_date"/>
		<form:input path="comment" placeholder="comment"/>
		<input type="submit" value="保存">
	</form:form>
</body>
</html>