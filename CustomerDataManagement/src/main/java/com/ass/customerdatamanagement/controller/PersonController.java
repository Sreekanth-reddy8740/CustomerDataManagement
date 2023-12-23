package com.ass.customerdatamanagement.controller;

import java.util.List;
import java.util.Optional;

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

import com.ass.customerdatamanagement.entity.BankAccount;
import com.ass.customerdatamanagement.entity.Person;
import com.ass.customerdatamanagement.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping("person")
	public Person  savePerson(@RequestBody  Person person) {
		return personService.savePerson(person);
		
	}
	@PutMapping("person")
	public Person  updatePerson(@RequestBody  Person person) {
		return personService.updatePerson(person);
		
	}
	@GetMapping("getAll")
	public List<Person> getAll()
	{
		return personService.getAll();
	}
	@GetMapping("person/{id}")
      public  Object getPersonById(@PathVariable("id") int id){
			return personService.getPersonById(id);
		}
	
	@GetMapping("getPersonByName/{name}")
	  public List<Person> getPersonByName(@PathVariable("name") String name)
		{
			return personService.getPersonByName(name);
		}
	
	@DeleteMapping("/deleteByPersonName")
	public void deleteByPersonName(@RequestParam("name") String name) {//5
		personService.getPersonByName(name);
	}
	@DeleteMapping("deleteByPersonId/{id}")
	 public void deleteByPersonId(@PathVariable("id")  Integer id) {//5
		 personService.deleteByPersonId(id);
	   	
	   }
	@GetMapping("/getBankById")
	 public Optional<BankAccount> getBankById(@RequestParam("id")   Integer id) {//6
			return personService.getBankById(id);
	    }
	@GetMapping("/getByBankAccountNumber/{accountNumber}")
	public @ResponseBody Optional<BankAccount> getByBankAccountNumber(@PathVariable("accountNumber")  Long accountNumber) {//7
    	return personService.getByBankAccountNumber(accountNumber);
		
	}
	@GetMapping("/getAllBankAccounts")
	 public List<BankAccount> getAllBankAccounts() {//8
		   	return personService.getAllBankAccounts();
		   }
	
	@DeleteMapping("/deleteBankByAcNumber/{accountNumber}")
	 public void deleteBankByAcNumber(@PathVariable("accountNumber")  Long accountNumber) {
		 personService.deleteBankByAcNumber(accountNumber);
	   }
	@GetMapping("/getBankByName/{name}")
	public  List<BankAccount> getBankByName(@PathVariable("name")  String name) {//6
		return personService.getBankByName(name);
   }

}
