package com.ass.customerdatamanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ass.customerdatamanagement.entity.BankAccount;
import com.ass.customerdatamanagement.entity.Person;
import com.ass.customerdatamanagement.repository.BankRepository;
import com.ass.customerdatamanagement.repository.PersonRepository;

@Repository
public class PersonDAO {
	@Autowired
	private PersonRepository  personRepository;
	@Autowired
	private BankRepository bankRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);//1
		
	}
	
	public List<Person> getAll()
	{
		return personRepository.findAll();//2
		
	}
	
	public  Object getPersonById(int id){
		
		return personRepository.findById(id);//3
	}
	
	public List<Person> getPersonByName(String name)
	{
		return personRepository.findByName(name);//4
	}
		
 
    
    public void deleteByPersonId(Integer id) {//5
   	 personRepository.deleteById(id);
   	
   }
	
	public Optional<BankAccount> getBankById(Integer id) {//6
		return bankRepository.findById(id);
		
	}
    public Optional<BankAccount> getByBankAccountNumber(Long accountNumber) {//7
    	return bankRepository.findByAccountNumber(accountNumber);
		
	}
    public List<BankAccount> getAllBankAccounts() {//8
    	return bankRepository.findAll();
    	
    }
     public void deleteBankByAcNumber(Long accountNumber) {
    	 bankRepository.deleteBankByAccountNumber(accountNumber);//9
     }
     public List<BankAccount> getBankByName(String name) {//10
 		return bankRepository.findByName(name);
 		
 	}

    
}
