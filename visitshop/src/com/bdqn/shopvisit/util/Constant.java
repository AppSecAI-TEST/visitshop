package com.bdqn.shopvisit.util;

/**
 * 
 * ClassName: Constant
 * 
 * @Description: 全局参数常量定义类
 * @author Leon
 */
public class Constant {

	// 服务器地址
	public static final String SERVERURL = "http://localhost:8080/zhi/";

	// 接口返回码-成功
	public static final int CODESUCCESS = 0;
	// 接口返回码-失败
	public static final int CODEFAIL = 1;

	// 注册接口地址
	public static final String URL_regist = SERVERURL + "regist";
	// 登录接口地址
	public static final String URL_LOGIN = SERVERURL + "login";
	// 巡店提交接口地址
	public static final String URL_UPLOAD = SERVERURL + "upload";
	// 历史巡店接口地址
	public static final String URL_HISTORY = SERVERURL + "history";
	// 店面查询接口地址
	public static final String URL_SHOP = SERVERURL + "shop";
	// 拜访提交接口地址
	public static final String URL_INTERVIEWSUBMIT = SERVERURL
			+ "interviewsubmit";
	// 历史拜访接口地址
	public static final String URL_HISTORYINTERVIEW = SERVERURL
			+ "historyinterview";
	// 历史培训接口地址
	public static final String URL_HISTORYTRAIN = SERVERURL + "historytrain";
	// 培训提交接口地址
	public static final String URL_TRAINUPLOAD = SERVERURL + "trainupload";
	// APP版本信息查询接口地址
	public static final String URL_APPINFO = SERVERURL + "appinfo";
	// 任务接口地址
	public static final String URL_TASK = SERVERURL + "task";
	// 资讯接口地址
	public static final String URL_ANNOUNCEMENT = SERVERURL + "announcement";

}
