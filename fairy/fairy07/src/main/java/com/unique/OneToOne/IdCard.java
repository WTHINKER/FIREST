package com.unique.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="informtion_id")
public class IdCard {

	@Id
	@GeneratedValue(generator="native")
	@GenericGenerator(name="native",strategy="foreign",parameters= {@Parameter(name="property",value="people")})
	private int id;
	@Column
	private int idcrad;
	
	@OneToOne(targetEntity=People.class)
	@JoinColumn(name="id")
	private People people;

	public IdCard(int id, int idcrad, People people) {
		super();
		this.id = id;
		this.idcrad = idcrad;
		this.people = people;
	}

	public IdCard(int idcrad, People people) {
		super();
		this.idcrad = idcrad;
		this.people = people;
	}
	
	

	public IdCard(int idcrad) {
		super();
		this.idcrad = idcrad;
	}

	public IdCard() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdcrad() {
		return idcrad;
	}

	public void setIdcrad(int idcrad) {
		this.idcrad = idcrad;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "Idcard [id=" + id + ", idcrad=" + idcrad + ", people=" + people + "]";
	}
	
	
	
}
