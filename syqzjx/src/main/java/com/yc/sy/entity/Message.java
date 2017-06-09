package com.yc.sy.entity;

public class Message {
	private Integer mid;
	private String mappkey;
	private String msecret;
	private String mtel;
	private String msignname;
	private String mtemplateCode;
	private Integer mtype;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
	
	public String getMsecret() {
		return msecret;
	}
	public void setMsecret(String msecret) {
		this.msecret = msecret;
	}
	public String getMappkey() {
		return mappkey;
	}
	public void setMappkey(String mappkey) {
		this.mappkey = mappkey;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	
	public String getMsignname() {
		return msignname;
	}
	public void setMsignname(String msignname) {
		this.msignname = msignname;
	}
	public String getMtemplateCode() {
		return mtemplateCode;
	}
	public void setMtemplateCode(String mtemplateCode) {
		this.mtemplateCode = mtemplateCode;
	}
	public Integer getMtype() {
		return mtype;
	}
	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", mappkey=" + mappkey + ", msecret=" + msecret + ", mtel=" + mtel
				+ ", msignname=" + msignname + ", mtemplateCode=" + mtemplateCode + ", mtype=" + mtype + "]";
	}
	
	
	
}
