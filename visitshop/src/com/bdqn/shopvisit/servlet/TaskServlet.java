package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.Task;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.TaskResult;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: TaskServlet
 * 
 * @Description: 任务信息获取接口
 * @author Leon
 */
public class TaskServlet extends HttpServlet {

	public TaskServlet() {
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
		String currentPage = request.getParameter("pagenum");
		
		DaoUtil dao = new DaoUtil();
		TaskResult tr = new TaskResult();
		try {
			List<Object> list = dao.queryByPage(Task.class,
					Integer.parseInt(currentPage), "");
	
			List<TaskResult.BodyBean> listBody = new ArrayList<TaskResult.BodyBean>();
			if (null != list && list.size() > 0) {
				for (Object obj : list) {
					Task task = (Task) obj;
					TaskResult.BodyBean bean = new TaskResult.BodyBean();
					bean.setDetail(task.getDetail());
					bean.setExecutedate(task.getExecuteDate());
					bean.setPublishdate(task.getPublishDate());
					bean.setState(task.getState());
					bean.setTitle(task.getTitle());
					listBody.add(bean);
				}
			}
			tr.setCode(Constant.CODESUCCESS);
			tr.setMsg("任务信息获取成功");
			tr.setBody(listBody);
		} catch (Exception e) {
			e.printStackTrace();
			tr.setCode(Constant.CODEFAIL);
			tr.setMsg("任务信息获取失败");
		} finally {
			Gson gson = new Gson();
			String json = gson.toJson(tr);
			PrintUtil.print(json, response);
		}
	}
}
