<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:forward page="/TestJSPTag01">
			<jsp:param name="username" value="aaa"/>
		</jsp:forward>
		
<%-- 		<jsp:include page="/public/foot.jsp">动态包含</jsp:include>
 --%>		
</body>
</html>