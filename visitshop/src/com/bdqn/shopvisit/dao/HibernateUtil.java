package com.bdqn.shopvisit.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * 
 * ClassName: HibernateUtil 
 * @Description: Hibernate工具类
 * @author Leon
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration().configure();
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).build();
			SessionFactory sessionFactory = cfg
					.buildSessionFactory(serviceRegistry);
			return sessionFactory;

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
