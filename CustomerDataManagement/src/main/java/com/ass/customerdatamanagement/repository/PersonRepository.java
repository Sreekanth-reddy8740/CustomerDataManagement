package com.ass.customerdatamanagement.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ass.customerdatamanagement.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	List<Person> findByName(String name);

	void deleteByName(String name);

}
