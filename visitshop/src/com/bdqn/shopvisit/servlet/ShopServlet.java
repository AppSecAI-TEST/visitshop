package com.bdqn.shopvisit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.shopvisit.bean.Shop;
import com.bdqn.shopvisit.bean.Visit;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.ShopResult;
import com.bdqn.shopvisit.resultbean.ShopResult.ShoplistsBean;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: ShopServlet
 * 
 * @Description: 店面信息接口
 * @author Leon
 */
public class ShopServlet extends HttpServlet {

	public ShopServlet() {
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
		String keyword = request.getParameter("keyword");
		DaoUtil dao = new DaoUtil();
		ShopResult shopResult = new ShopResult();
		List<ShoplistsBean> listShop = new ArrayList<ShoplistsBean>();
		try {
			List<Object> list = dao.queryByKeyword(Shop.class, keyword, "name");
			if (null != list && list.size() > 0) {
				for (Object object : list) {
					ShoplistsBean slb = new ShoplistsBean();
					Shop s = (Shop) object;
					slb.setId(s.getShopid());
					slb.setName(s.getName());
					listShop.add(slb);
				}
			}
			shopResult.setShoplists(listShop);
			shopResult.setCode(Constant.CODESUCCESS);
			shopResult.setMsg("店面信息查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			shopResult.setCode(Constant.CODEFAIL);
			shopResult.setMsg("店面信息查询失败");
		} finally {
			shopResult.setShoplists(listShop);
			Gson gson = new Gson();
			String json = gson.toJson(shopResult);
			PrintUtil.print(json, response);
		}

	}

}
