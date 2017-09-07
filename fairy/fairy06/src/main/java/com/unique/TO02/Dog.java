package com.unique.TO02;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="dog")
public class Dog extends Animal {

	@Column
	private String dogtitile;

	public Dog(String name, int age, String dogtitile) {
		super(name, age);
		this.dogtitile = dogtitile;
	}

	public Dog() {
		super();
	}

	public String getDogtitile() {
		return dogtitile;
	}

	public void setDogtitile(String dogtitile) {
		this.dogtitile = dogtitile;
	}

	@Override
	public String toString() {
		return "Dog [dogtitile=" + dogtitile + "]";
	}

}
