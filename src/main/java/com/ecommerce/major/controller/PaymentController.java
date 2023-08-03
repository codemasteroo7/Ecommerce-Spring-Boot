package com.ecommerce.major.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.major.global.GlobalData;
import com.ecommerce.major.model.OrderLineItem;
import com.ecommerce.major.model.Orders;
import com.ecommerce.major.model.Payment;
import com.ecommerce.major.model.PaytmDetails;
import com.ecommerce.major.model.Product;
import com.ecommerce.major.model.User;
import com.ecommerce.major.repository.OrderLineItemRepository;
import com.ecommerce.major.service.OrderLineItemService;
import com.ecommerce.major.service.OrdersService;
import com.ecommerce.major.service.PaymentService;
import com.ecommerce.major.service.UserService;
import com.paytm.pg.merchant.PaytmChecksum;

@Controller
public class PaymentController {
	
	@Autowired
	private PaytmDetails paytmDetails;
	
	@Autowired
	private Environment env;

	@Autowired
	OrdersService ordersService;
	
	@Autowired
	OrderLineItemService orderLineItemService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PaymentService paymentService;
	
	Payment payment=new Payment();
	
	@GetMapping("/payment")
	public String home() {
		return "Payment";
	}
	
	/* @PostMapping(value = "/pgredirect")
	    public ModelAndView getRedirect(@RequestParam(name = "CUST_ID") String customerId,
	                                    @RequestParam(name = "TXN_AMOUNT") String transactionAmount,
	                                    @RequestParam(name = "ORDER_ID") String orderId) throws Exception {

		 	ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetails.getPaytmUrl());
	        TreeMap<String, String> parameters = new TreeMap<>();
	        paytmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
	        parameters.put("MOBILE_NO", "8329191455");
	        parameters.put("EMAIL", "cshubham8262@gmail.com");
	        parameters.put("ORDER_ID", orderId);
	        parameters.put("TXN_AMOUNT", transactionAmount);
	        parameters.put("CUST_ID", customerId);
	        String checkSum = getCheckSum(parameters);
	        parameters.put("CHECKSUMHASH", checkSum);
	        modelAndView.addAllObjects(parameters);
	        return modelAndView;
	    } */
	
	@PostMapping(value = "/pgredirect")
    public ModelAndView getRedirect(@ModelAttribute Orders o) throws Exception {

	 	ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetails.getPaytmUrl());
        TreeMap<String, String> parameters = new TreeMap<>();
        payment=new Payment();
        paytmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
        o.setTotal((int)GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		o.setQuantity(GlobalData.cart.size());
		
//		LocalDate dateObj = LocalDate.now();
//	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date();
	    Date date2= new Timestamp(date.getTime());
	    
	    o.setDate(date2);
		
		String email= userService.getUserName();
		System.out.println("email="+ email);
		User user=userService.getUserByEmail(email);
		
		o.setUserid(user);
		ordersService.addOrder(o);
		long orderid=ordersService.getMaxId();
        parameters.put("MOBILE_NO", "8329191455");
        parameters.put("EMAIL", "cshubham8262@gmail.com");
        parameters.put("ORDER_ID", orderid + "");
        parameters.put("TXN_AMOUNT", o.getTotal()+"");
        parameters.put("CUST_ID",user.getId() + "");
        String checkSum = getCheckSum(parameters);
        parameters.put("CHECKSUMHASH", checkSum);
        modelAndView.addAllObjects(parameters);
        
        for(Product prod:GlobalData.cart)
        {
        	OrderLineItem orderLineItem=new OrderLineItem();
        	orderLineItem.setOrderid(orderid);
        	orderLineItem.setProductId(prod.getId());
        	orderLineItem.setProductName(prod.getName());
        	orderLineItemService.insertOrderDetials(orderLineItem);
        }
        GlobalData.cart.clear();
       
//        System.out.println(o);
//		ordersService.addOrder(o);
        
        /*
         * for payment table 
         */
        
        payment.setAmount(o.getTotal());
        payment.setCustomerId(user.getId());
        payment.setCutomerName(user.getFirstName() + " " + user.getLastName());
        payment.setOrderId(orderid);
        payment.setDate(date2);
       
//        payment.setTransactionId();
//        
//        paymentService.insertintoPayment(payment);
        return modelAndView;
    }
	 
	 @PostMapping(value = "/pgresponse")
	    public String getResponseRedirect(HttpServletRequest request, Model model) {

	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        mapData.forEach((key, val) -> parameters.put(key, val[0]));
	        String paytmChecksum = "";
	        if (mapData.containsKey("CHECKSUMHASH")) {
	            paytmChecksum = mapData.get("CHECKSUMHASH")[0];
	        }
	        String result;

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Payment Successful";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        model.addAttribute("parameters",parameters);
	        
	        payment.setTransactionId(parameters.get("TXNID"));
	        
	        System.out.println("transaction id" + parameters.get("TXNID"));
	        
	        paymentService.insertintoPayment(payment);
	        
	        
	        return "report";
	    }
	 
	 private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		 
		 
		 	return PaytmChecksum.generateSignature(parameters, paytmDetails.getMerchantKey());
		 	
//			return CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(paytmDetails.getMerchantKey(), parameters);
			
		}
	 
	 private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		
		 
		 
		 
//	        return CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(paytmDetails.getMerchantKey(),
//	                parameters, paytmChecksum);
	        
	     return    PaytmChecksum.verifySignature(parameters, paytmDetails.getMerchantKey(), paytmChecksum);
	        
	    }

}
