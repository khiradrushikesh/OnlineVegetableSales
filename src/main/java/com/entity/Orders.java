package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue
	private int oid;
	
	@NotNull
	@NotEmpty(message="Order Name is Required")
	@Size(min=6,max=9)
	private String oname;
	
	@NotNull
	@NotEmpty(message="Price is Required")
	private double price;
	
	@NotNull
	@NotEmpty(message="items is Required")
	private int items;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", oname=" + oname + ", price=" + price + ", items=" + items + "]";
	}
}
