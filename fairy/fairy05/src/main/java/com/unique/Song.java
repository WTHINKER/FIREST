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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="song")
public class Song {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@ManyToMany(targetEntity=Singer.class,fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@JoinTable(name="relation",joinColumns= {@JoinColumn(name="songid")},inverseJoinColumns= {@JoinColumn(name="singerid")})
	private Set<Singer>set=new HashSet<Singer>();
	
	
	public Song(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Song(String name) {
		super();
		this.name = name;
	}
	public Song() {
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
	public Set<Singer> getSet() {
		return set;
	}
	public void setSet(Set<Singer> set) {
		this.set = set;
	}
	@Override
	public String toString() {
		return "song [id=" + id + ", name=" + name + ", set=" + set + "]";
	}
	
	
}

