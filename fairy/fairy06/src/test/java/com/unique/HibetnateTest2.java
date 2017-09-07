package com.unique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unique.TO02.Animal;
import com.unique.TO02.Cat;
import com.unique.TO02.Dog;

public class HibetnateTest2 {

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
		Animal animal = new Cat("发付", 3, "猫");
		Animal animal2 = new Dog("誺摩", 2, "狗");
		session.save(animal);
		session.save(animal2);
		transaction.commit();
	}
	@Test
	public void find() {
		transaction = session.beginTransaction();
		Dog dog = session.get(Dog.class, 2);
		System.out.println(dog.getName()+":::::::::"+dog.getAge());
		transaction.commit();
	}
	@Test
	public void delete() {
		transaction = session.beginTransaction();
		Cat cat  = session.get(Cat.class, 1);
		session.delete(cat);
		transaction.commit();
	}
	@After
	public void after() {
		session.close();
		sessionFactory.close();
	}
}
