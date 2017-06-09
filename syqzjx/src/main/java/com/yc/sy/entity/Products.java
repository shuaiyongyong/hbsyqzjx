package com.yc.sy.entity;

public class Products {

	private Integer pid;
	private String pname;
	private String pbrife;
	private String ppic;
	private Integer ptid;
	
	public Products() {
	}

	
	public Products(String pname, String pbrife, String ppic, Integer ptid) {
		super();
		this.pname = pname;
		this.pbrife = pbrife;
		this.ppic = ppic;
		this.ptid = ptid;
	}


	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPbrife() {
		return pbrife;
	}

	public void setPbrife(String pbrife) {
		this.pbrife = pbrife;
	}

	public String getPpic() {
		return ppic;
	}

	public void setPpic(String ppic) {
		this.ppic = ppic;
	}

	public Integer getPtid() {
		return ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pbrife=" + pbrife + ", ppic=" + ppic + ", ptid=" + ptid
				+ "]";
	}
	
}
