package com.ecommerce.major.dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ecommerce.major.model.Product;
import com.ecommerce.major.model.User;

import lombok.Data;

@Data
public class CartDTO {
	
private Long id;
private int productId;
private User userId;
private int quantity;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public User getUserId() {
	return userId;
}
public void setUserId(User userId) {
	this.userId = userId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "CartDTO [id=" + id + ", productId=" + productId + ", userId=" + userId + ", quantity=" + quantity + "]";
}





	
}
