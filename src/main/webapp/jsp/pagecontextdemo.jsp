<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pagecontext对象访问其他域</title>
</head>
<body>

	<%
		request.setAttribute("data", "aaa");

		String data = (String) pageContext.getAttribute("data", pageContext.REQUEST_SCOPE);
		
		out.write(data);
		
		pageContext.findAttribute("data"); //page request session application  依次顺序查找
	%>

	<!-- el表达式 -->
	${data} //pageContext.findAttribute("data"); //page request session application  依次顺序查找
	


</body>
</html>