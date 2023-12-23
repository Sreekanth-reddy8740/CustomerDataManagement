package com.ass.customerdatamanagement.service;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ass.customerdatamanagement.dao.CustomerDAO;
import com.ass.customerdatamanagement.dto.CustomerDTO;
import com.ass.customerdatamanagement.dto.ResponseStructure;
import com.ass.customerdatamanagement.entity.Customer;
import com.ass.customerdatamanagement.repository.CustomerReposotory;

@Service
public class CustomerService {
	@Autowired
	private CustomerDAO dao;
	
	public ResponseStructure<Customer> saveCustomer(CustomerDTO dto)
	{
	   Customer cus = new Customer(dto);	
		  Customer customer= dao.saveCustomer(cus);

		ResponseStructure<Customer> rs=new ResponseStructure<>();
		rs.setData(customer);
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("customer data saves successfully");
		rs.setTimeStamp(LocalDateTime.now());

		return rs;
	}
	public ResponseStructure<Customer> updateCustomer(Customer customer)
	{
	//	Customer cust= dao.saveCustomer(customer);
		
		ResponseStructure<Customer> rs=new ResponseStructure<>();
	//	rs.setData(cust);
		rs.setStatusCode(HttpStatus.ACCEPTED.value());
		rs.setTimeStamp(LocalDateTime.now());
		rs.setMessage(HttpStatus.ACCEPTED.name());
		return rs;
	}
	
	 public ResponseStructure<List<Customer>> getAllCustomerData()
	 {
		  List<Customer> list = dao.getAllCustomerData();
		  ResponseStructure<List<Customer>> rs = new ResponseStructure<>();
		 // if(list!=null)not use in list as not null
		  if(list.size()!=0) {
			  rs.setData(list);
			  rs.setTimeStamp(LocalDateTime.now());
			  rs.setStatusCode(HttpStatus.FOUND.value());
			  rs.setMessage("Customers entry found in database");
			  
		  }else {
			  rs.setData(null);
			  rs.setTimeStamp(LocalDateTime.now());
			  rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			  rs.setMessage(" No Customers entry found in database");
			  
		  }
		  return rs;
	 }
	 
	 public Customer getCustomerDataById(int id)
	 {
		 return dao.getCustomerDataById(id);
	 }
	 
	 public Customer deleteById(int id) {
		 return dao.deleteById(id);
	 
	 }
	 public List<Customer> getCustomerByName(String name)
	 {
		 throw new InputMismatchException();
	   //return dao.getCustomerByName(name);
	 }
	public List<Customer> validateCustomer(String name,String email)
	{
		return dao.validateCustomer(name, email);
	}

}
