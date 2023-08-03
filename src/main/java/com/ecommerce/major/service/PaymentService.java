package com.ecommerce.major.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Service;

import com.ecommerce.major.model.Payment;
import com.ecommerce.major.repository.PaymentRepository;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	public void insertintoPayment(Payment payment)
	{
		paymentRepository.save(payment);
	}
	
	public List<Payment> getAllPayments()
	{
		return paymentRepository.findAll();
	}
	
	
}
