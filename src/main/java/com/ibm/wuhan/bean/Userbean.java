package com.ibm.wuhan.bean;

import java.util.Arrays;

public class Userbean {

	private String username[];
	private String password;

	public Userbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userbean(String[] username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String[] getUsername() {
		return username;
	}

	public void setUsername(String[] username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Userbean [username=" + Arrays.toString(username) + ", password=" + password + "]";
	}

}
