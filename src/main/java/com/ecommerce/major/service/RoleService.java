package com.ecommerce.major.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.major.model.Role;
import com.ecommerce.major.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> getAllRoles()
	{
		return roleRepository.findAll();
	}
}
