package com.ecommerce.major.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Cart{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="category_id" , referencedColumnName="category_id")
//	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id" , referencedColumnName="id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id" , referencedColumnName="id")
	private User user;
	
	private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

	
	
	
}
