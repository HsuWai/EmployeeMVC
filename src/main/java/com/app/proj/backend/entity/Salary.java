package com.app.proj.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

/**
 * @author HsuWaiWaiTun
 *
 */

@Entity
@Audited
public class Salary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="salaryId", unique=true, nullable = false)
	private Long salaryId;
	
	@Column
	private Double salaryBasic;
	
	@Column(nullable = true)
	private Double salaryOvertime;
	
	@Column(nullable = true)
	private Double allowance;
	
	@Column(nullable = true)
	private int workingDays;
	
	@Column(nullable = true)
	private int workingHours;
	
	@Column
	private Double totalSalary;

	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salary(Double salaryBasic, Double salaryOvertime, Double allowance) {
		super();
		this.salaryBasic = salaryBasic;
		this.salaryOvertime = salaryOvertime;
		this.allowance = allowance;
	}

	public Long getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Long salaryId) {
		this.salaryId = salaryId;
	}

	public Double getSalaryBasic() {
		return salaryBasic;
	}

	public void setSalaryBasic(Double salaryBasic) {
		this.salaryBasic = salaryBasic;
	}

	public Double getSalaryOvertime() {
		return salaryOvertime;
	}

	public void setSalaryOvertime(Double salaryOvertime) {
		this.salaryOvertime = salaryOvertime;
	}

	public Double getAllowance() {
		return allowance;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public int getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public Double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(Double totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", salaryBasic=" + salaryBasic + ", salaryOvertime=" + salaryOvertime
				+ ", allowance=" + allowance + ", workingDays=" + workingDays + ", workingHours=" + workingHours
				+ ", totalSalary=" + totalSalary + "]";
	}

}
