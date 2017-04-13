package com.ibm.wuhan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet08
 */
@WebServlet("/TestServlet08")
public class TestServlet08 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet08() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 请求重定向
	// *
	// * 1 浏览器会向服务器发送两次请求 有两个 request response
	// 2 重定向 地址栏会发生变化
	// *
	// * 用户登录 和 显示购物车时 常用重定向技术
	// *
	// *不能同时调用 getOutputStream 和 getWriter方法 会报异常
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.setStatus(302);
		// response.setHeader("location", "index.html");

		response.sendRedirect("index.html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
