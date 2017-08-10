package com.bdqn.shopvisit.bean;

/**
 * 
 * ClassName: Info
 * 
 * @Description: 资讯实体类
 * @author Leon
 */
public class Info {

	private int id;
	private String title;
	private String summary;
	private String imgUrl;
	private String detail;
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
