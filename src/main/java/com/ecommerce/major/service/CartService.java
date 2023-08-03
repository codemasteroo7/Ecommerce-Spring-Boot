package com.ecommerce.major.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.major.model.Cart;
import com.ecommerce.major.model.Product;
import com.ecommerce.major.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	public List<Cart> getAllCart()
	{
		return cartRepository.findAll();
	}
	public void addToCart(Cart cart)
	{
		
		cartRepository.save(cart);
	}
	
	public static void main(String [] args)
	{
		
		CartService obj=new CartService();
		Cart cart=new Cart();
		
		
	}
	
}
