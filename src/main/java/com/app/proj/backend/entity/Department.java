package com.app.proj.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * @author HsuWaiWaiTun
 *
 */
@Entity
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="deptId", unique=true, nullable = false)
	private int deptId;
	
	@NotNull
	@Column
	private String deptName;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy= "department",cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(value = FetchMode.SELECT)
	private List<Employee> employeeList = new ArrayList<Employee>();

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String deptName, String description, List<Employee> employeeList) {
		super();
		this.deptName = deptName;
		this.description = description;
		this.employeeList = employeeList;
	}

	public Department(String deptName, String description) {
		super();
		this.deptName = deptName;
		this.description = description;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", description=" + description
				+ "]";
	}


	
}
