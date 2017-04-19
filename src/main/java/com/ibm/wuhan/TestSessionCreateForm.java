package com.ibm.wuhan;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestSessionCreateForm
 */
@WebServlet("/TestSessionCreateForm")
public class TestSessionCreateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestSessionCreateForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//产生表单
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 产生随机数（表单号）

		TokenProcessor tp = TokenProcessor.getInstance();
		String token = tp.generateToken();
	//	System.out.println(token+"********");
		request.getSession().setAttribute("token", token);
//		System.out.println(request.getSession().getAttribute("token"));
		request.getRequestDispatcher("TestSessionCreateForm.jsp").forward(request, response);
		
		
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

// 令牌发生器 单例
class TokenProcessor {

	// 1. 把构造方法私有
	// 2. 自己创建一个对象
	// 3. 对外暴露一个方法 允许获取上面创建的对象

	private TokenProcessor() {
	}

	private static final TokenProcessor instance = new TokenProcessor();

	public static TokenProcessor getInstance() {
		return instance;
	}

	public String generateToken() {
		String token = System.currentTimeMillis() + new Random().nextInt() + "";

		try {
			MessageDigest md  = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(token.getBytes());
			
			//base64编码
//			BASE64Encoder encoder = new BASE64Encoder();
			String asB64 = Base64.getEncoder().encodeToString(md5);
			
			return asB64;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}