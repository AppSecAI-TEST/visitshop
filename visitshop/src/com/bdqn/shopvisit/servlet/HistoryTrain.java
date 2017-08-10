package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.Train;
import com.bdqn.shopvisit.bean.TrainData;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.HistoryTrainResult;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: HistoryTrain
 * 
 * @Description: 培训列表接口,包括未完成和已提交两种状态
 * @author Leon
 */
public class HistoryTrain extends HttpServlet {

	public HistoryTrain() {
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
		String currentpage = request.getParameter("pagenum");
		DaoUtil dao = new DaoUtil();
		HistoryTrainResult htr = new HistoryTrainResult();
		List<HistoryTrainResult.BodyBean> listBody = new ArrayList<HistoryTrainResult.BodyBean>();
		try {
			// 第一次查询培训列表信息时，将userid参数置为空，不根据其过滤
			List<Object> list = dao.queryByPage(Train.class,
					Integer.parseInt(currentpage), "");
			if (list.size() > 0) {
				for (Object object : list) {
					Train train = (Train) object;

					HistoryTrainResult.BodyBean body = new HistoryTrainResult.BodyBean();
					body.setTitle(train.getTitle());
					body.setDate(train.getDate());
					body.setId(train.getId());
					body.setLocation(train.getLocation());
					body.setTrainer(train.getTrainer());
					body.setTrainid(train.getTrainId());
					List<Object> listTrainData = dao.queryTrainData(
							TrainData.class, train.getTrainId(), userid);
					if (null != listTrainData && listTrainData.size() > 0) {
						// 查询到对应记录,则表明userid用户已经完成此培训 ，否则未完成
						body.setState(1);
					} else {
						body.setState(0);
					}
					listBody.add(body);
				}
			}
			htr.setCode(Constant.CODESUCCESS);
			htr.setMsg("培训信息查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			htr.setCode(Constant.CODEFAIL);
			htr.setMsg("培训信息查询失败");
		} finally {
			htr.setBody(listBody);
			Gson gson = new Gson();
			String json = gson.toJson(htr);
			PrintUtil.print(json, response);
		}

	}
}
