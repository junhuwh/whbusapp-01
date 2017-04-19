package com.ibm.wuhan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestRequest03
 */
@WebServlet("/TestRequest03")
public class TestRequest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestRequest03() {
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
		response.getOutputStream().write((request.getParameter("username") + "<br/>").getBytes());
		System.out.println(request.getParameter("username"));
		response.getOutputStream().write(request.getParameter("password").getBytes());
		System.out.println(request.getParameter("password"));
		response.getOutputStream().write(request.getParameter("gender").getBytes());
		System.out.println(request.getParameter("gender"));
		response.getOutputStream().write(request.getParameter("city").getBytes());
		System.out.println(request.getParameter("city"));
		// response.getOutputStream().write(request.getParameterValues("likes").toString().getBytes());

		String likes[] = request.getParameterValues("likes");
		for (int i = 0; likes != null && i < likes.length; i++) {

			response.getOutputStream().write(likes[i].toString().getBytes());
			System.out.println(likes[i]);

		}
		response.getOutputStream().write(request.getParameter("description").getBytes());
		System.out.println(request.getParameter("description"));
		response.getOutputStream().write(request.getParameter("id").getBytes());
		System.out.println(request.getParameter("id"));
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
