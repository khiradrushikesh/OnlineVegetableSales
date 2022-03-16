package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.Vegetables;
import com.repository.VegetablesRepo;

@Service
public class VegetableService {

	@Autowired
	VegetablesRepo repo;
	
	public Vegetables addVegetables(Vegetables v)
	{
		 repo.save(v);	
		 return v;
	}
	

	public String deleteVegetablesById(int vid) {
		
		repo.deleteById(vid);
		
		return "Deleted";
	}

	public String deleteVegetables(Vegetables v) {
		
		repo.delete(v);
		return "Deleted";
	}
	
	public List<Vegetables> addVegetables(List<Vegetables> ls) {
		repo.saveAll(ls);
		return ls;
	}

	public Vegetables updateVegetables(Vegetables v) throws Throwable 
	{
		int id=v.getVid();
		
		Supplier s1= ()->new ResourceNotFoundException("Vegetables Does not exist in the database");
		Vegetables v1=repo.findById(id).orElseThrow(s1);
		
		v1.setVname(v.getVname());
		v1.setVcategory(v.getVcategory());
		repo.save(v1);
		return v1;	
	}
}
