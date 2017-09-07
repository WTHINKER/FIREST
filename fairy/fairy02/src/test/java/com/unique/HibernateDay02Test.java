package com.unique;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateDay02Test {
	
	private SessionFactory sessionFactory;
	
	private Session session;
	
	private Transaction tr;
	@Before
	public void before(){
		
		sessionFactory=new Configuration().configure().buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		tr=session.beginTransaction();
	}
	/**
	 * Many-To-One 多对一关联映射
	 * 添加Many方  同时One方也是新添加的
	 * */
	@Test
	public void addEmp(){
		
		Dept dept=new Dept("安保部","成都");
		/**
		 * 在保存Emp的时候，同时要求先保存该员工对应的Dept,
		 * 这种操作我们称之为：级联。
		 * */
		Emp emp=new Emp("她说", "女", new Date(), 4000, dept);
		
		session.saveOrUpdate(emp);
		
		System.out.println("添加成功");
	}
	
	/**
	 * One方已经存在,只添加Many方
	 * */
	@Test
	public void addEmp02(){
		
		Dept dept=session.get(Dept.class, 1);
		
		dept.setName("Money");
		
		Emp emp=new Emp("xiaowu", "m", new Date(), 5000, dept);
		
		session.saveOrUpdate(emp);
		
		System.out.println("add success");
	}
	
	/**
	 * 查询所有Many方
	 * */
	@Test
	public void queryAllEmp(){
		
//		List<Emp> list = session.createQuery("from Emp").list();
		
		//join 连接查询
//		List<Emp> list = session.createQuery("from Emp e left join fetch e.dept").list();
		
		Query<Emp> query = session.createQuery("from Emp e left join fetch e.dept d where d.id=:id");
		
		query.setParameter("id", 1);
		
		List<Emp> list =query.list();
		
		for(int i=0;i<list.size();i++){
			
			Emp emp=list.get(i);
			
			System.out.println(emp.getName()+"\t"+emp.getBirthday()+"\t"+emp.getDept().getId());
			
		}
		
	}
	
	/**
	 * 在查询Many方的时候，在这里，就是查询Emp的时候，Hibernate默认使用 left outer join
	 * 把One方，即Dept给查询出来。
	 * */
	@Test
	public void queryEmpById(){
		
		Emp emp=session.get(Emp.class, 2);
		
		//System.out.println(emp.getDept());
		System.out.println(emp.getDept().getName());
	}
	
	/**
	 * 删除指定员工
	 * */
	@Test
	public void delEmp(){
		
		Emp emp=session.get(Emp.class, 4);
		
		session.delete(emp);
		
	}
	
	
	@After
	public void after(){
		
		tr.commit();
		
		session.close();
		
		sessionFactory.close();
		
	}
	
	
}
