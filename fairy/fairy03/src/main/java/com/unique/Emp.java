package com.unique;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mysql.fabric.xmlrpc.base.Data;

@Entity
@Table(name="t_emp")
public class Emp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String gender;
	@Column
	private Date birthday;
	@Column
	private float salary;

	public Emp(String name, String gender, Date birthday, float salary) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
	}
	public Emp(int id, String name, String gender, Date birthday, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
	}
	public Emp() {
		super();
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
	@Override
	public String toString() {
		return "t_emp [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", salary="
				+ salary + "]";
	}
	
	
}
