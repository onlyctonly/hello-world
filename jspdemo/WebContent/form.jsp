<html>
<head>

</head>
<body>
	<form>
		<input type="text" name="firstname" /><br /> 
		<input type="text" name="lastname" /><br /> 
		<select name="country">
			<option value="china">China</option>
			<option value="greece">Greece</option>
		</select> 
		<br/>
		<input type="radio" name="language" value="java">java<br> 
		<input type="radio" name="language" value="php"> php<br> 
		
		choose numbers you like:
		<input type="checkbox" name="numbers" value="1">1<br>
		<input type="checkbox" name="numbers" value="2">2<br>
		<input type="checkbox" name="numbers" value="3">3<br>
		<input type="checkbox" name="numbers" value="4">4<br>
		<input type="submit" />
	</form>

	<%=request.getParameter("firstname")%><br /> 
	${param.lastname}
	<br /> 
	${param.country}
	<br>
	${param.language}<br>
	
	<%
		if(request.getParameterValues("numbers") != null){
			String[] nums = request.getParameterValues("numbers");
			for (String num : nums){
				out.println(num);
			}
		}

	%>
</body>
</html>