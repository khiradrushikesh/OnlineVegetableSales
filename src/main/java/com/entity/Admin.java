package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Admin")
public class Admin {
	
	@Id
	@GeneratedValue
	
	private int admin_id;
	@NotEmpty(message = "User Name should not be emtpy!")
	private String admin_name;
	@NotEmpty(message = "Password should not be empty!")
	@Size(min = 8, max = 25, message = "Password not within range (8-25)")
	private String password;
	
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", password=" + password + "]";
	}
 	
	

}
