package com.ibm.wuhan.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BusLineBean implements Serializable {

	private String linenumber;
	private String busnumber;
	private String drivername;
	private String driverphonenumber;
	private String captainname;
	private String captainemail;
	private String captainphone;
	private Set<StopInfo> stopinfo = new HashSet<StopInfo>();

	public String getLinenumber() {
		return linenumber;
	}

	public void setLinenumber(String linenumber) {
		this.linenumber = linenumber;
	}

	public String getBusnumber() {
		return busnumber;
	}

	public void setBusnumber(String busnumber) {
		this.busnumber = busnumber;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getDriverphonenumber() {
		return driverphonenumber;
	}

	public void setDriverphonenumber(String driverphonenumber) {
		this.driverphonenumber = driverphonenumber;
	}

	public String getCaptainname() {
		return captainname;
	}

	public void setCaptainname(String captainname) {
		this.captainname = captainname;
	}

	public String getCaptainemail() {
		return captainemail;
	}

	public void setCaptainemail(String captainemail) {
		this.captainemail = captainemail;
	}

	public String getCaptainphone() {
		return captainphone;
	}

	public void setCaptainphone(String captainphone) {
		this.captainphone = captainphone;
	}

	public Set<StopInfo> getStopinfo() {
		return stopinfo;
	}

	public void setStopinfo(Set<StopInfo> stopinfo) {
		this.stopinfo = stopinfo;
	}

	public BusLineBean() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public BusLineBean(String linenumber, String busnumber, String drivername, String driverphonenumber,
			String captainname, String captainemail, String captainphone, Set<StopInfo> stopinfo) {
		// super();
		this.linenumber = linenumber;
		this.busnumber = busnumber;
		this.drivername = drivername;
		this.driverphonenumber = driverphonenumber;
		this.captainname = captainname;
		this.captainemail = captainemail;
		this.captainphone = captainphone;
		this.stopinfo = stopinfo;
	}

}
