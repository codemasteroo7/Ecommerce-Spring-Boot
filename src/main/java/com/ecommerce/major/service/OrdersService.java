package com.ecommerce.major.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Service;

import com.ecommerce.major.model.OrderMaster;
import com.ecommerce.major.model.Orders;
import com.ecommerce.major.model.User;
import com.ecommerce.major.repository.OrderRepository;
import com.ecommerce.major.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository orderRepository;
	public List<Orders> getAllOrder()
	{
		return orderRepository.findAll();
	}
	
	public void addOrder(Orders orderMaster)
	{
		orderRepository.save(orderMaster);
	}
	
	
	
	public List<Orders> getAllOrdersByUserId(String email)
	{
		
		List<Orders> findAllByEmail = orderRepository.findAllByEmail(email);
		
		for(Orders o:findAllByEmail)
		{
			System.out.println(o.getFirstname());
			System.out.println(o.getLastname());
		}
		
		return orderRepository.findAllByEmail(email);
	}
	
	public List<Orders> getAllOrdersById(User id)
	{
		System.out.println("id in service:" + id);
		return orderRepository.findAllByUserid(id);
	}
	
	public long getMaxId() 
	{
		return orderRepository.max();
	}
}
