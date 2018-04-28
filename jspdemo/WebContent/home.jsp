<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bashfan.utils.*, java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp demo</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
date is <%= new java.util.Date() %><br/>
2nd date is <%= new Date() %><br/>
25*4 <%= 25*4 %><br/>
25<4 <%= 25<4 %><br/>
<%= new String("lowercase").toUpperCase() %><br/>
<br/>

Scriptlet:

<%
for(int i=1;i<11;i++){
	out.println(i+"<br/>");
}
%>
<br/>
Declaration:
<%= tolower("UPPER") %>

<%!
String tolower(String s){
	return s.toLowerCase();
}
%>

<p>Calling class:</p>

<%= MyUtils.tolower("TNT") %> <br/>

<p>built-in object:</p>

<%= request.getHeader("User-agent") %><br/>
<%= request.getLocale() %><br/>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>