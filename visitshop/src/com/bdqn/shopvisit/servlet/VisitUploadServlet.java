package com.bdqn.shopvisit.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bdqn.shopvisit.bean.Visit;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.SubmitResult;
import com.bdqn.shopvisit.util.CommonUtil;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: UploadServlet
 * 
 * @Description: 巡店数据提交接口
 * @author Leon
 */
public class VisitUploadServlet extends HttpServlet {
	private int index = 1;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		SubmitResult sr = new SubmitResult();
		Visit visit = new Visit();
		String userid = "";
		StringBuffer imgs = new StringBuffer();
		if (isMultipart) {
			File dir = createFileDir();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) { // userid="test1"
						String name = item.getFieldName();
						String value = item.getString("utf-8");
						// 根据参数名称填充数据
						if ("userid".equals(name)) {
							visit.setUserId(value);
						} else if ("shopid".equals(name)) {
							visit.setShopId(value);
						} else if ("shopname".equals(name)) {
							visit.setShopName(value);
						} else if ("feedback".equals(name)) {
							visit.setFeedback(value);
						} else if ("shoplevel".equals(name)) {
							visit.setShopLevel(value);
						} else if ("shopaddress".equals(name)) {
							visit.setShopAddress(value);
						}
					} else { // 文件
						String name = item.getName();
						String filename = System.currentTimeMillis() + "_"
								+ index + name.substring(name.lastIndexOf("."));
						item.write(new File(dir, filename));
						imgs.append(filename + ";");
						index++;
					}
				}
				// 去掉最后一个多余的分隔符
				imgs.deleteCharAt(imgs.lastIndexOf(";"));
				// visit.setImgPath("/img/visit/" + CommonUtil.getTodayDate()
				// + "/");
				String imgpath = (CommonUtil.getRealPath(getServletContext(),
						"visit") + File.separator + CommonUtil.getTodayDate() + "/");
				imgpath = "/visitshop/img/visit/" + CommonUtil.getTodayDate()
						+ "/";
				visit.setImgPath(imgpath);
				visit.setImgName(imgs.toString());
				DaoUtil dao = new DaoUtil();
				visit.setVisitDate(CommonUtil.getTodayDate());
				dao.save(visit);
				sr.setCode(Constant.CODESUCCESS);
				sr.setMsg("提交成功");
			} catch (Exception e) {
				e.printStackTrace();
				sr.setCode(Constant.CODEFAIL);
				sr.setMsg("提交失败." + e.getMessage());
			} finally {
				PrintUtil.print(new Gson().toJson(sr), response);
			}
		} else {
			sr.setCode(Constant.CODEFAIL);
			sr.setMsg("请检查是否提交照片");
			PrintUtil.print(new Gson().toJson(sr), response);
		}
	}

	/**
	 * 检查文件保存目录
	 * 
	 * @return
	 */
	public File createFileDir() {
		File dir = new File(
				CommonUtil.getRealPath(getServletContext(), "visit")
						+ File.separator + CommonUtil.getTodayDate()
						+ File.separator);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}

}
