package com.bdqn.shopvisit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.User;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.SubmitResult;
import com.bdqn.shopvisit.util.CommonUtil;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: RegistServlet
 * 
 * @Description: 用户注册
 * @author Leon
 */
public class RegistServlet extends HttpServlet {

	public RegistServlet() {
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
		SubmitResult sr = new SubmitResult();
		try {
			String userId = request.getParameter("userid");
			String passWord = request.getParameter("password");
			String nickName = request.getParameter("nickname");
			String phoneNum = request.getParameter("phone");
			int sex = Integer.parseInt(request.getParameter("sex"));
			String job = request.getParameter("job");
			String area = request.getParameter("area");

			User user = new User();
			user.setArea(area);
			user.setJob(job);
			user.setNickName(nickName);
			// 密码MD5加密
			user.setPassWord(CommonUtil.stringToMD5(passWord));
			user.setPhoneNum(phoneNum);
			user.setRegistDate(CommonUtil.getTodayDate());
			user.setSex(sex);
			user.setUserId(userId);
			user.setImg("visitshop/img/user/head.png");
			DaoUtil dao = new DaoUtil();

			dao.save(user);
			sr.setCode(Constant.CODESUCCESS);
			sr.setMsg("提交成功");
		} catch (Exception e) {
			e.printStackTrace();
			sr.setCode(Constant.CODEFAIL);
			sr.setMsg("提交失败." + e.getMessage());
		} finally {
			PrintUtil.print(new Gson().toJson(sr), response);
		}

	}
}
