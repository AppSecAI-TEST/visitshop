package com.bdqn.shopvisit.resultbean;

import java.util.List;


public class HistoryTrainResult {

	/**
	 * code : 0 msg : 培训列表获取成功 body :
	 * [{"id":1024,"title":"常规销售技巧培训","trainid":"20160601"
	 * ,"date":"2016-09-09","location"
	 * :"北京市北京大学","trainer":"李大大老师","state":0},{"id"
	 * :1024,"title":"常规销售技巧培训","trainid"
	 * :"20160601","date":"2016-09-09","location"
	 * :"北京市北京大学","trainer":"李大大老师","state"
	 * :0},{"id":1024,"title":"常规销售技巧培训","trainid"
	 * :"20160601","date":"2016-09-09"
	 * ,"location":"北京市北京大学","trainer":"李大大老师","state":0}]
	 */

	private int code;
	private String msg;
	/**
	 * id : 1024 title : 常规销售技巧培训 trainid : 20160601 date : 2016-09-09 location
	 * : 北京市北京大学 trainer : 李大大老师 state : 0
	 */

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
		private String title;
		private String trainid;
		private String date;
		private String location;
		private String trainer;
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

		public String getTrainid() {
			return trainid;
		}

		public void setTrainid(String trainid) {
			this.trainid = trainid;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getTrainer() {
			return trainer;
		}

		public void setTrainer(String trainer) {
			this.trainer = trainer;
		}

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}
	}
}
