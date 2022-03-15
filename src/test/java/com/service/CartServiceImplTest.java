package com.service;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.entity.Cart;
import com.repository.BillRepo;
import com.repository.CartRepo;

@SpringBootTest
public class CartServiceImplTest {
	
	@Autowired
	CartService cartService;

	@MockBean
	CartRepo repo;

	@Test
	void testGetCart()
	{
	Cart b1 = new Cart();
	b1.setCartId(54);
	b1.setOrders("Onion");
	b1.setQuantity("2kg");
	
	

	Cart b2 = new Cart();
	b1.setCartId(54);
	b1.setOrders("Tomato");
	b1.setQuantity("1kg");
	
	
	
	List<Cart> cartList = new ArrayList<>();
	cartList.add(b1);
	cartList.add(b2);

	Mockito.when(repo.findAll()).thenReturn(cartList);

	assertThat(cartService.getCart()).isEqualTo(cartList);
	}

	@Test
	void testDeleteBill() {
		Cart b1 = new Cart();
		b1.setCartId(54);
		b1.setOrders("Tomato");
		b1.setQuantity("1kg");
		
	Optional<Cart> b2=Optional.of(b1);

	Mockito.when(repo.findById(1)).thenReturn(b2);
	Mockito.when(repo.existsById(b1.getCartId())).thenReturn(false);
	assertFalse(repo.existsById(b1.getCartId()));
	}

}
