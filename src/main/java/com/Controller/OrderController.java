package com.Controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Orders;
import com.service.OrderService;

@RestController
@RequestMapping("/Orders")
public class OrderController {
	
	@Autowired
	OrderService ordersservice; 
	@GetMapping("/Home")
	public String sayHello() 
	{
		return "Welcome to the Orders Page";
	}
	
	
	@PostMapping("/addOrders")
	public ResponseEntity<Orders> addOrder(@Valid @RequestBody Orders o)
	{
		Orders o1=ordersservice.addOrder(o);
		ResponseEntity<Orders> re=new ResponseEntity<Orders>(o1,HttpStatus.OK);
		return re;
	}
	@GetMapping("/getOrders")
	public ResponseEntity<List<Orders>> getOrders()
	{
		List<Orders> lo1=ordersservice.getOrders();
		ResponseEntity<List<Orders>> re = new ResponseEntity<List<Orders>>(lo1,HttpStatus.OK);
		return re;
	}
	@GetMapping("/getOrdersById/{oid}")
	public ResponseEntity<Orders> getOrdersById(@PathVariable int oid) throws Throwable
	{
		Orders o1=ordersservice.getById(oid);
		ResponseEntity<Orders> re=new ResponseEntity<Orders>(o1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteOrders")
	public ResponseEntity<String> deleteOrders(@RequestBody Orders o)
	{
		ordersservice.deleteOrders(o);
		ResponseEntity<String> re= new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteOrdersById/{oid}")
	public ResponseEntity<String> deleteOrderById(@PathVariable int oid) throws Throwable
	{
		ResponseEntity<String> re = new ResponseEntity<String>("Deleted By Id",HttpStatus.OK);
		ordersservice.deleteById(oid);
		return re;
	}
}
