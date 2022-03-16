package com.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.assertFalse;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.junit.jupiter.api.Disabled;
	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

	import com.entity.Admin;
	import com.repository.AdminRepo;

	@SpringBootTest
	public class AdminServiceImplTest {
	
		
		@Autowired
		AdminService adminservice;
		
		@MockBean
		com.repository.AdminRepo repo;

		@Test
		void testGetAdmins() {
		Admin a1=new Admin();
			a1.setAdmin_id(2);
			a1.setAdmin_name("SaiKumar@123");
			a1.setPassword("saikumard");
			
			Admin a2=new Admin();
			a2.setAdmin_id(4);
			a2.setAdmin_name("saikumar345");
			a2.setPassword("Abcdef@cg");
			
			List<Admin> adminList = new ArrayList<>();
			adminList.add(a1);
			adminList.add(a2);
			
			Mockito.when(repo.findAll()).thenReturn(adminList);
			
			assertThat(adminservice.getAdmin()).isEqualTo(adminList);
		}

		
	
}
