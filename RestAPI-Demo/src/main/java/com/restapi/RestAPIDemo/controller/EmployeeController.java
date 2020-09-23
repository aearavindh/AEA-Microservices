package com.restapi.RestAPIDemo.controller;

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

import com.restapi.RestAPIDemo.entity.Employee;
import com.restapi.RestAPIDemo.exception.EmployeeNotFound;
import com.restapi.RestAPIDemo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return service.getEmployees();
		
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee emp=service.getEmployee(id);
		if(emp==null) {
			throw new EmployeeNotFound("id--"+id);
			
		}
		
		
		return emp;
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		Employee savedEmployee=service.createEmployee(emp);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEmployee.getEmployeeId()).toUri();
		return ResponseEntity.created(location).build();
		
		
	}
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable int id,@RequestBody Employee emp) {
		Employee updatedEmployee=service.updateEmployee(id, emp);
		if(updatedEmployee==null) {
			throw new EmployeeNotFound("id--"+id);
			
		}
		
		
	}
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		Employee deletedEmployee=service.deleteEmployee(id);
		if(deletedEmployee==null) {
			throw new EmployeeNotFound("id--"+id);
			
		}
		
		
	}

}
