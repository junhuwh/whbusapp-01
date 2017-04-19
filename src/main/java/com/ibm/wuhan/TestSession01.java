package com.ibm.wuhan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestSession01
 */

//购买
@WebServlet("/TestSession01")
public class TestSession01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSession01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		
		//查看购物车的时候 可以只取session 不创建
		//request.getSession(false);
		
		String sessionid = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", sessionid);
		cookie.setPath("/WHBusApp-01");
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
		
		session.setAttribute("name", "洗衣机");
		
		
		
		//session.invalidate(); //删除session

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
