package com.ass.customerdatamanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.ass.customerdatamanagement.dto.CustomerDTO;
import com.ass.customerdatamanagement.entity.Customer;
import com.ass.customerdatamanagement.repository.CustomerReposotory;

@Repository
public class CustomerDAO {
	@Autowired
	private CustomerReposotory repository;
	
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
		
	}
	 public List<Customer> getAllCustomerData()
	 {
		 return repository.findAll();
	 }
	 
	 public Customer getCustomerDataById(int id)
	 {
		 return repository.findById(id).orElse(
				 new Customer(HttpStatus.NOT_FOUND.value(),
						 HttpStatus.NOT_FOUND.name(),
						 HttpStatus.NOT_FOUND.name()
						 
						 ));
	 }
	 public Customer deleteById(int id) {
		 Customer customer = getCustomerDataById(id);
		 if(customer.getId()!=404) {
		 repository.deleteById(id);
		 }
		 return customer;
	 }
	public List<Customer> getCustomerByName(String name)
	{
		return repository.findByName(name);
	}
	public List<Customer> validateCustomer(String name,String email)
	{
		return repository.validateCustomer(name, email);
	}
	

	

}
