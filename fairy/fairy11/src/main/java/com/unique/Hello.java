package com.unique;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="h_hello")
public class Hello {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	
	@Version
	@UpdateTimestamp
	private Date time;
	
	
	public Hello(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Hello(String name) {
		super();
		this.name = name;
	}
	public Hello() {
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

	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Hello [id=" + id + ", name=" + name + ", time=" + time + "]";
	}
	
	
}
