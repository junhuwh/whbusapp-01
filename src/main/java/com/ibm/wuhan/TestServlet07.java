package com.ibm.wuhan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet07")
public class TestServlet07 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet07() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		test1(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setDateHeader("expires", System.currentTimeMillis()+1000*3600*24);
	String data = "this is a msg from 七";
	response.getWriter().write(data);
	
	}

}
