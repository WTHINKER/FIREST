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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
/**
 * 如果没有指定region,会自动放到默认的二级缓存中
 * 如果指定了的话，就放到指定的二级缓存中
 * */
@Entity
@Table(name="t_dept")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="mCache")
public class Dept {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;  			//部门编号
	
	@Column
	private String name;		//部门名称
	
	@Column
	private String city;  		//所在城市

	/**
	 * 使用部门关联
	 * 
	 * 如果有一个Emp从Set中移除了，那么该Emp就变为孤儿。
	 * 如果想要在删除One方(Dept)的时候，想把孤儿也给级联删除掉，那么可以设置
	 * CascadeType.DELETE_ORPHAN  但是当前Hibernate版本不推荐使用这种方式(但是还是可以使用)，
	 * 推荐使用OneToMany注解的orphanRemoval属性。
	 * 
	 * */
	@OneToMany(targetEntity=Emp.class,fetch=FetchType.LAZY,orphanRemoval=true)
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE,CascadeType.DELETE_ORPHAN})
	@JoinColumn(name="deptid")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Emp> empSet=new HashSet<Emp>();
	
	public Dept() {
		super();
	}

	public Dept(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Dept(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Emp> getEmpSet() {
		return empSet;
	}

	public void setEmpSet(Set<Emp> empSet) {
		this.empSet = empSet;
	}
	
}
