package com.ass.customerdatamanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ass.customerdatamanagement.entity.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Integer>{

	Optional<BankAccount> findByAccountNumber(Long accountNumber);

	void deleteBankByAccountNumber(Long accountNumber);

	List<BankAccount> findByName(String name);


}
