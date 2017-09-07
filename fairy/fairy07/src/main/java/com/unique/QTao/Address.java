package com.unique.QTao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column
	private String provice;
	@Column
	private String eare;
	@Column
	private String street;
	
	
	public Address(String provice, String eare, String street) {
		super();
		this.provice = provice;
		this.eare = eare;
		this.street = street;
	}
	public Address() {
		super();
	}
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	public String getEare() {
		return eare;
	}
	public void setEare(String eare) {
		this.eare = eare;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [provice=" + provice + ", eare=" + eare + ", street=" + street + "]";
	}
	
	
}
