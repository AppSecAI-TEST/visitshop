package com.bdqn.shopvisit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.Customer;
import com.bdqn.shopvisit.bean.Interview;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.HistoryInterviewResult;
import com.bdqn.shopvisit.util.CommonUtil;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: InterviewSubmit
 * 
 * @Description: 拜访提交接口
 * @author Leon
 */
public class InterviewSubmit extends HttpServlet {

	public InterviewSubmit() {
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

		String title = request.getParameter("title");
		String person = request.getParameter("person");

		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		String job = request.getParameter("job");
		String aim = request.getParameter("aim");
		String summary = request.getParameter("summary");
		String userid = request.getParameter("userid");

		HistoryInterviewResult hi = new HistoryInterviewResult();
		try {
			DaoUtil dao = new DaoUtil();
			Interview iv = new Interview();
			Customer customer = new Customer();
			customer.setName(person);
			customer.setCompany(company);
			customer.setPhone(phone);
			customer.setJob(job);
			int personId = dao.save(customer);

			iv.setTitle(title);
			iv.setPersonId(personId);
			iv.setVisitDate(CommonUtil.getTodayDate());
			iv.setAim(aim);
			iv.setSummary(summary);
			iv.setUserId(userid);

			dao.save(iv);
			hi.setCode(Constant.CODESUCCESS);
			hi.setMsg("拜访提交成功");
		} catch (Exception e) {
			e.printStackTrace();
			hi.setCode(Constant.CODEFAIL);
			hi.setMsg("拜访提交失败");
		} finally {
			Gson gson = new Gson();
			String json = gson.toJson(hi);
			PrintUtil.print(json, response);
		}

	}

}
