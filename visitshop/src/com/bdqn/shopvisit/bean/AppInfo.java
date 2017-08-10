package com.bdqn.shopvisit.bean;

/**
 * 
 * ClassName: AppInfo
 * 
 * @Description: APP版本信息实体类
 * @author Leon
 */
public class AppInfo {

	private int id;
	private String version;
	private String publishDate;
	private String updateInfo;
	private String downloadUrl;

	public AppInfo() {
		// TODO Auto-generated constructor stub
	}

	public AppInfo(String version, String publishDate, String updateInfo,
			String downloadUrl) {
		super();
		this.version = version;
		this.publishDate = publishDate;
		this.updateInfo = updateInfo;
		this.downloadUrl = downloadUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getUpdateInfo() {
		return updateInfo;
	}

	public void setUpdateInfo(String updateInfo) {
		this.updateInfo = updateInfo;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

}
