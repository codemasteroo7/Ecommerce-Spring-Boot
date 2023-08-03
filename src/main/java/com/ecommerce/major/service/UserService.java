package com.ecommerce.major.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ecommerce.major.model.Product;
import com.ecommerce.major.model.User;
import com.ecommerce.major.repository.UserRepository;

import net.bytebuddy.asm.Advice.Return;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	public User getUserByEmail(String email)
	{
		List<User>userList= userRepository.findAllByEmail(email);
		return userList.get(0);
	}
	
	public String getUserName()
	{
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		  System.out.println("username is" + username);
		} else {
		   username = principal.toString();
		  System.out.println("username is" + username);
		}
		return username;
	}
	
	public User getUserById(long id)
	{
		return  userRepository.findById((int)id);
	}
}
