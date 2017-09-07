package com.unique.QTao;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="informtion")
public class Personal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private int idcard;
	@Embedded
	private Address address;
	public Personal(int id, String name, int age, int idcard, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.idcard = idcard;
		this.address = address;
	}
	public Personal(String name, int age, int idcard, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.idcard = idcard;
		this.address = address;
	}
	public Personal() {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getIdcard() {
		return idcard;
	}
	public void setIdcard(int idcard) {
		this.idcard = idcard;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Personal [id=" + id + ", name=" + name + ", age=" + age + ", idcard=" + idcard + ", address=" + address
				+ "]";
	}
	
	
}
