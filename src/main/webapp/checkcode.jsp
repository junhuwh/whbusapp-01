<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function reloadCode() {
		var time = new Date().getTime();
		document.getElementById("imagecode").src = "TestServlet05?d" + time
	}
	function changeImage(img) {
		img.src = img.src + "?" + new Date().getTime();
	}
</script>
</head>
<body>
	<form action="TestServlet06" method="get">
		验证码:<input type="text" name="checkcode" /> <img alt="验证码"
			id="imagecode" src="TestServlet05" onclick="changeImage(this)"
			title="换一张" alt="验证图片" style="cursor: pointer" /> <a
			href="javascript:reloadCode()">看不清楚</a> <br> <input
			type="submit" value="提交 " />
	</form>
</body>
</html>