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
@Table(name="singer")
public class Singer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int sid;
	@Column
	private String sname;
	@Column
	private String sex;
	@Column
	private int sage;
	
	@ManyToMany(targetEntity=Song.class,fetch=FetchType.LAZY)
	@JoinTable(name="relation",joinColumns= {@JoinColumn(name="singerid")},inverseJoinColumns= {@JoinColumn(name="songid")})
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	private Set<Song> set = new HashSet<Song>();
	
	
	public Singer() {
		super();
	}


	public Singer(String sname, String sex, int sage) {
		super();
		this.sname = sname;
		this.sex = sex;
		this.sage = sage;
	}


	public Singer(int sid, String sname, String sex, int sage) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.sage = sage;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getSage() {
		return sage;
	}


	public void setSage(int sage) {
		this.sage = sage;
	}


	public Set<Song> getSet() {
		return set;
	}


	public void setSet(Set<Song> set) {
		this.set = set;
	}


	@Override
	public String toString() {
		return "singer [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", sage=" + sage + "]";
	}
	
	
}
