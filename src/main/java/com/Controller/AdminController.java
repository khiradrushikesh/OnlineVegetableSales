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
import com.entity.Admin;

import com.advices.AdminException;
import com.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	AdminService adminservice;
	
	//Logger logger= System.getLogger("loger");
	
		
	  
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addOrder(@Valid @RequestBody Admin o)
	{
	Admin o1=adminservice.addAdmin(o);
	ResponseEntity<Admin> re=new ResponseEntity<Admin>(o1,HttpStatus.OK);
	return re;
	}
	
	
	@GetMapping("/getAdmin")
	public ResponseEntity<List<Admin>> getAdmin()
	{
	List<Admin> lo1=adminservice.getAdmin();
	ResponseEntity<List<Admin>> re = new ResponseEntity<List<Admin>>(lo1,HttpStatus.OK);
	return re;
	}
	
	@GetMapping(path="/getAdminById/{admin_id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int admin_id) throws Throwable
	{
		Admin c1=adminservice.getAdminById(admin_id);
		
		ResponseEntity re=new ResponseEntity<Admin>(c1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteAdmin/{admin_id}")
	public ResponseEntity<String> deleteAdmin (@PathVariable  int admin_id )throws AdminException
	{
		adminservice.deleteAdminById(admin_id);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	
	
}
