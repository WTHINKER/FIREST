package com.unique;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unique.Dept;
import com.unique.Emp;

public class HibernateDay03Test {
	
	private SessionFactory sessionFactory;
	
	private Session session;
	
	private Transaction tr;
	@Before
	public void before(){
		
		//加载Hibernate的配置文件,Configuration对象
		Configuration config = new Configuration().configure();
		
		//使用Configuration对象创建一个SessionFactory对象
		sessionFactory=config.buildSessionFactory();
		
		//使用SessionFactory对象创建一个Sesssion
		session=sessionFactory.openSession();
		
		tr = session.beginTransaction();
	}
	
	/**
	 * 测试添加
	 * */
	@Test
	public void addDept(){
		
		Dept dept=new Dept("Human", "sccd");
		
		Emp emp=new Emp("她说0000", "女",new Date(),2000);
		
		dept.getSet().add(emp);
		
		session.save(dept);
		
		System.out.println("----------添加成功----------");
	}
	
	@Test
	public void addDept2(){
		
		Dept dept=session.get(Dept.class, 6);
		
		Emp emp=new Emp("她说01", "女", new Date(), 1000);
		Emp emp2=new Emp("她说02", "女", new Date(), 1000);
		
		dept.getSet().add(emp);
		dept.getSet().add(emp2);
		
		session.saveOrUpdate(dept);
		
		System.out.println("----------添加成功----------");
	}
	
	
	/**
	 * 删除孤儿
	 * */
	@Test
	public void deleteOrphan(){
		
		Dept dept=session.get(Dept.class, 6);
		
		Set<Emp> set = dept.getSet();
		
		Iterator<Emp> iter = set.iterator();
		
		Emp delEmp=null;
		
		while(iter.hasNext()){
			Emp e=iter.next();
			if(e.getName().equals("lvlv")){
				delEmp=e;
				break;
			}
		}
		
		set.remove(delEmp);
		
		session.delete(dept);
		
		System.out.println("删除成功....");
		
	}
	
	
	
	@After
	public void after(){
		
		tr.commit();
		//关闭Session
		session.close();
		//关闭SessionFactory
		sessionFactory.close();
	}
}
