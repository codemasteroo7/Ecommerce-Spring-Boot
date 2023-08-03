package com.ecommerce.major.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.major.model.OrderMaster;
import com.ecommerce.major.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findUserByEmail(String email);
	
	List<User>findAllByEmail(String email);
	
	User findById(int id);
	

	
}
