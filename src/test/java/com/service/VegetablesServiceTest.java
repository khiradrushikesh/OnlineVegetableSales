package com.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.repository.VegetablesRepo;

class VegetablesServiceTest {


@Autowired
VegetableService adminservice;
	 
@MockBean
VegetablesRepo repo;

@Test
void testAddVegetablesVegetables() {
fail("Not yet implemented");
	}

@Test
void testDeleteVegetablesById() {
		fail("Not yet implemented");
}

@Test
void testUpdateVegetables() {
	fail("Not yet implemented");
}
@Test
void testGetVegetablesById() {
	fail("Not yet implemented");
}

}
