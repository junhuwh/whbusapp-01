package com.ibm.wuhan;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet04
 */
@WebServlet("/TestServlet04")
public class TestServlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet04() {
	}

	// 在servlet中用outputstream输出中文
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// html <meta>标签可以模拟http响应头
		test4(response);

	}

	private void test1(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String data = "中文";
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes("UTF-8"));
	}

	private void test2(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		// html <meta>标签可以模拟http响应头
		String data = "中文2";
		OutputStream out = response.getOutputStream();
		out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
		out.write(data.getBytes("UTF-8"));
	}

	private void test3(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		// 指定浏览器打开数据的格式 utf-8
		// response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 指定response以什么格式向浏览器写数据
		// response.setCharacterEncoding("UTF-8");

		String data = "中文";
		// OutputStream out = response.getOutputStream();
		// out.write(data.getBytes("UTF-8"));

		PrintWriter out = response.getWriter();
		out.write(data);
	}

	private void test4(HttpServletResponse response) throws IOException, UnsupportedEncodingException {

		// 文件下载 如果文件名是中文 则文件名需要url编码

		String path = this.getServletContext().getRealPath("/download/中文.gif");
		String filename = path.substring(path.lastIndexOf("\\") + 1);

		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));

		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(path);
			int len = 0;
			byte buffer[] = new byte[1024];
			out = response.getOutputStream();
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}

		} finally {
			// TODO: handle finally clause
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}

	}

	

}
