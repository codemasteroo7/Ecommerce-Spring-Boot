package com.ecommerce.major.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;

@Entity 
@Data
public class Ticket {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ticketId;
	
	private long orderID;
	
	private String description;
	
	private String isActive;
	
	private String pendingWith;
	
	private int pendingWithId;

	
	public int getPendingWithId() {
		return pendingWithId;
	}

	public void setPendingWithId(int pendingWithId) {
		this.pendingWithId = pendingWithId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getPendingWith() {
		return pendingWith;
	}

	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}
	
	
	
	
	
	

}
