package com.restapi.RestAPIDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.RestAPIDemo.dao.EmployeeDAO;
import com.restapi.RestAPIDemo.entity.Employee;
import com.restapi.RestAPIDemo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	
	public Employee getEmployee(int id) {
		Optional<Employee> employees = repository.findById(id);
		return employees.get();
	}
	
	public List<Employee> getEmployees() {
		List<Employee>employees=(List<Employee>) repository.findAll(); //List of Integers
		/*
		 * 
		 * 
		 * 
		 * Business logic is sorting the Employee Ids 
		 * 
		 * 
		 * 
		 */
		return employees;
		
	}
	
	public Employee createEmployee(Employee emp) {
		return repository.save(emp);
	}
	
	public Employee updateEmployee(int id,Employee emp) {
		Optional<Employee> employees = repository.findById(id);
		Employee employee= employees.get();
		employee.setEmployeeName(emp.getEmployeeName());
		employee.setEmployeeAddress(emp.getEmployeeAddress());
		Employee employeeSaved = repository.save(employee);
		return employeeSaved;
		
	}
	
	public Employee deleteEmployee(int id) {
		Optional<Employee> employees = repository.findById(id);
		Employee employee= employees.get();
		
		if(employee!=null) {
			repository.deleteById(id);
		}
		return employee;
	}
	
	

}
