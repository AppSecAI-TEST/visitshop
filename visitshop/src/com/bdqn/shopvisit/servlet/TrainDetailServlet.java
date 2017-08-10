package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.TrainData;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.TrainDetailResult;
import com.bdqn.shopvisit.util.CommonUtil;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: TrainDetailServlet
 * 
 * @Description: 培训详情数据接口(已提交状态数据)
 * @author Leon
 */
public class TrainDetailServlet extends HttpServlet {

	public TrainDetailServlet() {
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
		String trainid = request.getParameter("trainid");
		DaoUtil dao = new DaoUtil();
		TrainDetailResult tdr = new TrainDetailResult();
		TrainDetailResult.BodyBean body = new TrainDetailResult.BodyBean();
		Map map = new HashMap();
		map.put("userId", userid);
		map.put("trainId", trainid);
		try {
			List<Object> list = dao.queryByMap(TrainData.class, map);
			if (null != list && list.size() > 0) {
				TrainData td = (TrainData) list.get(0);
				body.setFeedback(td.getFeedback());
				body.setImgPath(td.getImgPath());
				body.setImgName(td.getImgName());
				body.setScore(td.getScore());
			}
			tdr.setCode(Constant.CODESUCCESS);
			tdr.setMsg("培训详情获取成功");
			tdr.setBody(body);

		} catch (Exception e) {
			e.printStackTrace();
			tdr.setCode(Constant.CODEFAIL);
			tdr.setMsg("培训详情获取失败");
		} finally {
			Gson gson = new Gson();
			String json = gson.toJson(tdr);
			PrintUtil.print(json, response);
		}
	}
}
