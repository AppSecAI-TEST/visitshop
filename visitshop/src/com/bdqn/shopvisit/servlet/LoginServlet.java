package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.User;
import com.bdqn.shopvisit.bean.Visit;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.LoginBean;
import com.bdqn.shopvisit.util.CommonUtil;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Body1_1Impl;

/**
 * 
 * ClassName: LoginServlet
 * 
 * @Description: 用户登录接口
 * @author Leon
 */
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		// 加密比较
		//password = CommonUtil.stringToMD5(password);
		DaoUtil dao = new DaoUtil();
		User user = dao.queryUser(userid, password);
		// 组装返回数据
		LoginBean lb = new LoginBean();
		if (user != null) {
			System.out.println("---------------用户存在且密码正确，可以登录");
			lb.setCode(Constant.CODESUCCESS);
			lb.setMsg("登录成功");
			LoginBean.BodyBean bb = new LoginBean.BodyBean();
			bb.setImg(user.getImg());
			bb.setUserid(user.getUserId());
			bb.setPhonenum(user.getPhoneNum());
			bb.setNickname(user.getNickName());
			bb.setJob(user.getJob());
			bb.setRegistdate(user.getRegistDate());
			bb.setSex(user.getSex());
			bb.setArea(user.getArea());
			bb.setImg(user.getImg());
			lb.setBody(bb);
		} else {
			System.out.println("---------------用户名或密码错误");
			lb.setCode(Constant.CODEFAIL);
			lb.setMsg("登录失败");
		}
		// 返回JSON数据
		Gson gson = new Gson();
		String json = gson.toJson(lb);
		PrintUtil.print(json, response);
	}

}
