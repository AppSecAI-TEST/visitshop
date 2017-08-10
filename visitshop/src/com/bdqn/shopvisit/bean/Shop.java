package com.bdqn.shopvisit.bean;

/**
 * 
 * ClassName: Shop
 * 
 * @Description: 店面信息实体类
 * @author Leon
 */
public class Shop {

	private int id;
	private String name;
	private String shopid;
	private String location;

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

	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
