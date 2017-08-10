package com.bdqn.shopvisit.util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * ClassName: PrintUtil
 * 
 * @Description: 返回信息工具类
 * @author Leon
 */
public class PrintUtil {

	public static void print(String msg, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = null;
		try {
			if (null != response) {
				writer = response.getWriter();
				writer.print(msg);
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
}
