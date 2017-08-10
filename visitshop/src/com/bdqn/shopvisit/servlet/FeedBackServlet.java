package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.FeedBack;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.SubmitResult;
import com.bdqn.shopvisit.util.CommonUtil;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: FeedBackServlet
 * 
 * @Description: APP反馈意见提交接口
 * @author Leon
 */
public class FeedBackServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FeedBackServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String userId = request.getParameter("userid");
		String feedBack = request.getParameter("feedback");
		String date = CommonUtil.getTodayDate();
		FeedBack fb = new FeedBack();
		fb.setDate(date);
		fb.setUserId(userId);
		fb.setFeedBack(feedBack);
		DaoUtil dao = new DaoUtil();
		SubmitResult sr = new SubmitResult();
		try {
			dao.save(fb);
			sr.setCode(Constant.CODESUCCESS);
			sr.setMsg("提交成功");
		} catch (Exception e) {
			e.printStackTrace();
			sr.setCode(Constant.CODEFAIL);
			sr.setMsg("提交失败");
		} finally {
			Gson gson = new Gson();
			PrintUtil.print(gson.toJson(sr), response);
		}
	}

}
