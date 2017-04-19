package com.ibm.wuhan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestRequest04
 */
@WebServlet("/TestRequest04")
public class TestRequest04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestRequest04() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// request.setCharacterEncoding("UTF-8");

		// String username = request.getParameter("username");
		// 得看服务器设置的编码格式 然后再转码
		//get 方式乱码需要手工处理
		String username = new String(request.getParameter("username").getBytes("utf-8"), "utf-8");
		System.out.println(username);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// post中文乱码解决方式
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");

		// username = new String(username.getBytes("iso8859-1"),"UTF-8");

		System.out.println(username);
	}

}
