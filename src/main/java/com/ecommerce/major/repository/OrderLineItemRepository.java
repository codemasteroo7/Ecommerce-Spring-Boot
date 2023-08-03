package com.ecommerce.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.major.model.OrderLineItem;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long>{

	List<OrderLineItem> findAllByOrderid(long id);
	
}
