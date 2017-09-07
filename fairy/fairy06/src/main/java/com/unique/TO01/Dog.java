package com.unique.TO01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_dog")
@PrimaryKeyJoinColumn(name="id")
public class Dog extends Animal{

	@Column
	private String dogtype;

	public Dog(String name, int hight, String dogtype) {
		super(name, hight);
		this.dogtype = dogtype;
	}

	public Dog() {
		super();
	}

	public String getDogtype() {
		return dogtype;
	}

	public void setDogtype(String dogtype) {
		this.dogtype = dogtype;
	}

	@Override
	public String toString() {
		return "Dog [dogtype=" + dogtype + "]";
	}
	
	
}
