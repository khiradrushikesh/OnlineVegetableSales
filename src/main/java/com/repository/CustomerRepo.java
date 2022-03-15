package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>

	{
	Customer findByCname(String cname);
	
	@Query("Select c from Customer c where c.city=?1 order by c.cname")
	List<Customer> findByCitySorted(String city);
	
}
