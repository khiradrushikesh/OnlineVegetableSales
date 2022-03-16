package com.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Orders;
import com.repository.OrderRepo;

@SpringBootTest
class OrdersServiceTest {
	
	@Autowired
	OrderService ordersservice;
	
	@MockBean
	OrderRepo repo;
	
	@Test
	void testAddOrder() {
		Orders o1=new Orders();
		o1.setOid(1);
		o1.setItems(5);
		o1.setOname("S");
		o1.setPrice(7000.00);
		Mockito.when(repo.save(o1)).thenReturn(o1);
		
		assertThat(ordersservice.addOrder(o1)).isEqualTo(o1);
	}

	@Test
	void testGetOrders() {
		Orders o1=new Orders();
		o1.setOid(1);
		o1.setItems(5);
		o1.setOname("S");
		o1.setPrice(7000.00);
		
		Orders o2=new Orders();
		o2.setOid(2);
		o2.setItems(5);
		o2.setOname("K");
		o2.setPrice(9000.00);
		
		List<Orders> ordersList=new ArrayList<>();
		ordersList.add(o1);
		ordersList.add(o2);
	
		Mockito.when(repo.findAll()).thenReturn(ordersList);
		assertThat(ordersservice.getOrders()).isEqualTo(ordersList);

	
	}

	@Test
	void testGetById() throws Throwable {
		Orders o1=new Orders();
		o1.setOid(1);
		o1.setItems(9);
		o1.setOname("S");
		o1.setPrice(7000.00);
		
		Optional<Orders> o2=Optional.of(o1);
		
		Mockito.when(repo.findById(1)).thenReturn(o2);
		assertThat(ordersservice.getById(1)).isEqualTo(o1);
		
	}

	@Test
	void testDeleteById() {
		Orders o1=new Orders();
		o1.setOid(1);
		o1.setItems(9);
		o1.setOname("S");
		o1.setPrice(7000.00);
		
		Optional<Orders> o2=Optional.of(o1);
		
		Mockito.when(repo.findById(1)).thenReturn(o2);
		Mockito.when(repo.existsById(o1.getOid())).thenReturn(false);
		assertFalse(repo.existsById(o1.getOid()));
		
	}

	@Test
	void testDeleteOrders() {
		Orders o1=new Orders();
		o1.setOid(1);
		o1.setItems(5);
		o1.setOname("S");
		o1.setPrice(7000.00);
		
		Optional<Orders> o2=Optional.of(o1);
		
		Mockito.when(repo.findById(1)).thenReturn(o2);
		Mockito.when(repo.existsById(o1.getOid())).thenReturn(false);
		
		assertFalse(repo.existsById(o1.getOid()));
		
	}

}