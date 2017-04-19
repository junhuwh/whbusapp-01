package com.ibm.wuhan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestRequest10
 */
@WebServlet("/TestRequest10")
public class TestRequest10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRequest10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//http://localhost:8080/WHBusApp-01/TestRequest08
		String referer = request.getHeader("Referer");
		System.out.println(referer);
		if(referer==null || !referer.startsWith("http://localhost")){
			//重定向到首页
			response.sendRedirect("index.html");
			return;
		}
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
			String data="防盗链专用";
		response.getWriter().write(data);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
