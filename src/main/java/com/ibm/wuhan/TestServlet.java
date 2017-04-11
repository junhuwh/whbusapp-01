package com.ibm.wuhan;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		test3(request, response);
	}

	// 浏览器定时刷新

	private void test(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setHeader("refresh", "3");

		String data = new Random().nextInt(10000) + "";
		response.getWriter().write(data);

	}

	// 浏览器自动跳转
	private void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("refresh", "3;url='index.html'");
		response.getWriter().write("没有跳转请点击 <a href='index.html'>跳转</a>");

	}

	// 实用浏览器自动跳转
	private void test3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String message ="<meta http-equiv='refresh' content='5;url=index.html'>消息 from servlet111";
		this.getServletContext().setAttribute("message1", message);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
		


	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
