package com.ibm.wuhan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestRequest09
 */
@WebServlet("/TestRequest09")
public class TestRequest09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRequest09() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//写地址的地方有
		//看地址是给服务器用 还是给客户端用
		//如果是给服务器 / 代表服务器  给浏览器用 / 代表网站
		// 1
		request.getRequestDispatcher("/").forward(request, response);
		
		// 2
		response.sendRedirect("/");
				
		// 3
		this.getServletContext().getRealPath("/");
		
		//4 
		this.getServletContext().getResourceAsStream("/");
		
		//5
		/*
		 
		 <a href="/">test</a>
		 
		 <form action="/">
		 </form>

		 */
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
