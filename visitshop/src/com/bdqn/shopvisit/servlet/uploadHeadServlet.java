package com.bdqn.shopvisit.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bdqn.shopvisit.bean.Train;
import com.bdqn.shopvisit.bean.TrainData;
import com.bdqn.shopvisit.bean.User;
import com.bdqn.shopvisit.dao.DaoUtil;
import com.bdqn.shopvisit.resultbean.SubmitResult;
import com.bdqn.shopvisit.util.CommonUtil;
import com.bdqn.shopvisit.util.Constant;
import com.bdqn.shopvisit.util.PrintUtil;
import com.google.gson.Gson;

/**
 * 
 * ClassName: uploadHeadServlet
 * 
 * @Description: 头像上传接口
 * @author Leon
 */
public class uploadHeadServlet extends HttpServlet {
	String filename;
	/**
	 * Constructor of the object.
	 */
	public uploadHeadServlet() {
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
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		SubmitResult sr = new SubmitResult();
		User user = new User();
		if (isMultipart) {
			File dir = createFileDir();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = item.getString("utf-8");
						// 根据参数名称填充数据
						if ("userid".equals(name)) {
							user.setUserId(value);
						}
					} else { // 文件
						filename = item.getName();
						System.out.println("接收文件:" + filename);
						item.write(new File(dir, filename));
					}

				}
				DaoUtil dao = new DaoUtil();
				List<Object> list = dao.queryByProperty(User.class, "userId",
						user.getUserId());
				if (null == list || list.size() < 1) {
					sr.setCode(Constant.CODEFAIL);
					sr.setMsg("提交失败，用户不存在");
				} else {

					user = (User) list.get(0);
					user.setImg("visitshop/img/user/" + filename);
					dao.update(user);
					sr.setCode(Constant.CODESUCCESS);
					sr.setMsg(user.getImg());
				}

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
		// File dir = new File("d:\\img" + File.separator + "train"
		// + File.separator + CommonUtil.getTodayDate() + File.separator);
		File dir = new File(CommonUtil.getRealPath(getServletContext(), "user")
				+ File.separator);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}

}
