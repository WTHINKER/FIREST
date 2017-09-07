package com.unique.onetoone2;

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

@Entity
@Table(name = "t_certifacation")
public class Certification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String certificationid;

	/**
	 * 相对于IdCard使用主键作为外键而言，Certification单独声明了一个外键列：personid
	 * 另外，这里使用了unique约束，代表该外键列的值是不可重复的。 也就是说，每一个Certification身份证号只对应一个Person
	 * 或者在每一个Person只对应一个Certification。 还有要注意：现在使用的@ManyToOne注解，而不是@OneToOne。
	 */
	@ManyToOne(targetEntity = Person.class,fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	@JoinColumn(name = "sid", unique = true)
	private Person person;

	public Certification() {
		super();
	}

	public Certification(String certificationid) {
		super();
		this.certificationid = certificationid;
	}

	public Certification(int id, String certificationid, Person person) {
		super();
		this.id = id;
		this.certificationid = certificationid;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCertificationid() {
		return certificationid;
	}

	public void setCertificationid(String certificationid) {
		this.certificationid = certificationid;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
