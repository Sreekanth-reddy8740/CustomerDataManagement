package com.ass.customerdatamanagement.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ass.customerdatamanagement.dao.PersonDAO;
import com.ass.customerdatamanagement.entity.BankAccount;
import com.ass.customerdatamanagement.entity.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDAO personDAO;
	
	public Person  savePerson(Person person) {
		return personDAO.savePerson(person);
		
	}
	public Person  updatePerson(Person person) {
		return personDAO.savePerson(person);
		
	}
	public List<Person> getAll(){
		return personDAO.getAll();
		
	}
    public  Object getPersonById(int id){
		
		return personDAO.getPersonById(id);
	}
    
    public List<Person> getPersonByName(String name)
	{
		return personDAO.getPersonByName(name);
	}
    
   
    public void deleteByPersonId(Integer id) {//5
    	personDAO.deleteByPersonId(id);
   	
   }
    public Optional<BankAccount> getBankById(Integer id) {//6
		return personDAO.getBankById(id);
    }
    
    public Optional<BankAccount> getByBankAccountNumber(Long accountNumber) {//7
    	return personDAO.getByBankAccountNumber(accountNumber);
		
	}
    
   public List<BankAccount> getAllBankAccounts() {//8
   	return personDAO.getAllBankAccounts();
   }
   public void deleteBankByAcNumber(Long accountNumber) {
	   personDAO.deleteBankByAcNumber(accountNumber);
   }
   
   public List<BankAccount> getBankByName(String name) {//6
		return personDAO.getBankByName(name);
   }



}
