package com.app.proj.backend.entity;

import java.io.Serializable;

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
public class Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue ( strategy =  GenerationType.AUTO)
	@Column(name= "payment_id", nullable= false)
	private Integer paymentId;
	
	@Column
	private String paymentType;
	
	@Column
	private Double paymentRate;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Integer paymentId, String paymentType) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
	}

	public Payment(String paymentType, Double paymentRate) {
		super();
		this.paymentType = paymentType;
		this.paymentRate = paymentRate;
	}

	public Payment(String paymentType) {
		super();
		this.paymentType = paymentType;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Double getPaymentRate() {
		return paymentRate;
	}

	public void setPaymentRate(Double paymentRate) {
		this.paymentRate = paymentRate;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentType=" + paymentType + ", paymentRate=" + paymentRate
				+ "]";
	}

	
}
