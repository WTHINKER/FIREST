package com.unique;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ListIndexBase;

@SuppressWarnings("deprecation")
@Entity
@Table(name="s_singer")
public class Singer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@OneToMany(targetEntity=Songs.class,mappedBy="singer")
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@OrderColumn(name="songsno")
	@ListIndexBase(value=0)
	private List<Songs>list;
	
	
	public Singer() {
		super();
	}
	public Singer(int id, String name, List<Songs> list) {
		super();
		this.id = id;
		this.name = name;
		this.list = list;
	}
	public Singer(String name) {
		super();
		this.name = name;
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
	public List<Songs> getList() {
		return list;
	}
	public void setList(List<Songs> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Singer [id=" + id + ", name=" + name + ", list=" + list + "]";
	}
	
	
}
