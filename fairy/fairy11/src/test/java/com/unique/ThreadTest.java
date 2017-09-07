package com.unique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ThreadTest {

	public static void main(String[] args) {
		final Configuration configuration;
		final SessionFactory sessionFactory;
		
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		
		new Thread(new Runnable() {
			
			public void run() {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				Hello hello = session.get(Hello.class, 1);
				System.out.println("hello:::"+hello.getName()+hello.getTime());
				
				try {
					System.out.println("沉睡10秒钟《》《》《》《》");
					Thread.sleep(10000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				hello.setName("江南");
				session.saveOrUpdate(hello);
				transaction.commit();
				session.close();
				sessionFactory.close();
				System.out.println("更新成功*******************");
			}
		}).start();
	}
}
