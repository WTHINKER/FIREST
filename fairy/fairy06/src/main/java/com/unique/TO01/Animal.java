package com.unique.TO01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="t_animal")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Animal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int hight;
	public Animal(int id, String name, int hight) {
		super();
		this.id = id;
		this.name = name;
		this.hight = hight;
	}
	public Animal(String name, int hight) {
		super();
		this.name = name;
		this.hight = hight;
	}
	public Animal() {
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
	public int getHight() {
		return hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", hight=" + hight + "]";
	}
	
}
