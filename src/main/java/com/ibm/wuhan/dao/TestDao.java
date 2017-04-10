package com.ibm.wuhan.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDao {

	private static Properties dbconfig = new Properties();
	
	static {
		try {
			
			//通过类装载方式得到文件位置 再通过传统方式读取文件内容
			String path = TestDao.class.getClassLoader().getResource("db.properties").getPath();
			path = path.replace("%20", " ");
			FileInputStream in = new FileInputStream(path);
			
		
			
			//InputStream in = TestDao.class.getClassLoader().getResourceAsStream("db.properties");
			//Properties dbconfig = new Properties();

			dbconfig.load(in);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);

		}

	}

	public void update() throws IOException {
		// 不是servlet 只能通过类装载器来读取
//		InputStream in = TestDao.class.getClassLoader().getResourceAsStream("db.properties");
//		Properties prop = new Properties();
//		prop.load(in);
//		System.out.println(prop.getProperty("url"));

		System.out.println(dbconfig.getProperty("url"));

	}

}
