package com.yc.sy.entity;

public class Employ {
	private Integer eid;
	private String ename;
	private String ecount;
	private String eaddress;
	private String etime;
	private String edescription;
	
	public Employ() {
		
	}

	public Employ(Integer eid, String ename, String ecount, String eaddress, String etime, String edescription) {
		this.eid = eid;
		this.ename = ename;
		this.ecount = ecount;
		this.eaddress = eaddress;
		this.etime = etime;
		this.edescription = edescription;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEcount() {
		return ecount;
	}

	public void setEcount(String ecount) {
		this.ecount = ecount;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getEdescription() {
		return edescription;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}

	@Override
	public String toString() {
		return "Employ [eid=" + eid + ", ename=" + ename + ", ecount=" + ecount + ", eaddress=" + eaddress + ", etime="
				+ etime + ", edescription=" + edescription + "]";
	}
	
	
}
