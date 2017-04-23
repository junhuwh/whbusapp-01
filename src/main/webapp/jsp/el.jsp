<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ibm.wuhan.bean.Person"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el表达式</title>
</head>
<body>

	<%
		String data = "abdcd";
		request.setAttribute("data", data);
	%>

	${data}
	<%-- pageContext.findAttribute("data") page request session application "" --%>
	<br />

	<%
		Person p = new Person();
		p.setName("myname");
		request.setAttribute("person", p);
	%>
	${person.name }

	<%-- person.address.city --%>

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

	${list[3].name }

	<br />

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

	<br />${map.cc.name}<br />
	<br />${map['11'].name}<br />
	<%-- el表达式 通常用.号 当.号取不出来时候 用 []号 --%>
	<br />${map }<br />

<!-- 获取当前目录名称 -->
	<br />${pageContext.request.contextPath }<br /> 


</body>
</html>