package com.Controller;

import java.util.List;

import javax.validation.Valid;

import com.entity.Comment;
import com.service.CommentService;
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

@RestController
@RequestMapping("/User")
public class CommentController {
	
	@Autowired
	CommentService ordersservice;

	@GetMapping("/Home")
	public String sayHello() {
		return "Welcome to the Orders Page";
	}

	@PostMapping("/addComments")
	public ResponseEntity<Comment> addComment(@Valid @RequestBody Comment o) {
		Comment o1 = ordersservice.addOrder(o);
		ResponseEntity<Comment> re = new ResponseEntity<Comment>(o1, HttpStatus.OK);
		return re;
	}

	@GetMapping("/getComments")
	public ResponseEntity<List<Comment>> getOrders() {
		List<Comment> lo1 = ordersservice.getOrders();
		ResponseEntity<List<Comment>> re = new ResponseEntity<List<Comment>>(lo1, HttpStatus.OK);
		return re;
	}

	@GetMapping("/getCommentsById/{oid}")
	public ResponseEntity<Comment> getOrdersById(@PathVariable int oid) throws Throwable {
		Comment o1 = ordersservice.getById(oid);
		ResponseEntity<Comment> re = new ResponseEntity<Comment>(o1, HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path = "/deleteComments")
	public ResponseEntity<String> deleteOrders(@RequestBody Comment o) {
		ordersservice.deleteOrders(o);
		ResponseEntity<String> re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path = "/deleteCommentsById/{oid}")
	public ResponseEntity<String> deleteOrderById(@PathVariable int oid) throws Throwable {
		ResponseEntity<String> re = new ResponseEntity<String>("Deleted By Id", HttpStatus.OK);
		ordersservice.deleteById(oid);
		return re;
	}
}
