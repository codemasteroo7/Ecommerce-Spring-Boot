package com.ecommerce.major.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.major.global.GlobalData;
import com.ecommerce.major.model.OrderMaster;
import com.ecommerce.major.model.Orders;
import com.ecommerce.major.model.Product;
import com.ecommerce.major.model.User;
import com.ecommerce.major.service.OrderService;
import com.ecommerce.major.service.OrdersService;

@Controller
public class OrderController {

	@Autowired
	private OrdersService ordersService;
	
/*	@PostMapping("/checkout/order")
	public String ordermaster(@ModelAttribute OrderMaster o)
	{
		
			
			System.out.println("Start of method ordermaster");
			
			o.setTotal((int)GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
			o.setQuantity(GlobalData.cart.size());
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username;
//			if (principal instanceof User) {
//				   username = ((User)principal).getUsername();
//				} else {
//				   username = principal.toString();
//				}
//			System.out.println(username);
			System.out.println(o);
			orderService.addOrder(o);
			return "orderPlaced2";
	}  this is backup code */
	
	@PostMapping("/checkout/order")
	public String ordermaster(@ModelAttribute Orders o)
	{
		
			
			System.out.println("Start of method ordermaster");
			
			o.setTotal((int)GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
			o.setQuantity(GlobalData.cart.size());
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username;
//			if (principal instanceof User) {
//				   username = ((User)principal).getUsername();
//				} else {
//				   username = principal.toString();
//				}
//			System.out.println(username);
			System.out.println(o);
			ordersService.addOrder(o);
			return "orderPlaced2";
	}
}
