package com.yc.sy.entity;

public class Company {
	private String cbrife;
	private String cbrand;
	public String getCbrife() {
		return cbrife;
	}
	public void setCbrife(String cbrife) {
		this.cbrife = cbrife;
	}
	public String getCbrand() {
		return cbrand;
	}
	public void setCbrand(String cbrand) {
		this.cbrand = cbrand;
	}
	@Override
	public String toString() {
		return "CompanyProduce [cbrife=" + cbrife + ", cbrand=" + cbrand + "]";
	}
	
}
