package com.unique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unique.TO01.Animal;
import com.unique.TO01.Cat;
import com.unique.TO01.Dog;

public class HibetnateTest {

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
	public void test() {
		transaction = session.beginTransaction();
		Animal animal = new Cat("A", 163, "120");
		Animal animal2 = new Dog("B", 120, "HSQ");
		session.save(animal);
		session.save(animal2);
		transaction.commit();
	}
	@Test
	public void find() {
		transaction = session.beginTransaction();
		Dog dog = session.get(Dog.class, 2);
		System.out.println(dog.getName()+":::::::::"+dog.getDogtype());
		transaction.commit();
	}
	@Test
	public void delete() {
		transaction = session.beginTransaction();
		Cat cat  = session.get(Cat.class, 3);
		session.delete(cat);
		transaction.commit();
	}
	@After
	public void after() {
		session.close();
		sessionFactory.close();
	}
}
