package com.unique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookes")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String bookname;
	@Column
	private String price;
	@Column
	private int nums;
	
	
	public Book() {
		super();
	}
	public Book(String bookname, String price, int nums) {
		super();
		this.bookname = bookname;
		this.price = price;
		this.nums = nums;
	}
	public Book(int id, String bookname, String price, int nums) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.price = price;
		this.nums = nums;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", bookname=" + bookname + ", price=" + price + ", nums=" + nums + "]";
	}
	
	
	
}
