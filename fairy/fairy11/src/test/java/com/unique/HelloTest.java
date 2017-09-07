package com.unique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloTest {

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
		Hello hello = new Hello("秘密");
		session.saveOrUpdate(hello);
		transaction.commit();
	}
	@Test
	public void testVersion() {
		transaction = session.beginTransaction();
		Hello hello = session.get(Hello.class, 1);
		hello.setName("不能说的秘密");
		session.saveOrUpdate(hello);
		transaction.commit();
	}
	@After
	public void testAfter() {
		transaction = session.beginTransaction();
		session.close();
		sessionFactory.close();
	}
}
