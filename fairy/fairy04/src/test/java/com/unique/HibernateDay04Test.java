package com.unique;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unique.Dept;
import com.unique.Emp;

public class HibernateDay04Test {
	
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
		
		Dept dept=new Dept("师资部", "成都");
		
		Emp emp=new Emp("多对多000", "f", new Date(), 3000);
		
		dept.getEmpSet().add(emp);
		
		//当使用mappedBy的时候，必须把dept设置给emp,否则emp的外键为空
		//如果是使用@JoinColumn，这个时候One要维护Many方--即要执行update语句更新emp的deptid,
		//那么这个时候不需要把dept设置emp,都可以添加成功。
		emp.setDept(dept);
		
		session.saveOrUpdate(dept);
		
		System.out.println("----------添加成功----------");
	}
	
	@Test
	public void addEmp(){
		
		Emp emp=new Emp("honghong", "f", new Date(), 3000);
		
		Dept dept=new Dept("Teacher", "sccd");
		
		emp.setDept(dept);
		
		session.save(emp);
		
		System.out.println("添加成功....");
	}
	
	/**
	 * 测试mappedBy
	 * */
	@Test
	public void add(){
		
		Emp emp=new Emp("honghong", "f", new Date(), 3000);
		
		Dept dept=new Dept("Teacher", "sccd");
		
		emp.setDept(dept);
		
		dept.getEmpSet().add(emp);
		
		session.save(dept);
		
		System.out.println("添加成功....");
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
