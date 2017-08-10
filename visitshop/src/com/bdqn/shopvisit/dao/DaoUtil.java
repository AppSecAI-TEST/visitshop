package com.bdqn.shopvisit.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.bdqn.shopvisit.bean.User;

/**
 * 
 * ClassName: DaoUtil
 * 
 * @Description: 数据库操作工具类
 * @author Leon
 */
public class DaoUtil {

	static final int PAGESIZE = 10;// 默认查询数据返回每页10条
	SessionFactory sessionFaction;

	public DaoUtil() {
		sessionFaction = HibernateUtil.getSessionFactory();
	}

	/**
	 * 保存单个实体对象
	 */
	public int save(Object obj) {

		Session session = sessionFaction.openSession();
		session.beginTransaction();
		int id = (Integer) session.save(obj);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	/**
	 * 更新实体对象
	 * 
	 * @param obj
	 */
	public void update(Object obj) {
		Session session = null;
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/**
	 * 分页查询数据
	 * 
	 * @param currentPage
	 * @return
	 */
	public List<Object> queryByPage(Class clazz, int currentPage, String userid) {
		Session session = null;
		List<Object> list = new ArrayList<Object>();
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			Query q;
			// 当传入userid的时候，根据userid过滤，否则查询所有
			if (null == userid || "".equals(userid)) {
				q = session.createQuery("from " + clazz.getName()
						+ " order by id desc");
			} else {
				q = session.createQuery("from " + clazz.getName()
						+ " where userId = '" + userid + "'"
						+ " order by id desc");
			}

			q.setFirstResult((currentPage - 1) * PAGESIZE);
			q.setMaxResults(PAGESIZE);
			session.getTransaction().commit();
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 查询所有数据
	 * 
	 * @param clazz
	 * @return
	 */
	public List<Object> queryAll(Class clazz) {
		Session session = null;
		List<Object> list = null;
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			Query q = session.createQuery("from " + clazz.getName());
			session.getTransaction().commit();
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	public User queryUser(String username, String pwd) {
		Session session = null;
		List<User> list = null;
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			Criteria cri = session.createCriteria(User.class);
			list = cri.add(Restrictions.eq("userId", username))
					.add(Restrictions.eq("passWord", pwd)).list();
			session.getTransaction().commit();

			if (list == null || list.size() < 1) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		return list.get(0);
	}

	public void checkSession() {
		if (sessionFaction.isClosed()) {
			sessionFaction = HibernateUtil.getSessionFactory();
		}
	}

	/**
	 * 根据属性搜索
	 * 
	 * @param clazz
	 * @param currentPage
	 * @param property
	 * @param value
	 * @return
	 */
	public List<Object> queryByProperty(Class clazz, String property,
			Object value) {
		Session session = null;
		List<Object> list = null;
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			Query q;
			if (value instanceof Integer) {
				q = session.createQuery("from " + clazz.getName() + " where "
						+ property + " = " + value + " order by id desc");
			} else {
				q = session
						.createQuery("from " + clazz.getName() + " where "
								+ property + " = '" + value + "'"
								+ " order by id desc");
			}
			session.getTransaction().commit();
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 根据map集合条件查询数据
	 * 
	 * @param clazz
	 * @param map
	 * @return
	 */
	public List<Object> queryByMap(Class clazz, Map map) {
		Session session = null;
		List<Object> list = null;
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			Query q;
			StringBuffer querySql = new StringBuffer("from " + clazz.getName()
					+ " where ");
			Iterator it = map.keySet().iterator();
			int i = 1;
			while (it.hasNext()) {
				String key = it.next().toString();
				Object value = map.get(key);
				if (i > 1) {
					querySql.append(" and ");
				}
				if (value instanceof Integer) {
					querySql.append(key + " = " + value);
				} else {
					querySql.append(key + " = '" + value + "'");
				}
				i++;
			}
			querySql.append(" order by id desc");
			q = session.createQuery(querySql.toString());
			session.getTransaction().commit();
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 根据关键字搜索
	 * 
	 * @param clazz
	 * @param currentPage
	 * @param property
	 * @param keyword
	 * @return
	 */
	public List<Object> queryByKeyword(
			@SuppressWarnings("rawtypes") Class clazz, String keyword,
			String... property) {
		Session session = null;
		List<Object> list = null;
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			String sql = "";
			for (int i = 0; i < property.length; i++) {
				if (i == 0) {
					sql = "from " + clazz.getName() + " where " + property[i]
							+ " like '%" + keyword + "%'";
				} else {
					sql += " or " + property[i] + " like '%" + keyword + "%'";
				}
			}
			Query q = session.createQuery(sql);
			// q.setFirstResult((currentPage - 1) * PAGESIZE);
			// q.setMaxResults(PAGESIZE);
			session.getTransaction().commit();
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 根据关键字搜索条件查询历史巡店数据
	 * 
	 * @param clazz
	 * @param keyword
	 * @param currentpage
	 * @param userid
	 * @return
	 */
	public List<Object> queryHistoryVisitByKeyword(Class clazz, String keyword,
			int currentpage, String userid) {
		Session session = null;
		List<Object> list = null;
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			String sql = "";
			sql = "from " + clazz.getName() + " where shopId like '%" + keyword
					+ "%' or shopName like '%" + keyword + "%' and userId = '"
					+ userid + "' order by id desc";
			Query q = session.createQuery(sql);
			if (currentpage < 1) {
				currentpage = 1;
			}
			q.setFirstResult((currentpage - 1) * PAGESIZE);
			q.setMaxResults(PAGESIZE);
			session.getTransaction().commit();
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 根据属性查询并分页显示
	 * 
	 * @param clazz
	 * @param property
	 * @param value
	 * @param currentPage
	 * @return
	 */
	public List<Object> queryByPropertyAndPage(Class clazz, String property,
			Object value, int currentPage) {
		Session session = null;
		List<Object> list = null;
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			Query q;
			if (value instanceof Integer) {
				q = session.createQuery("from " + clazz.getName() + " where "
						+ property + " = " + value + " order by id desc");
			} else {
				q = session
						.createQuery("from " + clazz.getName() + " where "
								+ property + " = '" + value + "'"
								+ " order by id desc");
			}

			q.setFirstResult((currentPage - 1) * PAGESIZE);
			q.setMaxResults(PAGESIZE);
			session.getTransaction().commit();
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 根据trainid和userid查询是否已经提交培训
	 * 
	 * @param clazz
	 * @return
	 */
	public List<Object> queryTrainData(Class clazz, String trainId,
			String userId) {
		Session session = null;
		List<Object> list = null;
		try {
			session = sessionFaction.openSession();
			session.beginTransaction();
			Query q;
			q = session.createQuery("from " + clazz.getName()
					+ " where trainId ='" + trainId + "' and userId = '"
					+ userId + "'");
			session.getTransaction().commit();
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
		return list;
	}
}
