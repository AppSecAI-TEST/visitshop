package com.bdqn.shopvisit.resultbean;

import java.util.List;


public class AnnouncementBean {

	private int code;
	private String msg;

	private List<BodyBean> body;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	

	public List<BodyBean> getBody() {
		return body;
	}

	public void setBody(List<BodyBean> body) {
		this.body = body;
	}



	public static class BodyBean {
		private int id;
		private String imgUrl;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getImgUrl() {
			return imgUrl;
		}

		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}

	}
}
