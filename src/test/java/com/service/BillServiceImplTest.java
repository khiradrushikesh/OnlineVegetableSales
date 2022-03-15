package com.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Bill;
import com.repository.BillRepo;

@SpringBootTest
public class BillServiceImplTest {
	
	@Autowired
	BillService billService;

	@MockBean
	BillRepo repo;

	@Test
	void testGetBill()
	{
	Bill b1 = new Bill();
	b1.setBillId(54);
	b1.setCustomerName("sachin");
	b1.setVegetables("Tomato");
	b1.setQuantity("2kg");
	b1.setDateCreated("12/02/2022");
	b1.setPrice(10);
	b1.setTotal(20);

	Bill b2 = new Bill();
	b1.setBillId(55);
	b1.setCustomerName("Prakash");
	b1.setVegetables("Methi");
	b1.setQuantity("3");
	b1.setDateCreated("12/02/2022");
	b1.setPrice(5);
	b1.setTotal(15);
	
	List<Bill> billList = new ArrayList<>();
	billList.add(b1);
	billList.add(b2);

	Mockito.when(repo.findAll()).thenReturn(billList);

	assertThat(billService.getBill()).isEqualTo(billList);
	}

	@Test
	void testDeleteBill() {
		Bill b1 = new Bill();
		b1.setBillId(32);
		b1.setCustomerName("Sachin");
		b1.setVegetables("Tomato");
		b1.setQuantity("2kg");
		b1.setDateCreated("13-02-2022");
		b1.setPrice(15);
		b1.setTotal(30);
	Optional<Bill> b2=Optional.of(b1);

	Mockito.when(repo.findById(1)).thenReturn(b2);
	Mockito.when(repo.existsById(b1.getBillId())).thenReturn(false);
	assertFalse(repo.existsById(b1.getBillId()));
	}
}
