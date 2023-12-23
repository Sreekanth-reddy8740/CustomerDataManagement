package com.ass.customerdatamanagement.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ass.customerdatamanagement.dto.CustomerDTO;
import com.ass.customerdatamanagement.dto.ResponseStructure;
import com.ass.customerdatamanagement.entity.Customer;
import com.ass.customerdatamanagement.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public @ResponseBody  ResponseStructure<Customer> saveCustomer(@RequestBody  CustomerDTO customer)
	{
		return customerService.saveCustomer(customer);
		
	}
	
	@PutMapping("/customer")
	public @ResponseBody  ResponseStructure<Customer> updateCustomer(@RequestBody  Customer customer)
	{
		return customerService.updateCustomer(customer);
	}
	
	
	
	 @GetMapping("/customer")
     public @ResponseBody ResponseStructure<List<Customer>> getAllCustomerData()
	{
	   return customerService.getAllCustomerData();
    }
	
	 @GetMapping("/customer/{id}")//accepting dynamic data{}//1 same as 2 500 error
	 public  @ResponseBody Customer getCustomerDataById(@PathVariable("id")  int id)
	 {
		 return  customerService.getCustomerDataById(id);
	 }
	 
	 @DeleteMapping("/customer")
	 public Customer deleteById(@RequestParam("id")  int id) {
		return customerService.deleteById(id);
		 
	 }
	 @GetMapping("/customerbyname/{name}")//2 same as 1//duplicate method as it get a ambiguty error
	public @ResponseBody List<Customer> getCustomerByName(@PathVariable("name")  String name)
	{
		return customerService.getCustomerByName(name);
	}
	 @PostMapping("/validateCustomer")
	 public List<Customer> validateCustomer(@RequestParam("name")  String name, @RequestParam("email") String email)
	 {
		 return customerService.validateCustomer(name, email);
	 }

}
