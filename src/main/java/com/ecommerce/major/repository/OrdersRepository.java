package com.ecommerce.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.major.model.OrderMaster;
import com.ecommerce.major.model.Orders;
import com.ecommerce.major.model.User;

public interface OrdersRepository extends JpaRepository<Orders, Long>{
	
	List<Orders>findAllByEmail(String email);

	@Query(value = "select max(id) from Orders")
	public long max();
	
	List<Orders>findAllByUserid(User id);
}
