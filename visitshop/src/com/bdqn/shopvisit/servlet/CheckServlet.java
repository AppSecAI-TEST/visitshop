package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.AppInfo;
import com.bdqn.shopvisit.bean.Shop;
import com.bdqn.shopvisit.bean.User;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.AppInfoResult;
import com.bdqn.shopvisit.resultbean.LoginBean;
import com.bdqn.shopvisit.util.CommonUtil;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

import sun.awt.RepaintArea;

public class CheckServlet extends HttpServlet {

	public CheckServlet() {
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

		Connection conn = null;
		String sql, resutleJson;

		String url = "jdbc:mysql://localhost:3306/shopvisit?"
				+ "user=root&password&useUnicode=true&characterEncoding=UTF8";

		try {
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
//			System.out.println("成功加载MySQL驱动程序");
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			sql = "select * from appinfo";
			ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
			resutleJson = "数据库连接正常！";
		} catch (Exception e) {
			e.printStackTrace();
			resutleJson = "数据库连接异常！请检查数据库是否已经启动，并且重启服务器tomcat"
					;
		} finally {
			try {
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		PrintUtil.print(resutleJson, response);
	}

}
