package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.User;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.SubmitResult;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: UpdateUserServlet
 * 
 * @Description: 用户资料更新
 * @author Leon
 */
public class UpdateUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateUserServlet() {
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
		String nickName = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String userid = request.getParameter("userid");
		DaoUtil dao = new DaoUtil();
		List<Object> list = dao.queryByPage(User.class, 1, userid);

		if (null == list || list.size() < 1) {
			sr.setCode(Constant.CODEFAIL);
			sr.setMsg("更新失败，用户已不存在");
		} else {
			User user = (User) list.get(0);
			user.setNickName(nickName);
			user.setPhoneNum(phone);
			user.setSex(sex);
			dao.update(user);
			sr.setCode(Constant.CODESUCCESS);
			sr.setMsg("更新成功");
		}
		Gson gson = new Gson();
		PrintUtil.print(gson.toJson(sr), response);
	}

}
