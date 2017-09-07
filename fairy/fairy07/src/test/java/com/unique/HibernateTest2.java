package com.unique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unique.OneToOne.IdCard;
import com.unique.OneToOne.People;

public class HibernateTest2 {

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
		People people = new People("花海", 10);
		IdCard idcard = new IdCard(123456);
		people.setIdcard(idcard);
		idcard.setPeople(people);
		session.saveOrUpdate(people);
		transaction.commit();
	}
	
	@After
	public void after() {
		session.close();
		sessionFactory.close();
	}
}
