package com.ecommerce.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.major.model.Ticket;
import com.ecommerce.major.model.User;
import com.mysql.cj.log.Log;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	
	@Query("select t from Ticket t where t.isActive='Y'")
	List<Ticket>getAllActiveTickets();
	
	
	@Query("update Ticket t set t.isActive='N' where t.ticketId=?1")
	@Modifying
	@Transactional
	void updateTicket(Long TicketId);
	
	
	
}
