<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.error {
		color:red;
	}
</style>
</head>
<body>
	<form:form action="processform" modelAttribute="sd">
		First name: <form:input path="Firstname"/>
		<form:errors path="firstname" cssClass="error"></form:errors><br/>
		Last name: <form:input path="Lastname" />
		<form:errors path="lastname" cssClass="error"></form:errors><br/>
		Age: <form:input path="age"/>
		<form:errors path="age" cssClass="error"></form:errors><br/>
		<form:select path="Country">
			<form:options items="${sd.countryoptions}" />
		</form:select>
		
		Java <form:radiobutton path="prefferedlanguage" value="Java"/>
		php <form:radiobutton path="prefferedlanguage" value="php"/><br>
		os: Linux <form:checkbox path="os" value="linux"/> Mac <form:checkbox path="os" value="mac"/>
		<input type="submit" />
	</form:form>
</body>
</html>