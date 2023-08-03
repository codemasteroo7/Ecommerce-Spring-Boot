package com.ecommerce.major.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.ecommerce.major.model.Ticket;
import com.ecommerce.major.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	public void insertintoTicket(Ticket ticket)
	{
		ticketRepository.save(ticket);
	}
	
	public List<Ticket> getAllTickets()
	{
		return ticketRepository.findAll();
	}
	
	public List<Ticket> getAllActiveTickets()
	{
		System.out.println(ticketRepository.getAllActiveTickets());
		return ticketRepository.getAllActiveTickets();
		
	}
	
	public void markTicketInactive(long ticketId)
	{
		ticketRepository.updateTicket(ticketId);
	}
}
