package com.ibm.wuhan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestSessionTokenForm
 */
@WebServlet("/TestSessionTokenForm")
public class TestSessionTokenForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestSessionTokenForm() {
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

		boolean b = isTokenValid(request);
		if (!b) {
			System.out.println("重复");
			return;
		}
		request.getSession().removeAttribute("token");
		System.out.println("注册用户1");

	}

	// 判断表单号码是否有效
	private boolean isTokenValid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String client_token = request.getParameter("token");
		if (client_token == null) {
			return false;
		}
		String server_token = (String) request.getSession().getAttribute("token");

		if (server_token == null) {
			return false;
		}

		if (!client_token.equals(server_token)) {
			return false;
		}
		return true;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
