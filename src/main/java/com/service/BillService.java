package com.service;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.ResourceNotFoundException;
import com.entity.Bill;

import com.repository.BillRepo;
@Service
public class BillService {
	
	@Autowired
	BillRepo repo;

	public Bill addBill(Bill b)
	{
		repo.save(b);
		return b;
	}

	public List<Bill> getBill()
	{
		List<Bill> lc1=repo.findAll();
		return lc1;
	}

	public String deleteBillById(int billId) {

	repo.deleteById(billId);

	return "Deleted";
	}

	public String deleteBill(Bill b) 
	{

	 repo.delete(b);
	 return "Deleted";
	}

	public List<Bill> addBill(List<Bill> ls) {
	repo.saveAll(ls);
	return ls;
	}

	public Bill getBillBycustomerName(String customerName) {
	Bill b=repo.findBycustomerName(customerName);
	return b;
	}

	public Bill getBillById(int billId) throws Throwable {
	Supplier s1= ()->new ResourceNotFoundException("Bill does not exist in the list");
	Bill b=repo.findById(billId).orElseThrow(s1);
	return b;
	}
	public Bill updateBill(Bill b) throws Throwable
	{
		int id=b.getBillId();
		Supplier s1 = ()->new ResourceNotFoundException("Bill does not exist in the list");
		Bill b1 = repo.findById(id).orElseThrow(s1);
		b1.setCustomerName(b.getCustomerName());
		b1.setVegetables(b.getVegetables());
		b1.setQuantity(b.getQuantity());
		b1.setDateCreated(b.getDateCreated());
		b1.setPrice(b.getPrice());
		b1.setTotal(b.getTotal());
		repo.save(b1);
		return b1;
	}

}
