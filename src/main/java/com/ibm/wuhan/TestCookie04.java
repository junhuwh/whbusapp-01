package com.ibm.wuhan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestCookie04
 */
// 显示商品详细信息
@WebServlet("/TestCookie04")
public class TestCookie04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestCookie04() {
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

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 1 根据用户带来的id号 显示商品详细信息
		String id = request.getParameter("id");
		Book book = (Book) Db.getAll().get(id);
		out.write(book.getId() + "<br/>");
		out.write(book.getAuthor() + "<br/>");
		out.write(book.getName() + "<br/>");
		out.write(book.getDescription() + "<br/>");

		// 2 构建cookie回写给浏览器

		String cookieValue = buildCookies(id, request);
		Cookie cookie = new Cookie("bookHistory", cookieValue);
		cookie.setMaxAge(1 * 30 * 24 * 60 * 60);
		cookie.setPath("/WHBusApp-01");
		response.addCookie(cookie);

	}

	private String buildCookies(String id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		// bookHistory = null 1 ->1
		// bookHistory = 2,5,1 1 ->1,2,5
		// bookHistory = 2,5,4 1 ->1,2,5
		// bookHistory = 2,5 1 ->1,2,5

		String bookHistory = null;
		Cookie cookies[] = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("bookHistory")) {

				bookHistory = cookies[i].getValue();

			}
		}

		if (bookHistory == null) {
			return id;
		}

		LinkedList<String> list = new LinkedList(Arrays.asList(bookHistory.split("\\,")));

		if (list.contains(id)) {
			list.remove(id);
		} else {
			if (list.size() >= 3) {
				list.removeLast();
			}
		}
		list.addFirst(id);

		StringBuffer sb = new StringBuffer();
		for (String bid : list) {
			sb.append(bid + ",");
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
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
