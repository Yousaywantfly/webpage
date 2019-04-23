package com.tjrac.hyc.pojo;

import java.util.Date;

public class Save {
	
	private int id;
	private Date save_time;

	private Product pro=new Product();
	private User user=new User();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSave_time() {
		return save_time;
	}
	public void setSave_time(Date save_time) {
		this.save_time = save_time;
	}
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Save(int id, Date save_time, Product pro, User user) {
		super();
		this.id = id;
		this.save_time = save_time;
		this.pro = pro;
		this.user = user;
	}
	public Save() {
		super();
	}
	@Override
	public String toString() {
		return "Save [id=" + id + ", save_time=" + save_time + ", pro=" + pro + ", user=" + user + "]";
	}
	
	
}
