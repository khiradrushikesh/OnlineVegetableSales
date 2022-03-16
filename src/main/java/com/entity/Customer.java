package com.entity;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Columns;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "Customer" )
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotNull
	private int cid;
	
	@NotNull
	@Size(min=3, message = "Customer Name is required")
	private String cname;
	
	@NotNull
	@Size(message = "Customer Email Id is not Valid")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String emailId;
	
	@NotNull
	@NotEmpty
	private String password;
	
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
	
	@OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private Set<Bill> bill;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Customer [cid=" + cid + ", cname=" + cname + ", emailId=" + emailId + ", password=" + password
				+ ", cphoneno=" + cphoneno + ", caddress=" + caddress + ", cdob=" + cdob + ", city=" + city + "]";
	}

	

	
	
}	
