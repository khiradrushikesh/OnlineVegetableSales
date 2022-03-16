package com.entity;
import java.util.function.Supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name="bill")

public class Bill {
	
	@Id
	@GeneratedValue
	
	@NotNull
	private int billId;
	
	@NotBlank
	@Size(min=2,message="Customer name should have atleast 2 characters")
	private String customerName;
	
	@NotBlank
	@Size(min=3,message="Vegetabe name should have atleast 3 characters")
	private String vegetables;
	
	@NotBlank
	@Size(max=8,message="Quantity should have atmost 8 characters")
	private String quantity;
	
	@NotBlank
	@JsonFormat(pattern="DD-MM-YYYY",shape = Shape.STRING)
	@Column(name="date_created")
    private String  dateCreated;
	
	@NotNull
	private int price;
	@NotNull
	private int total;
	
	@OneToOne
    @JoinColumn(name = "cid")
    private Customer customer;
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getVegetables() {
		return vegetables;
	}
	public void setVegetables(String vegetables) {
		this.vegetables = vegetables;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", customerName=" + customerName + ", vegetables=" + vegetables
				+ ", quantity=" + quantity + ", dateCreated=" + dateCreated + ", price=" + price + ", total=" + total
				+ "]";
	}
}
