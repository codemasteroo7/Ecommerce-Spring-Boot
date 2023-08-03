package com.ecommerce.major.model;

import java.util.Date;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.internal.constraintvalidators.bv.money.CurrencyValidatorForMonetaryAmount;

import lombok.Data;

@Entity
@Data
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	
	private String cutomerName;
	
	private long customerId;
	
	private long orderId;
	
	private int Amount;
	
	private String transactionId;
	
	private Date date;

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getCutomerName() {
		return cutomerName;
	}

	public void setCutomerName(String cutomerName) {
		this.cutomerName = cutomerName;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
	
	
}
