package com.unique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unique.Hi;

public class HiTest {

	private Configuration configuration;
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	@Before
	public void init() {
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	@Test
	public void testAdd() {
		transaction = session.beginTransaction();
		Hi hi = new Hi("晴天");
		Hi hi1 = new Hi("花海");
		Hi hi2 = new Hi("安静");
		session.saveOrUpdate(hi);
		session.saveOrUpdate(hi1);
		session.saveOrUpdate(hi2);
		transaction.commit();
	}
	@Test
	public void testVersion() {
		transaction = session.beginTransaction();
		Hi hi = session.get(Hi.class, 5);
		hi.setName("ffsa");
		session.saveOrUpdate(hi);
		transaction.commit();
	}
	@After
	public void testAfter() {
		transaction = session.beginTransaction();
		session.close();
		sessionFactory.close();
	}
}
