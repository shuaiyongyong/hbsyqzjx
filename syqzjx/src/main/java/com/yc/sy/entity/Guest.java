package com.yc.sy.entity;

import java.util.Date;

public class Guest {
	private int gid;
	private String gname;
	private String gtel;
	private String gemail;
	private String gcontent;
	private Date gtime;
	
	public Guest() {
		// TODO Auto-generated constructor stub
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGtel() {
		return gtel;
	}

	public void setGtel(String gtel) {
		this.gtel = gtel;
	}

	public String getGemail() {
		return gemail;
	}

	public void setGemail(String gemail) {
		this.gemail = gemail;
	}

	public String getGcontent() {
		return gcontent;
	}

	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}

	public Date getGtime() {
		return gtime;
	}

	public void setGtime(Date gtime) {
		
		this.gtime = gtime;
	}

	@Override
	public String toString() {
		return "Guest [gid=" + gid + ", gname=" + gname + ", gtel=" + gtel + ", gemail=" + gemail + ", gcontent="
				+ gcontent + ", gtime=" + gtime + "]";
	}
	
	
}
