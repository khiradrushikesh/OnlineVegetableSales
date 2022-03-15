package com.entity;

import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "Customer" )
public class Customer {
	
	@Id
	@GeneratedValue
	
	@NotNull
	private int cid;
	
	@NotNull
	@Size(min=3, message = "Customer Name is required")
	private String cname;
	
	
	@NotNull
	@Size(min=10, max=10,  message = "Customer Phone Number is required")
	private String cphoneno;
	
	@NotNull
	@Size(min=3, message = "Customer Address is required")
	private String caddress;
	
	@NotNull
	@JsonFormat(pattern="DD-MM-YYYY", shape=Shape.STRING)
	@Size(min=8, max=10, message = "Customer Date-Of-Birth is required")
	private String cdob;
	
	@NotNull
	@Size(min=3, message = "Customer City Name is required")
	private String city;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCphoneno() {
		return cphoneno;
	}

	public void setCphoneno(String cphoneno) {
		this.cphoneno = cphoneno;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCdob() {
		return cdob;
	}

	public void setCdob(String cdob) {
		this.cdob = cdob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ",  cphoneno=" + cphoneno
				+ ", caddress=" + caddress + ", cdob=" + cdob + ", city=" + city + "]";
	}

	

	
	
}	
