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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name="t_emp")
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
	
	//面向员工，是多对一的关系！！！
	@ManyToOne(targetEntity=Dept.class,fetch=FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="deptid")
	private Dept dept;			//员工所在部门

	public Emp() {
		super();
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
	
}
