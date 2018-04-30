<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
	<head>
		<title>Subscription Management</title>
	</head>
	
	<hr>
	User: <security:authentication property="principal.username"/>
	<hr>
	Role: <security:authentication property="principal.authorities"/>
	
	<body>
		<h1>Subscriptions</h1>
		
		<a href="greek/list">Greek List</a>
		<a href="china/list">China List</a>
		
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="logout" />
		</form:form>
	</body>
</html>