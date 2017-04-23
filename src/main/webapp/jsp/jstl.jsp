<%@page import="java.util.*"%>
<%@page import="com.ibm.wuhan.bean.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl标签</title>
</head>
<body>
	要导入 jstl.jar 和 standard.jar包
	<br /> 使用jstl + el 完成迭代
	<br />
	<br />

	<%
		List list = new ArrayList();
		list.add(new Person("aaa"));
		list.add(new Person("bbb"));
		list.add(new Person("ccc"));
		list.add(new Person("ddd"));
		list.add(new Person("eee"));
		list.add(new Person("fff"));

		request.setAttribute("list", list);
	%>
	<c:forEach items="${list}" var="person">
		${person.name }<br/>
	</c:forEach>
	
	<%
		Map map = new HashMap();
		map.put("aa", new Person("aaa"));
		map.put("bb", new Person("bbb"));
		map.put("cc", new Person("ccc"));
		map.put("dd", new Person("ddd"));
		map.put("ee", new Person("eee"));
		map.put("11", new Person("eee"));

		request.setAttribute("map", map);
	%>
		<c:forEach items="${map}" var="entry" > <!-- map.entrySet() Set集合进行迭代<map.entry> -->
		
		${entry.key}: ${entry.value.name}<br/>
		
	</c:forEach>
	
	<c:if test="${user!=null }"> 
	 <br/>欢迎您：${user.username }<br/>
	</c:if>
	
		<c:if test="${user==null }"> 
	 <br/>请登录 。。。<br/>
	</c:if>
	
</body>
</html>