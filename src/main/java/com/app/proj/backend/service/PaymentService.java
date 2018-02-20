package com.app.proj.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.proj.backend.entity.Payment;
import com.app.proj.backend.repositories.PaymentRepository;

/**
 * @author HsuWaiWaiTun
 *
 */

@Service("paymentService")
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public List<Payment> findAllPayment(){
		return (List<Payment>) paymentRepository.findAll();
	}
	
	public Payment addPayment(Payment payment){
		return paymentRepository.save(payment);
	}
	
	public Payment updatePayment(Payment payment){
		return paymentRepository.save(payment);
	}
	
	public void deletePayment(int id){
		paymentRepository.delete(id);
	}
	
	public Payment findByPaymentId(int paymentId){
		return paymentRepository.findByPaymentId(paymentId);
	}
	
	public Payment findByPaymentType(String type){
		return paymentRepository.findByPaymentType(type);
	}
}
