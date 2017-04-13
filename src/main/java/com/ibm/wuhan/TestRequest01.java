package com.ibm.wuhan;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestRequest01
 */
@WebServlet("/TestRequest01")
public class TestRequest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRequest01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		response.getWriter().write(request.getRequestURI());
//		System.out.println(request.getRequestURL());
//		System.out.println(request.getQueryString());
//		System.out.println(request.getRemoteAddr()+":"+request.getRemotePort());
//	
		String value = request.getParameter("username");
		System.out.println(value);
	System.out.println("*********************");
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()){
			String name= (String) e.nextElement();
			value = request.getParameter(name);
			System.out.println(name + "=" + value);
			System.out.println("*********************");

			
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
