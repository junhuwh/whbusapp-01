<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h>this is test1.jsp</h>
		<br/>
	
	<font color="blue">
	<%
		String data = (String) application.getAttribute("data");
		out.println(data);
	%>
	<!-- response 数据 -->
		<br/>
	
	${data}
	<br/>
	<% 
		String data1 = (String) request.getAttribute("data");
		out.write(data1);
	%>
	<br/>
	
	
	</font>
</body>
</html>