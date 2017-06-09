package com.yc.sy.entity;

public class User {
	private Integer usid;
	private String uname;
	private String upwd;
	private String utel;

	public User() {
	}

	public User(Integer usid, String uname, String upwd, String utel) {
		super();
		this.usid = usid;
		this.uname = uname;
		this.upwd = upwd;
		this.utel = utel;
	}

	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	@Override
	public String toString() {
		return "User [usid=" + usid + ", uname=" + uname + ", upwd=" + upwd + ", utel=" + utel + "]";
	}

	
}
