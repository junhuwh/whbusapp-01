package com.ibm.wuhan;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestSession05
 */
@WebServlet("/TestSession05")
public class TestSession05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestSession05() {
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

		String id = request.getParameter("id");
		Book book = (Book) Db.getAll().get(id);

		HttpSession session = request.getSession(false);
		//手工以cookie形式发sessionid, 处理关闭浏览器后 清空上次买的东西
		
		
		
		// 从session中得到用户用于保存书的集合(购物车)
		ArrayList list = (ArrayList) session.getAttribute("list");

		if (list == null) {
			list = new ArrayList();
			session.setAttribute("list", list);

		}

		list.add(book);
		//转发 刷新会重复该动作
		//request.getRequestDispatcher("TestSession06").forward(request, response);

		//重定向
		String url = response.encodeRedirectURL(request.getContextPath() + "/TestSession06");
		response.sendRedirect(url);
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
