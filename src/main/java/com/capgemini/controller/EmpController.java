package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Employee;
import com.capgemini.service.EmpService;

@RestController 
public class EmpController {
    @Autowired  
    private EmpService empService;
    
    @RequestMapping("/")  
    public List<Employee> getAllEmps(){  
        return empService.getAllEmps();  
    }
    
    @RequestMapping(value="/addEmp",method = RequestMethod.POST)  
    public void addEmp(@RequestBody Employee emp){  
    	empService.addEmp(emp);  
    } 
    
    @RequestMapping(value="/emp/{id}")  
    public Employee getEmp(@PathVariable String id){  
        return empService.getEmp(id);  
    }
    
    @RequestMapping(value="/deleteEmp/{id}")  
    public void delete(@PathVariable String id){
    	empService.delete(id);
    } 
    
    @RequestMapping("/filterSal")
    public List<Employee> getFilterSalary()
    {
       return empService.getFilterSalary();
    }

}
