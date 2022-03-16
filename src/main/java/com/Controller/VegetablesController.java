package com.Controller;

import java.lang.System.Logger;
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

import com.entity.Vegetables;
import com.service.VegetableService;

@RestController
@RequestMapping("/api")

public class VegetablesController {
	
	@Autowired
	VegetableService vegetablesservice;
	
	Logger logger= System.getLogger("loger");
	
	/* @RequestMapping("/Hello")
	public String helloVegetables()
	{
		String msg="Welcome to Vegetables Page";
		return msg;
	} */
	
	@PutMapping(path="/updateVegetables")
	public ResponseEntity<Vegetables> updateVegetables(@RequestBody Vegetables e) throws Throwable
	{
		Vegetables e1=vegetablesservice.updateVegetables(e);
		
		ResponseEntity re=new ResponseEntity<Vegetables>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteVegetables")
	public ResponseEntity<String> deleteVegetables(@RequestBody Vegetables e)
	{
		vegetablesservice.deleteVegetables(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteVegetablesById/{vid}")
	public ResponseEntity<String> deleteVegetablesById(@PathVariable int vid)
	{
		vegetablesservice.deleteVegetablesById(vid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	
	@PostMapping("/addVegetables")
	public ResponseEntity<Vegetables> addVegetables(@Valid @RequestBody Vegetables v)
	{
		Vegetables v1=vegetablesservice.addVegetables(v);
		ResponseEntity re=new ResponseEntity<Vegetables>(v1,HttpStatus.OK);
		return re;
	}
	
}
