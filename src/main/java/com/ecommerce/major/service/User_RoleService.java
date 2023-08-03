package com.ecommerce.major.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Service;

import com.ecommerce.major.model.User_Role;
import com.ecommerce.major.repository.User_RoleRepository;

@Service
public class User_RoleService {
	
	@Autowired
	User_RoleRepository userroleRepository;
	
	public void insertintoUserRole(User_Role user_Role) 
	{
		userroleRepository.save(user_Role);
	}
	
}
