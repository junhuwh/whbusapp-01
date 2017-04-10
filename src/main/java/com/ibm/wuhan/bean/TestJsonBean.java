package com.ibm.wuhan.bean;

public class TestJsonBean {

	private String name;
	private String school;
	private boolean has_g;
	private double age;
	private Object has_c;
	private Object has_h;
	private String[] major;
	private String comment;
	private String birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public boolean isHas_g() {
		return has_g;
	}

	public void setHas_g(boolean has_g) {
		this.has_g = has_g;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public Object getHas_c() {
		return has_c;
	}

	public void setHas_c(Object has_c) {
		this.has_c = has_c;
	}

	public Object getHas_h() {
		return has_h;
	}

	public void setHas_h(Object has_h) {
		this.has_h = has_h;
	}

	public String[] getMajor() {
		return major;
	}

	public void setMajor(String[] major) {
		this.major = major;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public TestJsonBean(String name, String school, boolean has_g, double age, Object has_c, Object has_h,
			String[] major, String comment, String birthday) {
		// super();
		this.name = name;
		this.school = school;
		this.has_g = has_g;
		this.age = age;
		this.has_c = has_c;
		this.has_h = has_h;
		this.major = major;
		this.comment = comment;
		this.birthday = birthday;
	}

	public TestJsonBean() {
		// super();
		// TODO Auto-generated constructor stub
	}

}
