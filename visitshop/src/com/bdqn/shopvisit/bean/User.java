package com.bdqn.shopvisit.bean;

/**
 * 
 * ClassName: User
 * 
 * @Description: 用户实体类
 * @author Leon
 */
public class User {

	private int id;
	private String userId;
	private String passWord;
	private String job;
	private String nickName;
	private int sex;// 性别 0:男,1:女
	private String img;
	private String phoneNum;
	private String registDate;
	private String area;

	
	public User() {
		
	}
	
	public User(String userId, String passWord, String job, String nickName,
			int sex, String img, String phoneNum, String registDate) {
		super();
		this.userId = userId;
		this.passWord = passWord;
		this.job = job;
		this.nickName = nickName;
		this.sex = sex;
		this.img = img;
		this.phoneNum = phoneNum;
		this.registDate = registDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
