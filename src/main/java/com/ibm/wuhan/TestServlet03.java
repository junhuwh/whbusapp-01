package com.ibm.wuhan;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wuhan.dao.TestDao;

@WebServlet("/TestServlet03")
public class TestServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 //servlet 调用其他程序 在其他程序中读取资源文件 通过类装载器 文件不能太大
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext context = this.getServletContext();
		TestDao dao = new TestDao();
		dao.update();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
