<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理bean</title>
</head>
<body>
<br/>jsp:userbean 标签<br/>

	<jsp:useBean id="person" class="com.ibm.wuhan.bean.Person" scope="page"></jsp:useBean>

<br/>jsp:setProperty 标签 手动赋值<br/>
<jsp:setProperty  property="name" name="person" value="this is name"/>

<%=person.getName() %><br/>


<br/>用请求参数给bean属性赋值<br/>
<jsp:setProperty property="name" name="person" param="name" />
<jsp:setProperty property="age" name="person" param="age" /> <!-- 把客户机提交的字符串 转成8种基本类型 支持8种基本数据类型 -->


<%=person.getName() %><br/>
<%=person.getAge() %><br/>


<br/>用所有请求参数给bean赋值<br/>
<jsp:setProperty property="*" name="person"/>
<%=person.getName() %><br/>
<%=person.getAge() %><br/>

<jsp:getProperty property="name" name="person"/>




</body>
</html>