package com.ibm.wuhan.bean;

import java.io.Serializable;

public class StopInfo implements Serializable{

	private String stoptime;
	private String stopnumber;
	private String stopname;
	private String stoplocation;

	public StopInfo() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public StopInfo(String stoptime, String stopnumber, String stopname, String stoplocation) {
		// super();
		this.stoptime = stoptime;
		this.stopnumber = stopnumber;
		this.stopname = stopname;
		this.stoplocation = stoplocation;
	}

	public String getStoptime() {
		return stoptime;
	}

	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

	public String getStopnumber() {
		return stopnumber;
	}

	public void setStopnumber(String stopnumber) {
		this.stopnumber = stopnumber;
	}

	public String getStopname() {
		return stopname;
	}

	public void setStopname(String stopname) {
		this.stopname = stopname;
	}

	public String getStoplocation() {
		return stoplocation;
	}

	public void setStoplocation(String stoplocation) {
		this.stoplocation = stoplocation;
	}

	@Override
	public String toString() {
		return "StopInfo [stoptime=" + stoptime + ", stopnumber=" + stopnumber + ", stopname=" + stopname
				+ ", stoplocation=" + stoplocation + "]";
	}

}
