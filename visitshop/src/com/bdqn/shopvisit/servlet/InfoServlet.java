package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.Info;
import com.bdqn.shopvisit.bean.Task;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.InfoResult;
import com.bdqn.shopvisit.resultbean.TaskResult;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: InfoServlet
 * 
 * @Description: 资讯信息获取接口
 * @author Leon
 */
public class InfoServlet extends HttpServlet {

	public InfoServlet() {
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
		InfoResult ar = new InfoResult();
		try {
			int currentPage = Integer.parseInt(request.getParameter("pagenum"));
			int type = Integer.parseInt(request.getParameter("type"));
			DaoUtil dao = new DaoUtil();
			List<Object> list = dao.queryByPropertyAndPage(Info.class, "type",
					type, currentPage);

			List<InfoResult.BodyBean> listBody = new ArrayList<InfoResult.BodyBean>();
			if (null != list && list.size() > 0) {
				for (Object obj : list) {
					Info ann = (Info) obj;
					InfoResult.BodyBean bean = new InfoResult.BodyBean();
					bean.setDetail(ann.getDetail());
					bean.setImgurl(ann.getImgUrl());
					bean.setSummary(ann.getSummary());
					bean.setTitle(ann.getTitle());
					listBody.add(bean);
				}
			}
			ar.setCode(Constant.CODESUCCESS);
			ar.setMsg("资讯信息获取成功");
			ar.setBody(listBody);

		} catch (Exception e) {
			e.printStackTrace();
			ar.setCode(Constant.CODEFAIL);
			ar.setMsg("资讯信息获取失败");
		} finally {
			Gson gson = new Gson();
			String json = gson.toJson(ar);
			PrintUtil.print(json, response);
		}

	}

}
