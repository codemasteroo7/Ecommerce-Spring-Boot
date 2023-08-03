//issue can be in private RedirectStrategy redirectStrategy=new RedirectStrategy() {
	
package com.ecommerce.major.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.http.client.RedirectStrategy;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.ecommerce.major.model.Role;
import com.ecommerce.major.model.User;
import com.ecommerce.major.repository.RoleRepository;
import com.ecommerce.major.repository.UserRepository;

@Component //because this is a class

public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;
	
	
//	private RedirectStrategy redirectStrategy= new DefaultRedirectStrategy();
	private RedirectStrategy redirectStrategy=new RedirectStrategy() {
		
		@Override
		public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
			// TODO Auto-generated method stub
			
		}
	};
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
	OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
	String email=token.getPrincipal().getAttributes().get("email").toString();   // here we extract email from the token 
	if(!userRepository.findUserByEmail(email).isPresent())
	{
		User user = new User();
		user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());    //gets first name 
		user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());  // gets surname
		user.setEmail(email);
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findById(2).get());  // because 2 is being decided for the user role
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	redirectStrategy.sendRedirect(request,response, "/");	
	}
}
//client id = 764469694080-83h6salj0a0hj72ohq0hqdlt8l2j8etj.apps.googleusercontent.com
//client secret = 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
