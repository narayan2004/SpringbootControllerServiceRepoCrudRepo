package com.capgemini.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.model.Employee;

public interface EmpRepository extends CrudRepository<Employee, String> {  
	
	
} 
