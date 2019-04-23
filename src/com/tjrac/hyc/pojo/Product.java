package com.tjrac.hyc.pojo;

public class Product {

	
	private int pid;
	private String pname;
	private String pinfor;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPinfor() {
		return pinfor;
	}
	public void setPinfor(String pinfor) {
		this.pinfor = pinfor;
	}
	public Product(int pid, String pname, String pinfor) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pinfor = pinfor;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pinfor=" + pinfor + "]";
	}
	
	
	
}
