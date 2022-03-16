package com.service;

import java.util.List;
import java.util.function.Supplier;

import com.entity.Comment;
import com.repository.CommentRepo;
import com.advices.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

	@Autowired
	CommentRepo or;

	public Comment addOrder(Comment o) {
		or.save(o);
		return o;

	}

	public List<Comment> getOrders() {
		List<Comment> l = or.findAll();
		return l;
	}

	public Comment getById(int oid) throws Throwable {
		@SuppressWarnings("rawtypes")
		Supplier s1 = () -> new OrderNotFoundException("Order Id Not Found in the Database");
		@SuppressWarnings("unchecked")
		Comment o = or.findById(oid).orElseThrow(s1);

		return o;

	}

	public String deleteById(int oid) {

		or.deleteById(oid);
		return "Deleted By ID";
	}

	public String deleteOrders(Comment o) {
		or.delete(o);
		return "Deleted";
	}


}
