package com.unique;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {

	private Configuration config;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	@Before
	public void init() {
		config = new Configuration().configure();
		factory = config.buildSessionFactory();
		session = factory.openSession();
	}

	@Test
	public void addSong() {
		transaction = session.beginTransaction();
		Singer singer = new Singer("许嵩", "男", 20);
		Song song = new Song("认错");
		singer.getSet().add(song);
		session.saveOrUpdate(singer);
		transaction.commit();
		System.out.println("测试成功...");
	}
	
	@Test
	public void find() {
		transaction = session.beginTransaction();
		Singer singer = session.get(Singer.class, 1);
		Song song = session.get(Song.class, 2);
		Song song2 = session.get(Song.class, 3);
		singer.getSet().add(song);
		singer.getSet().add(song2);
		session.saveOrUpdate(singer);
		transaction.commit();
		System.out.println("测试成功...");
	}
	
	@Test
	public void findsinger() {
		transaction = session.beginTransaction();
//		Singer singer = session.get(Singer.class, 1);
//		System.out.println(singer.toString());
		@SuppressWarnings("unchecked")
		Query<Singer>query=session.createQuery("from Singer");
		List<Singer>list=query.list();
		for (Singer singer : list) {
//			System.out.println(singer.getSname());
			if("张学友".equals(singer.getSname())) {
				Set<Song>set=singer.getSet();
				for (Song song : set) {
					System.out.println(song.getName());
				}
			}
		}
		transaction.commit();
	}
}
