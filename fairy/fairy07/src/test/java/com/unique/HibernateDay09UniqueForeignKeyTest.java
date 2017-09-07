package com.unique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unique.onetoone2.Certification;
import com.unique.onetoone2.Person;

public class HibernateDay09UniqueForeignKeyTest {
	
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
	
	@Test
	public void testAdd(){
		
		Person person=new Person("安静0", "啧啧");
		
		Certification certification=new Certification("123222");
		
		person.setCertification(certification);
		certification.setPerson(person);
		
		session.saveOrUpdate(person);
		
	}
	
	/**
	 * 请大家自行测试删除、查询....
	 * */
	
	
	@After
	public void destroy(){
		tr.commit();
		session.close();
		sf.close();
	}
	
}
