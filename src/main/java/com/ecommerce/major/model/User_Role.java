package com.ecommerce.major.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.boot.model.naming.ImplicitNameSource;

import lombok.Data;

@Entity
@Data
public class User_Role {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	int id;
	int role_id;
	int user_id;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
