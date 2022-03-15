package com.service;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.ResourceNotFoundException;
import com.entity.Customer;
import com.repository.CustomerRepo;

@Service
public class CustomerService {
	
	  @Autowired 
	  CustomerRepo repo;
	  
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
			 
}
