package com.ecommerce.major.dto;

import com.ecommerce.major.model.User;

import lombok.Data;

@Data
public class OrderDTO {
	
	private Long id;	
	private int userid;
	private int quantity;
	private int total;
	private String firstname;
	
	private String lastname;
	
	private String address1;
	
	private String address2;
	
	private int pincode;
	
	private String city;
	
	private long phone;
	
	private String email;
	
	private String addinfo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddinfo() {
		return addinfo;
	}
	public void setAddinfo(String addinfo) {
		this.addinfo = addinfo;
	}
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", userid=" + userid + ", quantity=" + quantity + ", total=" + total
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", address1=" + address1 + ", address2="
				+ address2 + ", pincode=" + pincode + ", city=" + city + ", phone=" + phone + ", email=" + email
				+ ", addinfo=" + addinfo + "]";
	}
		
	
}
