package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.Announcement;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.AnnouncementBean;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: AnnouncementServlet
 * 
 * @Description: 首页公告
 * @author Leon
 */
public class AnnouncementServlet extends HttpServlet {

	public AnnouncementServlet() {
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
		AnnouncementBean bean = new AnnouncementBean();
		List<AnnouncementBean.BodyBean> listBodyBean = new ArrayList<AnnouncementBean.BodyBean>();
		DaoUtil dao = new DaoUtil();
		try {
			List<Object> list = dao.queryByProperty(Announcement.class,
					"state", 0);
			if (null != list && list.size() > 0) {
				for (Object object : list) {
					Announcement ann = (Announcement) object;
					AnnouncementBean.BodyBean bodyBean = new AnnouncementBean.BodyBean();
					bodyBean.setId(ann.getId());
					bodyBean.setImgUrl(ann.getImgUrl());
					listBodyBean.add(bodyBean);
				}
			}
			bean.setBody(listBodyBean);
			bean.setCode(Constant.CODESUCCESS);
			bean.setMsg("获取公告成功");
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(Constant.CODEFAIL);
			bean.setMsg("获取公告失败:" + e.getMessage());
		} finally {
			Gson gson = new Gson();
			String json = gson.toJson(bean);
			PrintUtil.print(json, response);
		}

	}

}
