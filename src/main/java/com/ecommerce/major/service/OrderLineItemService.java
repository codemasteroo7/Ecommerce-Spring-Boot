package com.ecommerce.major.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.major.model.OrderLineItem;
import com.ecommerce.major.repository.OrderLineItemRepository;

@Service
public class OrderLineItemService {

	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	
	
	
	public void insertOrderDetials(OrderLineItem orderLineItem)
	{
		System.out.println("start of the insertOrderDetials");
		System.out.println(orderLineItem);
		orderLineItemRepository.save(orderLineItem);
	}
	
	public List<OrderLineItem> getDetailsByOrderId(long orderId)
	{
		return orderLineItemRepository.findAllByOrderid(orderId);
	}
}
