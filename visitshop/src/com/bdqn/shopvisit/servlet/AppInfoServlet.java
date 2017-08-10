package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.AppInfo;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.AppInfoResult;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: appinfo
 * 
 * @Description: 获取APP版本信息接口
 * @author Leon
 */
public class AppInfoServlet extends HttpServlet {

	public AppInfoServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoUtil dao = new DaoUtil();
		AppInfoResult air = new AppInfoResult();
		try {
			List<Object> list = dao.queryAll(AppInfo.class);
			AppInfoResult.BodyBean body = new AppInfoResult.BodyBean();
			if (null != list && list.size() > 0) {
				// 取出最后一条记录
				AppInfo ai = (AppInfo) list.get(list.size() - 1);
				air.setCode(Constant.CODESUCCESS);
				air.setMsg("APP信息获取成功");
				body.setAddress(ai.getDownloadUrl());
				body.setPublishdate(ai.getPublishDate());
				body.setUpdateinfo(ai.getUpdateInfo());
				body.setVersion(ai.getVersion());
				air.setBody(body);
			} else {
				air.setCode(Constant.CODEFAIL);
				air.setMsg("APP信息获取失败,没有找到对应的记录");
			}

		} catch (Exception e) {
			e.printStackTrace();
			air.setCode(Constant.CODEFAIL);
			air.setMsg("APP信息获取失败");
		} finally {
			Gson gson = new Gson();
			String json = gson.toJson(air);
			PrintUtil.print(json, response);
		}

	}
}
