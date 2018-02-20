package com.app.proj.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.proj.backend.entity.Payment;

/**
 * @author HsuWaiWaiTun
 *
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer>{
	
	public Payment findByPaymentId(Integer paymentId);
	public Payment findByPaymentType(String paymentType);

}
