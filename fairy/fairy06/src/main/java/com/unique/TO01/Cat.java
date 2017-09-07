package com.unique.TO01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_cat")
@PrimaryKeyJoinColumn(name = "id")
public class Cat extends Animal {

	@Column
	private String speed;

	public Cat(int id, String name, int hight, String speed) {
		super(id, name, hight);
		this.speed = speed;
	}

	public Cat(String name, int hight, String speed) {
		super(name, hight);
		this.speed = speed;
	}

	public Cat() {
		super();
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	

}
