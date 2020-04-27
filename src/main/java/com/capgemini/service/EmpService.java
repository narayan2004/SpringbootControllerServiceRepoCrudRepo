package com.capgemini.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Employee;
import com.capgemini.repository.EmpRepository;

@Service
public class EmpService {
	
    @Autowired  
    private EmpRepository empRepository;  
    public List<Employee> getAllEmps(){  
        List<Employee>empRecords = new ArrayList<>();  
        empRepository.findAll().forEach(empRecords::add);  
        return empRecords;  
    }  
    public Employee getEmp(String id){
    	Employee emp=empRepository.findById(id).orElse(new Employee());
    	return emp;
    }  
    public void addEmp(Employee emp){  
    	empRepository.save(emp);  
    }  
    public void delete(String id){  
    	empRepository.deleteById(id);
    }
    
    public List<Employee> getFilterSalary() {
   	 return ((Collection<Employee>) empRepository.findAll()).stream().filter(emp->emp.getSalary()>40000 && emp.getSalary() < 80000 ).collect(Collectors.toList());
   }

}
