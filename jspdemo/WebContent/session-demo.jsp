<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input type="text" name="todo"><br>
		<input type="submit">
	</form>
	
	<hr>
<%
List<String> items = (List<String>)session.getAttribute("items");
if(items == null){
	items=new ArrayList<String>();
	session.setAttribute("items", items);
}

String todo = request.getParameter("todo");
if(todo!=null){
	items.add(todo);
}


if(items!=null && items.size()>0){
	for(String entry:items){
		out.println(entry);
	}
}
%>

</body>
</html>