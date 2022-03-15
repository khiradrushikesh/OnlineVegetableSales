package com.service;

import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.ResourceNotFoundException;
import com.entity.Customer;
import com.repository.CustomerRepo;

@Service
public class CustomerService {
	
	  @Autowired 
	  CustomerRepo repo;
	  
	  Logger logger=org.slf4j.LoggerFactory.getLogger(CustomerService.class);
	  
	  public Customer registerUser(Customer customer)  throws ResourceNotFoundException {
			
			if(repo.existsById(customer.getCid())) {
				throw new ResourceNotFoundException("User Already exists!");
				}
			
			//E-mail Validation
			String emailregex = "^[A-Za-z0-9+_.-]+@(.+)$";
			Pattern emailpattern = Pattern.compile(emailregex);
			Matcher emailmatcher = emailpattern.matcher(customer.getEmailId());
			
			//Password Validation 
			String passRegex = "[a-zA-Z0-9]{8,20}";
			Pattern passPattern = Pattern.compile(passRegex);
			Matcher passMatcher = passPattern.matcher(customer.getPassword());
			
			
			if(emailmatcher.matches()==false && passMatcher.matches()==false) {
				logger.error("Invalid format of Email and Password");
			 }
			else if(emailmatcher.matches()==true && passMatcher.matches()==false) {
				logger.error("Invalid Password");
			 }
			 else if(emailmatcher.matches()==false && passMatcher.matches()==true) {
				 logger.error("Invalid Email Id");
			 }
	        if(emailmatcher.matches()==true && passMatcher.matches()==true) {
	        	logger.info("User signed up \n" + "WELCOME " + customer.getCname());
	        }
	        repo.save(customer);
			return customer;
		}
	  
	  public Customer addCustomer(Customer c) 
	  { 
		  repo.save(c); 
		  return c; 
	  }
	  
	  public List<Customer> getCustomer()
	  {
		  List<Customer> lc = repo.findAll();
		  return lc;
	  }
	  
		  public Customer getCustomerById(int cid) throws Throwable
		  	{
			  Supplier s1 = ()-> new ResourceNotFoundException("Customer does not exist in database...");
			  Customer c1 = repo.findById(cid).orElseThrow(s1); 
			  return c1; 
			}
		 
			
			  public String deleteCustomerById(int cid) 
			  {
			  	  repo.deleteById(cid);
			  	  return "Deleted"; 
			   }
			  
			  public String deleteCustomer(Customer c) 
			    {
				  repo.delete(c); 
				  return "Deleted"; 
				 }
			  
			  	  public Customer updateCustomer(Customer c) throws Throwable 
			  	  { 
			  		  int id=c.getCid(); 
			  		  Supplier s1= ()->new ResourceNotFoundException("Coder Does not exist in the database"); 
			  		  Customer c1=repo.findById(id).orElseThrow(s1);
			  		  
			  		  c1.setCname(c.getCname()); 
			  		  c1.setCity(c.getCity()); 
			  		  repo.save(c1); 
			  		  return c1;
			  }
			  
			  public List<Customer> addCustomers(List<Customer> ls)
			  { 
				  repo.saveAll(ls);
				  return ls; 
			}
			
			  public Customer getCustomerByCname(String cname) 
			  { 
				  Customer  c=repo.findByCname(cname); 
				  return c; 
			  }
			  
			  public List<Customer> findByCitySorted(String city) 
			  { 
				  List<Customer> lc=repo.findByCitySorted(city); 
				  return lc;
			   }

			public static Customer signIn(String emailId, String password, int cid) {
				// TODO Auto-generated method stub
				return null;
			}
			 

			  }
