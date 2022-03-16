package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Customer;
import com.repository.CustomerRepo;

@SpringBootTest
class CustomerSeriveImplTest {
	
	@Autowired
	CustomerService customerService;
	
	@MockBean
	CustomerRepo Repo;
	
	@Test
	void testGetCustomers()
	{
		Customer c1 = new Customer();
		c1.setCid(4);
		c1.setCname("Amit");
		c1.setEmailId("Amit@gmail.com");
		c1.setPassword("Amit@1234");
		c1.setCphoneno("9876543210");
		c1.setCdob("01-01-2000");
		c1.setCaddress("Saptshree Heights");
		c1.setCity("Thane");
		
		Customer c2 = new Customer();
		c1.setCid(5);
		c1.setCname("Abhishek");
		c1.setEmailId("Ahishek@gmail.com");
		c1.setPassword("Abhishek@1234");
		c1.setCphoneno("9897796666");
		c1.setCdob("25-12-1998");
		c1.setCaddress("Nageshwarwadi");
		c1.setCity("Aurangabad");
		
		List<Customer> customerList = new ArrayList<>();
		customerList.add(c1);
		customerList.add(c2);
		
		Mockito.when(Repo.findAll()).thenReturn(customerList);
		
		assertThat(customerService.getCustomer()).isEqualTo(customerList);
	}
	
	@Test
	void testDeleteCoder() {
		Customer c1 = new Customer();
		c1.setCid(4);
		c1.setCname("Amit");
		c1.setEmailId("Amit@gmail.com");
		c1.setPassword("Amit@1234");
		c1.setCphoneno("9876543210");
		c1.setCdob("2000-01-24");
		c1.setCaddress("Saptshree Heights");
		c1.setCity("Thane");
		Optional<Customer> c2=Optional.of(c1);
		
		Mockito.when(Repo.findById(1)).thenReturn(c2);
		 Mockito.when(Repo.existsById(c1.getCid())).thenReturn(false);
		   assertFalse(Repo.existsById(c1.getCid()));
	}
	
	
}
