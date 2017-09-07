package com.unique;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * @Cache注解用于标识该实体对象是否受二级缓存管理
 * usage属性用于指定受二级缓存管理的对象是什么性质的:
 * 1、read-only  表示受二级管理的对象是只读的  也就是说，现在如果一个对象受二级缓存管理了，那么我们现在不能更新该对象。
 *            如果要更新的话，将抛出如下的异常：
 *            java.lang.UnsupportedOperationException: Can't write to a readonly object。
 *            
 *            但是在read-only的情况下，我们可以新增对象，新增的对象会自动添加到二级缓存，当然归根结底，
 *            会添加到数据库中，如果向数据库中添加失败，那么二级缓存也不会缓存该对象，否则，该对象就是无效的数据。
 * */
@Entity
@Table(name="t_emp")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Emp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;				//员工编号
	
	@Column
	private String name;		//员工名称
	
	@Column
	private String gender;		//员工性别
	
	@Column
	private Date birthday;		//员工出生日期
	
	@Column
	private float salary;		//员工薪水
	
	@ManyToOne(targetEntity=Dept.class,fetch=FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="deptid")
	private Dept dept;			//员工所在部门

	public Emp() {
		super();
	}
	
	public Emp(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	public Emp(String name, String gender, Date birthday, float salary) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
	}

	public Emp(String name, String gender, Date birthday, float salary, Dept dept) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
		this.dept = dept;
	}

	public Emp(int id, String name, String gender, Date birthday, float salary, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", salary="
				+ salary + ", dept=" + dept + "]";
	}
	
}
