package com.unique.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "informtion_per")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int age;

	@OneToOne(targetEntity = IdCard.class)
	@PrimaryKeyJoinColumn(name = "id")
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private IdCard idcard;

	public People(int id, String name, int age, IdCard idcard) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.idcard = idcard;
	}

	public People(String name, int age, IdCard idcard) {
		super();
		this.name = name;
		this.age = age;
		this.idcard = idcard;
	}

	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public People() {
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

	public IdCard getIdcard() {
		return idcard;
	}

	public void setIdcard(IdCard idcard) {
		this.idcard = idcard;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", age=" + age + ", idcard=" + idcard + "]";
	}

}
