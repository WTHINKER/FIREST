package com.unique;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unique.Singer;
import com.unique.Songs;

public class HibernateDay13AnnoTest {
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

		Singer singer = new Singer();
		singer.setName("周杰伦");
		Songs songs = new Songs("稻香", 10000, singer);
		Songs songs2 = new Songs("花海", 1000, singer);
		Songs songs3 = new Songs("安静", 10000, singer);

		Singer singer2 = new Singer();
		singer2.setName("张学友");
		Songs songs4 = new Songs("一路上有你", 1000000, singer2);
		Songs songs5 = new Songs("如果这都不算爱", 1000000, singer2);
		Songs songs6 = new Songs("她会来看我的演唱会", 1000000, singer2);
		List<Songs> list = new ArrayList<Songs>();
		list.add(songs);
		list.add(songs2);
		list.add(songs3);
		singer.setList(list);

		List<Songs> list2 = new ArrayList<Songs>();
		list2.add(songs4);
		list2.add(songs5);
		list2.add(songs6);
		singer2.setList(list2);

		session.saveOrUpdate(singer);
		session.saveOrUpdate(singer2);

		transaction.commit();
	}

	@After
	public void destroy() {
		session.close();
	}
}
