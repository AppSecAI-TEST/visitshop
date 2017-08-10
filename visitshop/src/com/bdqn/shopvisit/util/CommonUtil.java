package com.bdqn.shopvisit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContext;

/**
 * 
 * ClassName: CommonUtil
 * 
 * @Description: 公用工具类
 * @author Leon
 */
public class CommonUtil {

	/**
	 * 获取系统当前日期
	 * 
	 * @return
	 */
	public static String getTodayDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		return df.format(new Date());
	}

	/***
	 * MD5加码 生成32位md5码
	 */
	public static String stringToMD5(String intput) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = intput.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取配置文件中的实际保存目录
	 * 
	 * @param config
	 * @param key
	 * @return
	 */
	public static String getRealPath(ServletContext servletContext, String key) {
		String realPath = "";
		String config = servletContext.getRealPath("/")
				+ "WEB-INF/config.properties";
		File configFile = new File(config);
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(configFile));
			realPath = servletContext.getRealPath("/img")+File.separator
					+ pro.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return realPath;
		}
	}

	public static String getImgSavePath(ServletContext servletContext) {
		String realPath = servletContext.getRealPath("/");
		return realPath;
	}

	/**
	 * 文件重命名
	 * 
	 * @param path
	 *            文件目录
	 * @param oldname
	 *            原来的文件名
	 * @param newname
	 *            新文件名
	 */
	public static void renameFile(String path, String oldname, String newname) {
		if (!oldname.equals(newname)) {// 新的文件名和以前文件名不同时,才有必要进行重命名
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (!oldfile.exists()) {
				return;// 重命名文件不存在
			}
			if (newfile.exists()) {
				newfile.delete();
			}
			oldfile.renameTo(newfile);// 覆盖
		} else {
			System.out.println("新文件名和旧文件名相同...");
		}
	}

}
