package com.ecommerce.major.controller;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.reflect.ReflectionFastMatchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.firewall.HttpStatusRequestRejectedHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.major.dto.OrderDTO;
import com.ecommerce.major.global.GlobalData;
import com.ecommerce.major.model.Cart;
import com.ecommerce.major.model.Orders;
import com.ecommerce.major.model.Product;
import com.ecommerce.major.model.User;
import com.ecommerce.major.service.CartService;
import com.ecommerce.major.service.ProductService;
import com.ecommerce.major.service.UserService;

@Controller
public class CartController {

		@Autowired
		ProductService productService;
		
		@Autowired
		CartService cartService;
		
		@Autowired
		UserService userService;
		
		
		
		@GetMapping("/addToCart/{id}")
		public String addToCart(@PathVariable int id)
		{
			try
			{
			System.out.println("start of add to cart");
			GlobalData.cart.add(productService.getProductById(id).get());
			
//			CartService cartService=new CartService();
			
			User user=new User();
//			user.setId(1);
			
			Cart cart=new Cart();
			cart.setProduct(productService.getProductById(id).get());
			cart.setQuantity(5);
			cart.setUser(user);
			System.out.println("everything is fine till here");
//			cartService.addToCart(cart);
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof UserDetails) {
			  String username = ((UserDetails)principal).getUsername();
			  System.out.println("username is" + username);
			} else {
			  String username = principal.toString();
			  System.out.println("username is" + username);
			}
			
			System.out.println("end of add to cart");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "redirect:/shop";
		}
		
		@GetMapping("/cart")
		public String cartGet(Model model)
		{
			model.addAttribute("cartCount", GlobalData.cart.size());
			model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
			model.addAttribute("cart", GlobalData.cart);
			
			/**
			 * below code is added for the testing purpose
			 */
			List<Product> products=GlobalData.cart;
			System.out.println("BEFORE THE CART ADDED CODE");
			for(Product prod:products)
			{
				System.out.println(prod.getName());
			}
			return "cart";
		}
		

		@GetMapping("/cart/removeItem/{index}")
		public String cartItemRemove(@PathVariable int index)
		{
			GlobalData.cart.remove(index);
			return "redirect:/cart";
		}
		
		@GetMapping("/checkout")
		public String checkout(Model model)
		{
			model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
			List<Product> products=GlobalData.cart;
			System.out.println("BEFORE THE checkout ADDED CODE");
			for(Product prod:products)
			{
				System.out.println(prod.getName());
			}
			
			String email=userService.getUserName();
			User user=userService.getUserByEmail(email);
			
			OrderDTO orderDTO=new OrderDTO();
			orderDTO.setFirstname(user.getFirstName());
			orderDTO.setLastname(user.getLastName());
			orderDTO.setEmail(user.getEmail());
			
			model.addAttribute("orderDTO", orderDTO);
			
			
			
			
			return "checkout";
		}
		
}
