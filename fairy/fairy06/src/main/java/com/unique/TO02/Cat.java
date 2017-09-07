package com.unique.TO02;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="cat")
public class Cat extends Animal {

	@Column
	private String cattitle;

	public Cat(String name, int age, String cattitle) {
		super(name, age);
		this.cattitle = cattitle;
	}

	public Cat() {
		super();
	}

	public String getCattitle() {
		return cattitle;
	}

	public void setCattitle(String cattitle) {
		this.cattitle = cattitle;
	}

	@Override
	public String toString() {
		return "Cat [cattitle=" + cattitle + "]";
	}

}
