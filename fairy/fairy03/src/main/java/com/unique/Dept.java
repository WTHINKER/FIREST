package com.unique;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "t_dept")
public class Dept {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String city;
	@Column
//	@OneToMany(mappedBy="",orphanRemoval=true)
	@OneToMany(targetEntity=Emp.class,fetch=FetchType.LAZY,orphanRemoval=true)
	@Cascade(value= {CascadeType.SAVE_UPDATE,CascadeType.DELETE_ORPHAN,CascadeType.DELETE})
	@JoinColumn(name="deptid")
	private Set<Emp> set = new HashSet<Emp>();//一对多，集合中存放员工对象
	public Dept(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Dept(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public Dept() {
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set<Emp> getSet() {
		return set;
	}
	public void setSet(Set<Emp> set) {
		this.set = set;
	}
	@Override
	public String toString() {
		return "t_dept [id=" + id + ", name=" + name + ", city=" + city + ", set=" + set + "]";
	}
	
	
}
