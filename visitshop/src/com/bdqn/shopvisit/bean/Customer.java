package com.bdqn.shopvisit.bean;

/**
 * 拜访客户表 ClassName: Customer
 * 
 * @Description: 拜访客户实体类
 * @author Leon
 */
public class Customer {

	private int id;
	private String name;
	private String phone;
	private String company;
	private String job;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
