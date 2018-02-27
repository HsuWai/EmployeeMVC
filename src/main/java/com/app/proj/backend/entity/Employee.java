package com.app.proj.backend.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;


/**
 * @author HsuWaiWaiTun
 *
 */
@Entity
@Audited
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique=true, nullable = false)
	private Long id;
	
	@NotNull
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	@Column
	private int age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private Department department;
	
	@OneToOne
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private Status status;
	
	@OneToOne
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private Payment payment;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(value = FetchMode.SELECT)
	@JoinColumn(name= "salaryId")
	private Salary salary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String email, String address, int age) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.age = age;
	}

	public Employee(Long id, String name, String email, String address, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.age = age;
	}

	public Employee(String name, String email, String address, int age, Department department) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.age = age;
		this.department = department;
	}
	
	public Employee(String name, String email, String address, int age, Department department, Status status,
			Payment payment) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.age = age;
		this.department = department;
		this.status = status;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", age=" + age
				+ ", department=" + department + ", status=" + status + ", payment=" + payment + ", salary=" + salary
				+ "]";
	}

}
