package com.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Bill;
import com.service.BillService;

@RestController
@RequestMapping("/api")
public class BillController {
	
	@Autowired
	BillService BillService;

	@RequestMapping("/Hello")
	public String helloBill()
	{
	String msg="Welcome to Spring Data Jpa";
	return msg;
	}

	@GetMapping("/getBill")
	public ResponseEntity<List<Bill>> getBill()
	{
	List<Bill> lb1=BillService.getBill();
	ResponseEntity re=new ResponseEntity<List<Bill>>(lb1,HttpStatus.OK);
	return re;
	}

	@GetMapping(path="/getBillById/{billId}")
	public ResponseEntity<Bill> getBillById(@PathVariable int billId) throws Throwable
	{
	Bill b1=BillService.getBillById(billId);

	ResponseEntity re=new ResponseEntity<Bill>(b1,HttpStatus.OK);
	return re;
	}



	@GetMapping(path="/getBill/{customerName}")
	public ResponseEntity<Bill> getBillByName(@PathVariable String customerName) throws Throwable
	{
	Bill b1=BillService.getBillBycustomerName(customerName);

	ResponseEntity re=new ResponseEntity<Bill>(b1,HttpStatus.OK);
	return re;
	}


	@PostMapping("/addBill")
	public ResponseEntity<Bill> addBill(@Valid @RequestBody Bill b)
	{
	Bill b1=BillService.addBill(b);
	ResponseEntity re=new ResponseEntity<Bill>(b1,HttpStatus.OK);
	return re;
	}

	@PutMapping(path="/updateBill")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill e) throws Throwable
	{
	Bill e1=BillService.updateBill(e);

	ResponseEntity re=new ResponseEntity<Bill>(e1,HttpStatus.OK);
	return re;
	}

	@DeleteMapping(path="/deleteBill")
	public ResponseEntity<Bill> deleteBill(@RequestBody Bill e)
	{
	BillService.deleteBill(e);

	ResponseEntity re=new ResponseEntity<String>("Bill deleted successfully..",HttpStatus.OK);
	return re;
	}


	@DeleteMapping(path="/deleteBillById/{billId}")
	public ResponseEntity<String> deleteBillById(@PathVariable int billId) throws Throwable
	{
	BillService.deleteBillById(billId);

	ResponseEntity re=new ResponseEntity<String>("Bill deleted successfully..",HttpStatus.OK);
	return re;
	}

}
