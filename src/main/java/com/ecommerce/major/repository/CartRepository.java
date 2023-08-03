package com.ecommerce.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.major.model.Cart;
import com.ecommerce.major.model.Product;

public interface CartRepository extends JpaRepository <Cart,Long>{
	
	

}
