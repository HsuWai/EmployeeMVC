package com.app.proj.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author HsuWaiWaiTun
 *
 */

@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="status_id", unique=true, nullable= false)
	private Integer statusId;
	
	@Column
	private String statusName;

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Status(Integer statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public Status(String statusName) {
		super();
		this.statusName = statusName;
	}
	
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusName=" + statusName + "]";
	}

}
