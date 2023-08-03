package com.ecommerce.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.major.model.OrderMaster;
import com.ecommerce.major.model.Product;
import com.ecommerce.major.model.User;

public interface OrderRepository extends JpaRepository<OrderMaster, Long>{

	
//	@Query("Select o from OrderMaster o JOIN o.userid u WHERE u.id=:id")
//	List<OrderMaster>getAllByUserid(@Param("id") int id);
	
//	List<OrderMaster>findAllByUserid(User user);

//	List<OrderMaster>findAllByUser_Id(int id);	
	
	List<OrderMaster>findAllByUseridId(int id);
	
	List<OrderMaster>findAllByEmail(String email);
	
//	@Query(value = "select max(id) from Orders")
//	public Long max();
}
