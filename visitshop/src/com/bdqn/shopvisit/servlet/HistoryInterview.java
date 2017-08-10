package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.Customer;
import com.bdqn.shopvisit.bean.Interview;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.HistoryInterviewResult;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: HistoryInterview
 * 
 * @Description: 拜访历史信息列表
 * @author Leon
 */
public class HistoryInterview extends HttpServlet {

	public HistoryInterview() {
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
		String pagenum = request.getParameter("pagenum");
		DaoUtil dao = new DaoUtil();
		HistoryInterviewResult hir = new HistoryInterviewResult();
		try {
			// 查询数据库中存储数据
			List<Object> list = dao.queryByPage(Interview.class,
					Integer.parseInt(pagenum), userid);
			List<HistoryInterviewResult.BodyBean> listResult = new ArrayList<HistoryInterviewResult.BodyBean>();
			// 将查询到的数据封装到接口封装类里
			if (list.size() > 0) {
				for (Object object : list) {
					Interview interview = (Interview) object;
					HistoryInterviewResult.BodyBean body = new HistoryInterviewResult.BodyBean();
					Customer customer = (Customer) dao
							.queryByProperty(Customer.class, "id",
									interview.getPersonId()).get(0);
					if (null != customer) {
						body.setCompany(customer.getCompany());
						body.setJob(customer.getJob());
						body.setPerson(customer.getName());
						body.setPhone(customer.getPhone());
					}

					body.setAim(interview.getAim());
					body.setId(interview.getId());
					body.setSummary(interview.getSummary());
					body.setTitle(interview.getTitle());
					body.setVisitdate(interview.getVisitDate());
					listResult.add(body);
				}
			}
			hir.setBody(listResult);
			hir.setCode(Constant.CODESUCCESS);
			hir.setMsg("拜访列表查询成功");

		} catch (Exception e) {
			e.printStackTrace();
			hir.setCode(Constant.CODEFAIL);
			hir.setMsg("拜访列表查询失败");
		} finally {
			Gson gson = new Gson();
			String json = gson.toJson(hir);
			PrintUtil.print(json, response);
		}
	}
}
