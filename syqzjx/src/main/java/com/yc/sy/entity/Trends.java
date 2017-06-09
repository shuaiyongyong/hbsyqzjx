package com.yc.sy.entity;

import java.util.Date;

public class Trends {

	private Integer tid;
	private String ttag;
	private String tcontent;
	private Date tDate;
	
	public Trends() {
	}

	
	public Trends(String ttag, String tcontent, Date tDate) {
		super();
		this.ttag = ttag;
		this.tcontent = tcontent;
		this.tDate = tDate;
	}


	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTtag() {
		return ttag;
	}

	public void setTtag(String ttag) {
		this.ttag = ttag;
	}

	public String getTcontent() {
		return tcontent;
	}

	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	@Override
	public String toString() {
		return "Trends [tid=" + tid + ", ttag=" + ttag + ", tcontent=" + tcontent + ", tDate=" + tDate + "]";
	}
	
	
}
