package com.ibm.wuhan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestSession04
 */
//列出所有商品
@WebServlet("/TestSession04")
public class TestSession04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSession04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.getSession();
		
		out.print("有如下商品:<br/>");
		Map<String, Book> map = Db.getAll();
		
		for (Map.Entry<String, Book> entry : map.entrySet()) {
			Book book = entry.getValue();
			
			String url = response.encodeURL("TestSession05?id=" + book.getId() );
			
			out.println(
					//"<a href='TestSession05?id=" + book.getId() + "' target='_blank'>" + book.getName() + "</a><br/>");
					"<a href='"+url+"' target='_blank'>" + book.getName() + "</a><br/>");

		} 
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




