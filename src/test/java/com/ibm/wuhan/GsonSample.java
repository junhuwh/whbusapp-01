package com.ibm.wuhan;

import org.json.JSONObject;
import org.junit.Test;

import com.google.gson.Gson;
import com.ibm.wuhan.bean.TestJsonBean;

public class GsonSample {

	
	@Test
	public void createJsonByBean(){
		TestJsonBean wangxiaoer = new TestJsonBean();
		wangxiaoer.setName("wangxiaoer");
		wangxiaoer.setAge(25.2);
		
	
		Gson gson = new Gson();
				System.out.println(gson.toJson(wangxiaoer));

	}
}
