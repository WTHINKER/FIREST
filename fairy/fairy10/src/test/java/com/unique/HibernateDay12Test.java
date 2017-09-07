package com.unique;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateDay12Test {
	
	private Configuration cfg;
	private SessionFactory sf;
	private Session session;
	private Transaction tr;
	
	@Before
	public void init(){
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		tr=session.beginTransaction();
	}
	
	/**
	 * 一级缓存
	 * */
	@Test
	public void testFirstLevelCache(){
		
		Emp emp=session.get(Emp.class, 1);
	
		Emp emp2=session.get(Emp.class, 2);
	}
	
	/**
	 * 二级缓存
	 * */
	@Test
	public void testSecondLevelCache(){
		
		/*
		 * 1、只读
		 * */
		/*
		 * 1.1、测试二级缓存是否生效
		 * */
		Session session1=sf.openSession();
		Emp emp=session1.get(Emp.class, 1);
		session1.close();
		
		Session session2=sf.openSession();
		Emp emp2=session2.get(Emp.class, 1);
		session2.close();
		
		
		
	}
	
	/**
	 * 集合缓存
	 * 结论
	 * 1、默认情况下，Dept关联的Emp并不会放到二级缓存,只有Dept本身放到二级缓存中
	 * 2、如果要缓存集合，那么需要在集合字段上加@Cache注解
	 * */
	@Test
	public void testCollectionLevelCache(){
		
		Session session2=sf.openSession();
		
		Dept dept2=session2.get(Dept.class, 14);
		
		Iterator<Emp> iter = dept2.getEmpSet().iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		session2.close();
		
		System.out.println("=============================================");
		
		Session session3=sf.openSession();
		
		Dept dept3=session3.get(Dept.class, 14);
		
		Iterator<Emp> iter2 = dept3.getEmpSet().iterator();
		
		while(iter2.hasNext()){
			System.out.println(iter2.next());
		}
		session3.close();
		
		System.out.println("****************************************************");
		/*
		 * 由于16号Dept的empSet集合中已经包含了22号Emp,那么现在再去查询22号的时候，不会再执行SQL
		 * 直接从二级缓存中获取。
		 * */
		Session session1=sf.openSession();
		Emp emp=session1.get(Emp.class, 3);
		session1.close();
		
	}
	
	/**
	 * 查询缓存
	 * 诸如query.list()查询、query.iterate()查询，
	 * 要想它们也适用二级缓存：
	 * 1、首先需要启用查询缓存
	 * 2、还需要设置query.setCacheable(true);
	 * 这样的话，二级缓存对它们才会有作用。
	 * */
	@Test
	public void testQueryCache(){
		
		Session session1=sf.openSession();
		
		String hql="from Emp";
		
		Query<Emp> query = session1.createQuery(hql);
		query.setCacheable(true);
		query.list();
		
		
		
		session1.close();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		Session session2=sf.openSession();
		
		String hql2="from Emp";
		
		Query<Emp> query2 = session2.createQuery(hql2);
		query2.setCacheable(true);
		query2.list();
		
		session2.close();
	}
	
	
	@Test
	public void test03(){
		
		Session session2=sf.openSession();
		Emp emp2=session2.get(Emp.class, 5);
		session2.close();
		
		System.out.println("----------------------------------------------");
		/**
		 * 如果是直接执行SQL语句，Hibernate是直接到数据库查询，
		 * 这个时候不会到二级缓存去查找。也就是说，我们上面的讨论的前提是：
		 * 都是基于Hiberante面向对象的操作/查询。
		 * */
		String sql="select * from t_emp where id=:eid";
		Session session3=sf.openSession();
		NativeQuery<Emp> query = session3.createNativeQuery(sql,Emp.class);
		query.setParameter("eid", 5);
		List<Emp> list = query.list();
		session3.close();
	}
	
	/*
	 * Hiberante 性能优化
	 * 1、合理利用延迟加载
	 * 2、合理利用HQL语句
	 * 3、合理利用缓存
	 * */
	
	
	@After
	public void destroy(){
		//tr.commit();
		//session.close();
		sf.close();
	}
	
}
