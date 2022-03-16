package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cart")

public class Cart {
	
	@Id
	@GeneratedValue
	
	@NotNull
	private int cartId;
	
	@NotBlank
	@Size(min=3,message="Order name should have atleast 3 characters")
	private String orders;
	
	
	
	@NotBlank
	@Size(max=8,message="Quantity should have atmost 8 characters")
	private String quantity;
	
	@OneToOne
    @JoinColumn(name = "oid")
    private Orders order;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getOrders() {
		return orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", orders=" + orders + ", quantity=" + quantity
				+ "]";
	}

}
