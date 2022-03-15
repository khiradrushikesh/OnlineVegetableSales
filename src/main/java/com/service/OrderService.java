package com.service;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.OrderNotFoundException;
import com.entity.Orders;
import com.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo or;
	
	public Orders addOrder(Orders o) 
	{
		or.save(o);
		return o;
		
	}
	public List<Orders> getOrders()
	{
		List<Orders> l=or.findAll();
		return l;
	}
	public Orders getById(int oid) throws Throwable{
		@SuppressWarnings("rawtypes")
		Supplier s1=()-> new OrderNotFoundException("Order Id Not Found in the Database");
		@SuppressWarnings("unchecked")
		Orders o=or.findById(oid).orElseThrow(s1);
		
		return o;
		
	}
	public String deleteById(int oid) 
	{
		
		or.deleteById(oid);
		return "Deleted By ID";
	}
	public String deleteOrders(Orders o) 
	{
		or.delete(o);
		return "Deleted";
	}
}
