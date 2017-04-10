package com.ibm.wuhan;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.ibm.wuhan.bean.TestJsonBean;

public class JsonObjectSample {
	// {
	// "names" : "王小二",
	// "age" : 25.5,
	// "birthday" : "1990-01-02",
	// "school" : "蓝翔",
	// "major" : ["理发","挖掘机"],
	// "has_g" : false,
	// "has_c" : null,
	// "has_h" : null,
	// "comment" : "注释"
	// }
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// jSONObjectSample();
	// }

	@Test
	public void jSONObjectSample() {
		Object nullObj = null;
		JSONObject wangxiaoer = new JSONObject();
		wangxiaoer.put("name", "王小二");
		wangxiaoer.put("age", "25.5");
		wangxiaoer.put("birthday", "1990-01-02");
		wangxiaoer.put("school", "蓝翔");
		wangxiaoer.put("major", new String[] { "理发", "挖掘机" });
		wangxiaoer.put("has_g", false);
		wangxiaoer.put("has_c", nullObj);
		wangxiaoer.put("has_h", nullObj);
		wangxiaoer.put("comment", "注释");
		System.out.println(wangxiaoer.toString());
	}

	@Test
	public void createJsonByMap() {
		Map<String, Object> wangxiaoer = new HashMap<String, Object>();
		Object nullObj = null;
		wangxiaoer.put("name", "王小二");
		wangxiaoer.put("age", "25.5");
		wangxiaoer.put("birthday", "1990-01-02");
		wangxiaoer.put("school", "蓝翔");
		wangxiaoer.put("major", new String[] { "理发", "挖掘机" });
		wangxiaoer.put("has_g", false);
		wangxiaoer.put("has_c", nullObj);
		wangxiaoer.put("has_h", nullObj);
		wangxiaoer.put("comment", "注释");
		System.out.println(new JSONObject(wangxiaoer).toString());
	}
	
	@Test
	public void createJsonByBean(){
		TestJsonBean wangxiaoer = new TestJsonBean();
		wangxiaoer.setName("wangxiaoer");
		wangxiaoer.setAge(25.2);
		System.out.println(new JSONObject(wangxiaoer).toString());
		
		
	}
	
	@Test
	public void readJson() throws IOException, JSONException{
		File file = new File(JsonObjectSample.class.getResource("/test.json").getFile());
	String content = FileUtils.readFileToString(file,"utf-8");
	JSONObject jsonObject = new JSONObject(content);
	System.out.println(jsonObject.getString("names"));
	System.out.println(jsonObject.getDouble("age"));

	JSONArray majorArray = jsonObject.getJSONArray("major");
	for(int i=0;i<majorArray.length();i++){
		String m = (String) majorArray.get(i);
		System.out.println(m + (i+1));
	}
	
	for(Object m:majorArray){
		System.out.println(m);
	}
	
	}
}
