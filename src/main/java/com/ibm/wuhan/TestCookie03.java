package com.ibm.wuhan;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestCookie03
 */
// 代表首页servlet
@WebServlet("/TestCookie03")
public class TestCookie03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestCookie03() {
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

		// 1 输出首页商品
		out.write("本站有如下商品：<br/>");
		Map<String, Book> map = Db.getAll();
		for (Map.Entry<String, Book> entry : map.entrySet()) {
			Book book = entry.getValue();
			out.println(
					"<a href='TestCookie04?id=" + book.getId() + "' target='_blank'>" + book.getName() + "</a><br/>");

		}

		// 2 显示曾经看过的商品
		out.print("<br/>曾经看过如下：<br/>");
		Cookie cookies[] = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {

			if (cookies[i].getName().equals("bookHistory")) {
				String ids[] = cookies[i].getValue().split("\\,"); //
				for (String id : ids) {
					Book book = (Book) Db.getAll().get(id);
					out.println(book.getName() + "<br/>");
				}
			}
		}
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

class Db implements Serializable{
	private static Map<String, Book> map = new LinkedHashMap();

	static {
		map.put("1", new Book("1", "javaweb", "老张", "好书！"));
		map.put("2", new Book("2", "jdbc", "老赵", "好书！"));
		map.put("3", new Book("3", "spring", "老王", "好书！"));
		map.put("4", new Book("4", "struts", "老李", "好书！"));
		map.put("5", new Book("5", "android", "老周", "好书！"));
	}

	public static Map getAll() {
		return map;
	}
}

class Book implements Serializable{
	private String id;
	private String name;
	private String author;
	private String description;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String id, String name, String author, String description) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
