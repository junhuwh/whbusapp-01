package com.ibm.wuhan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet05
 */
@WebServlet("/TestServlet05")
public class TestServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet05() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		test6(request, response);
		// System.out.println(request.getContextPath());
		// System.out.println(request.getSession().getAttribute("piccode"));
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

	public static final int WIDTH = 70;
	public static final int HEIGHT = 25;

	private void test5(HttpServletRequest request, HttpServletResponse response)
			throws IOException, UnsupportedEncodingException {
		// 输出随机图片

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();

		// 1.设置背景色
		Color c = new Color(200, 150, 255);
		g.setColor(c);

		// setBackGround(g);
		// 2. 设置边框
		g.fillRect(0, 0, WIDTH, HEIGHT);

		// setBorder(g);
		// 3. 画干扰线
		// drawRandomLine(g);
		// 4. 写随机数
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r = new Random();
		int len = ch.length, index;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			g.drawString(ch[index] + "", (i * 15) + 3, 18);
			sb.append(ch[index]);
		}

		request.getSession().setAttribute("piccode", sb.toString());

		ImageIO.write(image, "JPG", response.getOutputStream());
		// drawRandomNum(g);
		// 5. 图形写给浏览器
		// response.setContentType("image/jpeg");
		// ImageIO.write(image, "jpg", response.getOutputStream());

	}

	int width = 120;
	int height = 35;

	private void test6(HttpServletRequest request, HttpServletResponse response)
			throws IOException, UnsupportedEncodingException {

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		// 1.设置背景色
		setBackGround(g);

		// 2. 设置边框
		setBorder(g);

		// 3. 画干扰线
		drawRandomLine(g);

		// 4. 写随机数
		drawRandomNum((Graphics2D) g);

		// 5. 图形写给浏览器

		response.setContentType("image/jpeg");
		
		//发头控制浏览器不缓存
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		
		ImageIO.write(image, "jpg", response.getOutputStream());

	}

	private void drawRandomNum(Graphics2D g) {

		g.setColor(Color.RED);
		g.setFont(new Font("宋体", Font.BOLD, 20));

		String base = "甲乙丙丁子丑寅卯";
		// [\u4e00-\u9fa5]中文区间
		int x = 10;
		for (int i = 0; i < 4; i++) {

			int degree = new Random().nextInt()%30; //-30~30

			String ch = base.charAt(new Random().nextInt(base.length())) + " ";
			g.rotate(degree * Math.PI / 180, x, 20);// 旋转角度
			g.drawString(ch, x, 20);
			g.rotate(-degree * Math.PI / 180, x, 20);
			x += 30;
		}
	}

	private void drawRandomLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		for (int i = 0; i < 4; i++) {
			int x1 = new Random().nextInt(width - 2);
			int y1 = new Random().nextInt(height - 2);

			int x2 = new Random().nextInt(width - 2);
			int y2 = new Random().nextInt(height - 2);

			g.drawLine(x1, y1, x2, y2);
		}
	}

	private void setBackGround(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, width, height);

	}

	private void setBorder(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, width - 2, height - 2);
	}
}
