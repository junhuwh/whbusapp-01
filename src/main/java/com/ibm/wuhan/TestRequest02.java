package com.ibm.wuhan;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ibm.wuhan.bean.Userbean;

/**
 * Servlet implementation class TestRequest02
 */
@WebServlet("/TestRequest02")
public class TestRequest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestRequest02() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 获取请求数据的时候 一般都要先检查 后使用

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// test01header(request);
		String value = request.getParameter("username");

		if (value != null && !value.trim().equals("")) {
			System.out.println(value);
		}

		System.out.println("************111***********************");
		System.out.println("");

		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			value = request.getParameter(name);
			System.out.println(name + "=" + value);
		}
		System.out.println("*************222**********************");
		System.out.println("");

		// String[] values = request.getParameterValues("username");
		// for(String v:values){
		// System.out.println(v);
		// }
		String[] values1 = request.getParameterValues("username");
		for (int i = 0; values1 != null && i < values1.length; i++) {
			System.out.println(values1[i]);
		}

		System.out.println("**************333*********************");
		System.out.println("");

		Map<String, String[]> map = request.getParameterMap();
		Userbean user = new Userbean();
		try {
			BeanUtils.populate(user, map); //username String[] //用map集合的数据填充bean
			//BeanUtils.copyProperties(user, formbean); //bean的拷贝
			
		} catch (IllegalAccessException | InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(user.toString());
		System.out.println("**************444*********************");
		System.out.println("");

		InputStream in = request.getInputStream();
		int len =0;
		byte buffer[] = new byte[1024];
		while((len=in.read(buffer))>0){
			System.out.println(new String(buffer,0,len));
		}
		System.out.println("**************555**???****************");
		System.out.println("");

	}
 
	private void test01header(HttpServletRequest request) {
		String headValue = request.getHeader("Accept-Encoding");
		System.out.println(headValue);
		System.out.println("************************");

		Enumeration em = request.getHeaders("Accept-Encoding");
		while (em.hasMoreElements()) {
			String value = (String) em.nextElement();
			System.out.println(value);
		}

		System.out.println("**************************");
		em = request.getHeaderNames();
		while (em.hasMoreElements()) {
			String name = (String) em.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + "=" + value);

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
