package com.unique;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name="t_emp")
public class Emp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;				//员工编号
	
	@Column
	private String name;		//员工名称
	
	@Column
	private String gender;		//员工性别
	
	@Column
	private Date birthday;		//员工出生日期
	
	@Column
	private float salary;		//员工薪水
	
	//@Column
	//private int deptid;
	
	/**
	 * 使用Emp员工关联部门
	 * */
	/**
	 * @ManyToOne注解：
	 * targetEntity属性对应的关联的目标类的类型
	 * 
	 * @JoinColumn用于指定当前类和关联类从数据库表的层面是哪一个列来维护/描述这种关联关系
	 * 这里的deptid就是t_emp的外键，对应的是关联的Dept对象的ID
	 * 
	 * CascadeType.SAVE_UPDATE 只针对部门是新建的情况下：当保存Emp的时候级联保存Dept。
	 * 同时，如果one放已经存在，但是做了更新操作，在保存Emp的时候，同样的会级联更新Dept;
	 * 
	 * fetch=FetchType.LAZY表示在查询Emp的不连接查询Dept;
	 * 当用户真正查询Dept的信息的时候才去查询Dept。
	 * 也就是说，现在是"延迟加载"/"懒加载"的效果
	 * 
	 * CascadeType.DELETE 表示级联删除。这个时候，在删除员工的时候，会同时把对应的部门也给 删除掉。
	 * 程序运行上完全没有问题，但是从逻辑上或者从程序设计上来讲，是完全不合理的：因为这个时候部门还有
	 * 其他员工。因此，我们要慎重选用"级联删除"。
	 * */
	@ManyToOne(targetEntity=Dept.class,fetch=FetchType.LAZY)
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	@JoinColumn(name="deptid")
	private Dept dept;			//员工所在部门
	
	public Emp() {
		super();
	}

	public Emp(String name, String gender, Date birthday, float salary, Dept dept) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
		this.dept = dept;
	}

	public Emp(int id, String name, String gender, Date birthday, float salary, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
		this.dept = dept;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
}
