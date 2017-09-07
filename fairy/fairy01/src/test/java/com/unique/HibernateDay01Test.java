package com.unique;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unique.Book;

public class HibernateDay01Test {
	
	private SessionFactory sessionFactory;
	
	private Session session;
	
	@Before
	public void before(){
		
		//加载Hibernate的配置文件,Configuration对象
		Configuration config = new Configuration().configure();
		
		//使用Configuration对象创建一个SessionFactory对象
		sessionFactory=config.buildSessionFactory();
		
		//使用SessionFactory对象创建一个Sesssion
		session=sessionFactory.openSession();
		
	}
	/**
	 * 添加一本书
	 * */
	@Test
	public void addBook(){
		//使用Session开启Hibernate事务
		Transaction tr = session.beginTransaction();
	
		//添加User
		Book book = new Book("简爱666", "1000", 100);
		session.save(book);
		
		//提交事务
		tr.commit();
		
		System.out.println("保存成功......");
	}
	
	/**
	 * 查询所有书
	 * */
	@Test
	public void showAllBook(){
		
		Transaction tr = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		Query<Book> query = session.createQuery("from book");
		
		List<Book> list = query.list();
		
		for(int i=0;i<list.size();i++){
			Book book = list.get(i);
			System.out.println(book);
		}
		
		tr.commit();
		
	}
	
	
	/**
	 * 查询指定ID编号的书籍
	 * */
	@Test
	public void showUserById(){
		
		Transaction tr = session.beginTransaction();
		
		//查询1号User
		Book book = session.get(Book.class, 2);
		System.out.println(book);
		
		tr.commit();
	}
	
	/**
	 * 删除一个书
	 * */
	@Test
	public void deleteUser(){
		Transaction tr = session.beginTransaction();
		
		Book book = session.get(Book.class, 2);
		
		session.delete(book);
		
		tr.commit();
	}
	
	/**
	 * 修改书籍
	 * */
	@Test
	public void updateUser(){
		Transaction tr = session.beginTransaction();
		
		Book book = session.get(Book.class, 2);
		
		book.setBookname("xiaotaohong");
		
		tr.commit();
	}
	
	@After
	public void after(){
		//关闭Session
		session.close();
		//关闭SessionFactory
		sessionFactory.close();
	}
	
}
