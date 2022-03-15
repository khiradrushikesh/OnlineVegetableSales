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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.entity.Cart;
import com.service.CartService;



@RestController
@RequestMapping("/ps")
public class cartController {
	
	@Autowired
	CartService cartservice;

	@RequestMapping("/Hi")
	public String helloCart()
	{
	String msg="Welcome to Spring Data Jpa";
	return msg;
	}

	@PostMapping("/addCart")
	public ResponseEntity<Cart> addCart(@Valid @RequestBody Cart c)
	{
	Cart c1=cartservice.addCart(c);
	ResponseEntity re=new ResponseEntity<Cart>(c1,HttpStatus.OK);
	return re;
	}

	@GetMapping("/getCart")
	public ResponseEntity<List<Cart>> getCart()
	{
	List<Cart> lc1=cartservice.getCart();
	ResponseEntity re=new ResponseEntity<List<Cart>>(lc1,HttpStatus.OK);
	return re;
	}


	@GetMapping(path="/getCart/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable int cartId) throws Throwable
	{
	Cart c1=cartservice.getCartById(cartId);

	ResponseEntity re=new ResponseEntity<Cart>(c1,HttpStatus.OK);
	return re;
	}


	@PutMapping(path="/updateCart")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart e) throws Throwable
	{
	Cart e1=cartservice.updateCart(e);

	ResponseEntity re=new ResponseEntity<Cart>(e1,HttpStatus.OK);
	return re;
	}


	@DeleteMapping(path="/deleteCart")
	public ResponseEntity<String> deleteCart(@RequestBody Cart e)
	{
	cartservice.deleteCart(e);

	ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
	return re;
	}

	@DeleteMapping(path="/deleteCartById/{cartId}")
	public ResponseEntity<String> deleteCartById(@PathVariable int cartId)
	{
	cartservice.deleteCartById(cartId);

	ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
	return re;
	}

}
