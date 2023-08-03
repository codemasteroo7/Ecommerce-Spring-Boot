package com.ecommerce.major.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.major.dto.OrderDTO;
import com.ecommerce.major.dto.ProductDTO;
import com.ecommerce.major.global.GlobalData;
import com.ecommerce.major.model.Orders;
import com.ecommerce.major.model.Product;
import com.ecommerce.major.model.Ticket;
import com.ecommerce.major.model.User;
import com.ecommerce.major.service.OrdersService;
import com.ecommerce.major.service.TicketService;
import com.ecommerce.major.service.UserService;

@Controller	
public class TicketController {
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired 
	TicketService ticketService;
	
	@Autowired
	UserService userService;
	

	@GetMapping("/raiseTicket")
	public String raiseTicketpage(Model model)
	{
		
		String email= userService.getUserName();
		
		
		model.addAttribute("ticketDTO" , new Ticket());
		model.addAttribute("orders",ordersService.getAllOrdersByUserId(email));
		
		return "raiseticket";
	}
	
	
	@PostMapping(value = "/submitTicket")
    public String submitTicket(@ModelAttribute Ticket t) throws Exception {
		
		System.out.println("start of method submitTicket");
		t.setIsActive("Y");
		t.setPendingWith("pool");
	
		ticketService.insertintoTicket(t);
		
		return "index";
	}
	
	@GetMapping("/support")
	public String adminHome()
	{
		
		return "supportHome";
	}
	
	@GetMapping("/support/activeTickets")
	public String getActiveTickets(Model model)
	{
		
		List<Ticket> allActiveTickets = ticketService.getAllActiveTickets();
		for (Iterator iterator = allActiveTickets.iterator(); iterator.hasNext();) {
			Ticket ticket = (Ticket) iterator.next();
			System.out.println("1");
		}
		model.addAttribute("customers",allActiveTickets);
		
		return "activeTickets";
	}
	
	@GetMapping("/support/activeTickets/markInActive/{id}")
	public String markTicketsActive(@PathVariable int id,Model model) throws Exception
	{
		
		System.out.println("start of method markTicketsActive");
		
		ticketService.markTicketInactive(id);
		List<Ticket> allActiveTickets = ticketService.getAllActiveTickets();
		for (Iterator iterator = allActiveTickets.iterator(); iterator.hasNext();) {
			Ticket ticket = (Ticket) iterator.next();
			System.out.println("1");
		}
		
		
		model.addAttribute("customers",allActiveTickets);
		
		return "activeTickets";
	}
	
	
	
}
