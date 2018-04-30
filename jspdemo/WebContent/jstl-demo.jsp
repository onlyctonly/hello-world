<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] cities={"beijing", "athens"};
Integer[] nums={1,2,3,4,5,6,7,8,9,10};
pageContext.setAttribute("cities", cities);
pageContext.setAttribute("nums", nums);
%>

<c:set var="stuff" value="<%= new java.util.Date() %>"></c:set>
${stuff}<br>

<c:forEach var="entry" items="${cities}">
${entry}<br>
</c:forEach>

<c:forEach var="entry" items="${nums}">
	<c:if test="${entry >5 }">
		${entry}
	</c:if>
	
</c:forEach>


</body>
</html>