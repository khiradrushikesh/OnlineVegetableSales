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

import com.entity.Comment;
import com.repository.CommentRepo;

@SpringBootTest
class CommentServiceTest {

	@Autowired
	CommentService ordersservice;
	@MockBean
	
	CommentRepo repo;
	@Test
	void testAddOrder() {
		Comment c1 = new Comment();
		c1.setCid(1);
		c1.setComment("Sreekanth");
		c1.setRate("5");

		Mockito.when(repo.save(c1)).thenReturn(c1);



		assertThat(ordersservice.addOrder(c1)).isEqualTo(c1);
		}
	@Test
	void testGetById() throws Throwable {
		Comment c1 = new Comment();
		c1.setCid(1);
		c1.setComment("sumit");
		c1.setRate("Sumit@gmail");

		Optional<Comment> c2= Optional.of(c1);

		Mockito.when(repo.findById(1)).thenReturn(c2);

		assertThat(ordersservice.getById(1)).isEqualTo(c1);
		}
	
		/*
		 * @Test void testDeleteById() { Comment c1= new Comment(); c1.setCid(4);
		 * c1.setComment("Dinga"); c1.setRate("Devraj@123");
		 * 
		 * Optional<Comment> c2= Optional.of(c1);
		 * Mockito.when(repo.findById(1)).thenReturn(c2);
		 * Mockito.when(repo.delete).thenReturn(c1);
		 * 
		 * assertThat(ordersservice.deleteById(4).isEqualTo(null)); }
		 */

}

