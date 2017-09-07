package com.unique;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="t_dept")
public class Dept {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;  			//部门编号
	
	@Column
	private String name;		//部门名称
	
	@Column
	private String city;  		//所在城市

	/**
	 * 在一对多及多对一双向关联这里，需要注意：
	 * 这里配置有两种：
	 * 方式1：
	 * @OneToMany(targetEntity=Emp.class)
	 * @Cascade(value={CascadeType.SAVE_UPDATE})
	 * @JoinColumn(name="deptid")
	 * 
	 * 方式2：
	 * @OneToMany(targetEntity=Emp.class,mappedBy="dept")
	 * @Cascade(value={CascadeType.SAVE_UPDATE})
	 * 
	 * 1、如果使用mappedBy就不能使用@JoinColumn注解，即它们俩不能同时使用
	 * 2、mappedBy的作用是：告诉Hibernate，现在One方不再维护One和Many方的关系，
	 *   这个时候当新增部门和员工的时候，不再执行update语句。但是我们在新增的时候，务必
	 *   要把One设置给Many
	 * 
	 * 
	 * 如果我们采用的是XML配置，XML中要实现mappedBy的效果/作用，用的是reverse="true"。
	 * */
	//面向部门，是一对多的关系！！！
	@OneToMany(targetEntity=Emp.class,mappedBy="dept")
	@Cascade(value={CascadeType.SAVE_UPDATE})
	private Set<Emp> empSet=new HashSet<Emp>();
	
	public Dept() {
		super();
	}

	public Dept(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Dept(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Emp> getEmpSet() {
		return empSet;
	}

	public void setEmpSet(Set<Emp> empSet) {
		this.empSet = empSet;
	}
	
}
