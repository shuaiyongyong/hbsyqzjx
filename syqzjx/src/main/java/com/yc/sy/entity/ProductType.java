package com.yc.sy.entity;

public class ProductType {

	private Integer ptid;
	private String ptname;
	
	public ProductType() {
	}
	
	
	public ProductType(String ptname) {
		super();
		this.ptname = ptname;
	}


	public Integer getPtid() {
		return ptid;
	}
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
	public String getPtname() {
		return ptname;
	}
	public void setPtname(String ptname) {
		this.ptname = ptname;
	}
	@Override
	public String toString() {
		return "ProductType [ptid=" + ptid + ", ptname=" + ptname + "]";
	}
	
	
}
