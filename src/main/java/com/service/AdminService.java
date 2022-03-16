package com.service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import org.aspectj.weaver.patterns.NamePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import com.entity.Admin;
import com.advices.AdminException;
import com.advices.ResourceNotFoundException;
import com.repository.AdminRepo;


@Service
public class AdminService {
	
	@Autowired
	 AdminRepo Repo;
	
	public Admin addAdmin(Admin o) 
	{
		Repo.save(o);
		return o;
		
	}
	
	public List<Admin> getAdmin()
	{
	List<Admin> l=Repo.findAll();
	return l;
	}
	
	
	
	public Admin SigninAdmin(Admin a) {
		// Name Validation
		String name = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern name1 = Pattern.compile(name);
		Matcher name2 = name1.matcher(a.getAdmin_name());
		Repo.save(a);

		// Password Validation
		String passRegex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern passPattern = Pattern.compile(passRegex);
		Matcher passMatcher = passPattern.matcher(a.getPassword());
		
		if(name2.matches()==false && passMatcher.matches()==false) {
			System.out.println("Invalid Id and Pasword");

			}
			else if(name2.matches()==true && passMatcher.matches()==false) {
			System.out.println("Invalid Pasword");
			}
			else if(name2.matches()==false && passMatcher.matches()==true) {
			System.out.println("Invalid  Id");
			}
			if(name2.matches()==true && passMatcher.matches()==true) {
			System.out.println("User signed in " + a.getAdmin_name());
			}
		return a;
		
	}
	
	
	
	
	public Admin getAdminById(int admin_id) throws Throwable
	{
	Supplier s1 = ()-> new ResourceNotFoundException("Customer does not exist in database...");
	Admin a1 = Repo.findById(admin_id).orElseThrow(s1);
	return a1;
	}
	
	
	
		public String deleteAdminById(int admin_id) throws AdminException{
			
			Repo.deleteById(admin_id);
				return "Deleted by Id";
	}

		public Admin getAdminByAdmin_name(String admin_name) {
			// TODO Auto-generated method stub
			return null;
		}

	

}
