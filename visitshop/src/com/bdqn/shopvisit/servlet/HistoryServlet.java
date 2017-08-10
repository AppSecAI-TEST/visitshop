package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.Shop;
import com.bdqn.shopvisit.bean.Visit;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.HistoryVisit;
import com.bdqn.shopvisit.resultbean.HistoryVisit.DatelistBean;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;

/**
 * 
 * ClassName: HistoryServlet
 * 
 * @Description: 巡店历史查询接口
 * @author Leon
 */
public class HistoryServlet extends HttpServlet {

	int index = 1000;

	/**
	 * Constructor of the object.
	 */
	public HistoryServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		// testAddVisit();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String currentPage = request.getParameter("pagenum");
		String userid = request.getParameter("userid");
		String keyword = request.getParameter("keyword");
		HistoryVisit hv = new HistoryVisit();
		if (null == currentPage || "".equals(currentPage)) {
			currentPage = "1";
		}
		hv.setPage(Integer.parseInt(currentPage));
		DaoUtil dao = new DaoUtil();
		try {
			// 没有搜索条件，默认查询所有
			if (null == keyword || "".equals(keyword)) {
				List<Object> list = queryVisit(dao,
						Integer.parseInt(currentPage), userid);
				hv.setCode(Constant.CODESUCCESS);
				hv.setMsg("历史巡店查询成功");
				List<DatelistBean> listdb = new ArrayList<HistoryVisit.DatelistBean>();

				if (list.size() >= 1) {
					for (Object obj : list) {
						HistoryVisit.DatelistBean dlb = new HistoryVisit.DatelistBean();
						Visit visit = (Visit) obj;

						// Shop shop = (Shop) dao.queryByProperty(Shop.class,
						// "shopid", visit.getShopId()).get(0);
						dlb.setId(visit.getId());
						dlb.setName(visit.getShopName());
						dlb.setShoplocation(visit.getShopAddress());
						dlb.setShopid(visit.getShopId());
						dlb.setShoplevel(visit.getShopLevel());
						dlb.setUserid(visit.getUserId());
						dlb.setVisitdate(visit.getVisitDate());
						dlb.setFeedback(visit.getFeedback());
						dlb.setImgpath(visit.getImgPath());
						dlb.setImgname(visit.getImgName());
						listdb.add(dlb);
					}
				}
				hv.setDatelist(listdb);
			} else {
				// 根据搜索条件查询
				List<Object> list = dao.queryHistoryVisitByKeyword(Visit.class,
						keyword, Integer.parseInt(currentPage), userid);
				hv.setMsg("历史巡店查询成功");
				List<DatelistBean> listdb = new ArrayList<HistoryVisit.DatelistBean>();

				if (list.size() >= 1) {
					for (Object obj : list) {
						HistoryVisit.DatelistBean dlb = new HistoryVisit.DatelistBean();
						Visit visit = (Visit) obj;
						
						dlb.setId(visit.getId());
						dlb.setName(visit.getShopName());
						dlb.setShoplocation(visit.getShopAddress());
						dlb.setShopid(visit.getShopId());
						dlb.setShoplevel(visit.getShopLevel());
						dlb.setUserid(visit.getUserId());
						dlb.setVisitdate(visit.getVisitDate());
						dlb.setFeedback(visit.getFeedback());
						dlb.setImgpath(visit.getImgPath());
						dlb.setImgname(visit.getImgName());
						listdb.add(dlb);
					}
				}
				hv.setDatelist(listdb);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 查询异常
			hv.setCode(Constant.CODEFAIL);
			hv.setMsg("网络异常，请稍后再试");
		} finally {
			Gson gson = new Gson();
			String json = gson.toJson(hv);
			PrintUtil.print(json, response);
		}

	}

	/**
	 * 查询巡店历史记录
	 */
	private List<Object> queryVisit(DaoUtil dao, int currentPage, String userid) {
		List<Object> list = dao.queryByPage(Visit.class, currentPage, userid);
		return list;
	}

	/**
	 * 增加巡店数据入库
	 */
	private void testAddVisit() {
		DaoUtil dao = new DaoUtil();
		// 模拟插入巡店数据

	}

}
