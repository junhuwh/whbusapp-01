<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算器</title>
</head>
<body >
<div style="text-align: center;">
	<jsp:useBean id="calculatorBean"
		class="com.ibm.wuhan.model1.CalculatorBean"></jsp:useBean>
	<jsp:setProperty property="*" name="calculatorBean" />

	<%
		try {
			calculatorBean.calculate();
		} catch (Exception e) {
			out.write(e.getMessage());
		}
	%>
	<br />=====================================
	<br /> 计算结果是：
	<jsp:getProperty property="firstNum" name="calculatorBean" />
	<jsp:getProperty property="operator" name="calculatorBean" />
	<jsp:getProperty property="secondNum" name="calculatorBean" />
	=
	<jsp:getProperty property="result" name="calculatorBean" />
	<br />=====================================
	<br />
	<br />
	<br />

		<form action="calculator.jsp" method="post">
			<table width="40%" border="1" align="center">
				<tr>
					<td colspan="2">四则运算计算器</td>
				</tr>
				<tr>
					<td>参数1</td>
					<td><input type="text" name="firstNum"></td>
				</tr>
				<tr>
					<td>操作符</td>
					<td align="left"><select name="operator" >
							<option value="+">+</option>
							<option value="-">-</option>
							<option value="*">*</option>
							<option value="/">/</option>
					</select></td>
				</tr>
				<tr>
					<td>第二个参数</td>
					<td><input type="text" name="secondNum"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="计算"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>