package com.ecommerce.major.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import com.ecommerce.major.model.Category;
import com.ecommerce.major.model.OrderMaster;
import com.ecommerce.major.model.Product;
import com.ecommerce.major.model.User;
import com.ecommerce.major.repository.OrderRepository;
import com.google.gson.Gson;

@Service
public class OrderService {

	@Autowired
	private static SessionFactory factory; 
	  
	
	@Autowired
	OrderRepository orderRepository;
	public List<OrderMaster> getAllOrder()
	{
		return orderRepository.findAll();
	}
	
	public void addOrder(OrderMaster orderMaster)
	{
		orderRepository.save(orderMaster);
	}
	
	
	
	public List<OrderMaster> getAllOrdersByUserId(String email)
	{
		
		List<OrderMaster> findAllByEmail = orderRepository.findAllByEmail(email);
		
		for(OrderMaster o:findAllByEmail)
		{
			System.out.println(o.getFirstname());
			System.out.println(o.getLastname());
		}
		
		return orderRepository.findAllByEmail(email);
	}
	
//	public List<OrderMaster> getAllOrdersByUserId(int id)
//	{
//		System.out.println("start of getAllOrdersByUserId");
//		
//		
//		 Session session = factory.openSession();
//		 
//	      Transaction tx = null;
//	      List<OrderMaster> orderMasterlist=new ArrayList<OrderMaster>();
//	      
//	      try
//	      {
//	    	  tx = session.beginTransaction();
//	    	  String sql = "SELECT firstname, lastname FROM order_master";
//	          SQLQuery query = session.createSQLQuery(sql);
//	          query.addEntity(OrderMaster.class);
//	          List obj = query.list();
//	          
//	          for (Iterator iterator = obj.iterator(); iterator.hasNext();){
//	        	  OrderMaster ordermaster = (OrderMaster) iterator.next(); 
//	        	  orderMasterlist.add(ordermaster);
//	             
//	           }
//	          
//	      }
//	      catch(Exception e)
//	      {
//	    	  e.printStackTrace();
//	      }
//	      return orderMasterlist;
//	      
//	}
	
//	public static void main(String [] args)
//	{
//		System.out.println("start of main method ");
//		OrderService obj= new OrderService();
//		Gson gson=new Gson();
//		System.out.println(gson.toJson(obj.getAllOrdersByUserId(1)));
//		
//	}

}
