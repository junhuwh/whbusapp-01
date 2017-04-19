<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testjsp01</title>
</head>
<body>

<!-- jsp声明  可以在里面声明一个方法-->
<%!  %>

<!-- 脚本片段 其中只能出现java代码 -->
<%
	Date date = new Date();
	String time = date.toLocaleString();
	out.write(time);

%>
<br/>
<%=time %> <!--脚本表达式 输出数据  -->

<%-- jsp注释  不会发给浏览器--%>
<!-- html注释 发给浏览器 但是不显示 -->
</body>
</html>