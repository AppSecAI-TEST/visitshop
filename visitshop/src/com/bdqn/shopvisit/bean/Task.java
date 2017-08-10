package com.bdqn.shopvisit.bean;

/**
 * 
 * ClassName: Task
 * 
 * @Description: 任务信息实体类
 * @author Leon
 */
public class Task {

	private int id;
	private String title;
	private String detail;
	private String publishDate;
	private String executeDate;
	private int state;

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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getExecuteDate() {
		return executeDate;
	}

	public void setExecuteDate(String executeDate) {
		this.executeDate = executeDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
