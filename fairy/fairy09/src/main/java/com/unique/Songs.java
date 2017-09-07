package com.unique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="s_songs")
public class Songs {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int Salesvolume;//销售量
	@ManyToOne(targetEntity=Singer.class,fetch=FetchType.LAZY)
	@JoinColumn(name="singerno")
	private Singer singer;
	
	
	public Songs() {
		super();
	}
	public Songs(int id, String name, int salesvolume, Singer singer) {
		super();
		this.id = id;
		this.name = name;
		Salesvolume = salesvolume;
		this.singer = singer;
	}
	public Songs(String name, int salesvolume, Singer singer) {
		super();
		this.name = name;
		Salesvolume = salesvolume;
		this.singer = singer;
	}
	public Songs(String name, Singer singer) {
		super();
		this.name = name;
		this.singer = singer;
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
	public int getSalesvolume() {
		return Salesvolume;
	}
	public void setSalesvolume(int salesvolume) {
		Salesvolume = salesvolume;
	}
	public Singer getSinger() {
		return singer;
	}
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "Songs [id=" + id + ", name=" + name + ", Salesvolume=" + Salesvolume + ", singer=" + singer + "]";
	}
	
	
}
