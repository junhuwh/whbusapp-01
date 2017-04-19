package com.ibm.wuhan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestRequest07
 */
@WebServlet("/TestRequest07")
public class TestRequest07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  //forward的细节     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRequest07() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//没写向客户端的时候 流就还没关 fw就不会抛出异常
//请求转发特点
//1 客户端只发一次请求 而服务器端有多个资源调用
//2 客户端浏览器地址栏没有变化
//		
		String data = "aaafw";
		response.getWriter().write(data);
		
		//forward跳转之前 会清空response里面的数据
		request.getRequestDispatcher("TestRequest07.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
