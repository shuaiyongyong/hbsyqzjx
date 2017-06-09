package com.yc.sy.entity;

public class Context {
	
	private Integer cid ;
	private String cconcrete ;
	private Integer ctype ;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCconcrete() {
		return cconcrete;
	}
	public void setCconcrete(String cconcrete) {
		this.cconcrete = cconcrete;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	@Override
	public String toString() {
		return "Context [cid=" + cid + ", cconcrete=" + cconcrete + ", ctype=" + ctype + "]";
	} 
	
	
}
