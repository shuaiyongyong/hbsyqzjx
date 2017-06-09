package com.yc.sy.entity;

import java.util.Date;

public class Knows {
	private Integer kid;
	private String ktag;
	private String kcontent;
	private Date kdate;
	
	public Knows() {
	}

	public Knows(String ktag, String kcontent, Date kdate) {
		super();
		this.ktag = ktag;
		this.kcontent = kcontent;
		this.kdate = kdate;
	}

	public Integer getKid() {
		return kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public String getKtag() {
		return ktag;
	}

	public void setKtag(String ktag) {
		this.ktag = ktag;
	}

	public String getKcontent() {
		return kcontent;
	}

	public void setKcontent(String kcontent) {
		this.kcontent = kcontent;
	}

	public Date getKdate() {
		return kdate;
	}

	public void setKdate(Date kdate) {
		this.kdate = kdate;
	}

	@Override
	public String toString() {
		return "Knows [kid=" + kid + ", ktag=" + ktag + ", kcontent=" + kcontent + ", kdate=" + kdate + "]";
	}
	
	
}
