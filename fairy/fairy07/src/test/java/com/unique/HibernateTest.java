package com.unique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.unique.QTao.Address;
import com.unique.QTao.Personal;

public class HibernateTest {

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
	public void add() {
		transaction = session.beginTransaction();
		Address address = new Address("四川省", "武侯区", "一曲东风破.");
		Personal personal = new Personal("东风破", 10, 123, address);
		session.saveOrUpdate(personal);
		transaction.commit();
	}
	@Test
	public void find() {
		transaction = session.beginTransaction();
		Personal personal = session.get(Personal.class, 1);
		System.out.println(personal.getName()+"：：："+personal.getAddress());
		transaction.commit();
	}
	@Test
	public void delete() {
		transaction = session.beginTransaction();
		Personal personal = session.get(Personal.class, 1);
		session.delete(personal);
		transaction.commit();
	}
	@Test
	public void update() {
		transaction = session.beginTransaction();
		Personal personal = session.get(Personal.class, 2);
		personal.getAddress().setStreet("一首歌的时间。");
		transaction.commit();
	}
	@Test
	public void after() {
		session.close();
		sessionFactory.close();
	}
}
