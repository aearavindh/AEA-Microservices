package com.company.EmployeeDepartmentAPI.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.EmployeeDepartmentAPI.entity.Employee;
import com.company.EmployeeDepartmentAPI.exception.EmployeeNotFound;
import com.company.EmployeeDepartmentAPI.service.EmployeeService;

@RestController

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		
		return employeeService.getEmployees();
		
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee tempEmployee=employeeService.getEmployee(id);
		if(tempEmployee==null) {
			throw new EmployeeNotFound("Not Found-->"+id);
			
		}
		
		return tempEmployee;
		
		
	}
	@PostMapping("/employees")
	public ResponseEntity<Void> createEmployee(@RequestBody Employee emp) {
		Employee savedEmployee=employeeService.createEmployee(emp);
		// http://localhost:8080/employees/{id} -->savedEmployee.getEmployeeId()
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEmployee.getEmployeeId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
		Employee tempEmployee=employeeService.updateEmployee(id,emp);
		if(tempEmployee==null) {
			throw new EmployeeNotFound("Not Found-->"+id);
			
		}
		return tempEmployee;
		
		
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		Employee tempEmployee=employeeService.deleteEmployee(id);
		if(tempEmployee==null) {
			throw new EmployeeNotFound("Not Found-->"+id);
			
		}
		
	}
	

}
