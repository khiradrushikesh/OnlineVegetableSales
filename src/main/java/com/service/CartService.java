package com.service;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.ResourceNotFoundException;
import com.entity.Cart;
import com.repository.CartRepo;
@Service
public class CartService {
	
	@Autowired
	CartRepo repo;

	public Cart addCart(Cart c)
	{
	repo.save(c);
	return c;
	}

	public List<Cart> getCart()
	{
	List<Cart> lc1=repo.findAll();

	return lc1;
	}
	public Cart getCartById(int cartId) throws Throwable {
	Supplier s1= ()->new ResourceNotFoundException("Cart does not exist in the list");
	Cart c=repo.findById(cartId).orElseThrow(s1);
	return c;
	}
	public String deleteCartById(int cartId) {

	repo.deleteById(cartId);

	return "Deleted";
	}
	public String deleteCart(Cart c) {

	repo.delete(c);
	return "Deleted";
	}
	public Cart updateCart(Cart c) throws Throwable {
	int id=c.getCartId();

	Supplier s1= ()->new ResourceNotFoundException("Cart does not exist in the list");
	Cart c1=repo.findById(id).orElseThrow(s1);

	c1.setCartId(c.getCartId());
	c1.setOrders(c.getOrders());
	c1.setQuantity(c.getQuantity());


	repo.save(c1);
	return c1;
	}

	public List<Cart> addCart(List<Cart> ls) {
	repo.saveAll(ls);
	return ls;
	}

}
