package com.batch23.Batch23Demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.batch23.Batch23Demo.common.NotFoundException;
import com.batch23.Batch23Demo.dao.EmployeeDAO;
import com.batch23.Batch23Demo.entities.Employee;
import com.batch23.Batch23Demo.exceptions.EmployeeNotFound;
import com.batch23.Batch23Demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return service.getEmployees();
		
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employee = service.getEmployee(id);
		if(employee==null) {
			//throw new EmployeeNotFound("Employee-->"+id+" not found.");
			throw new NotFoundException("Employee-->"+id+" not found.");
		}
		
		return employee;
		
	}
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		Employee savedEmployee = service.createEmployee(emp);
		/*
		 * 
		 * Step 1: http://localhost:1010/employees/
		 * Step 2 : append {id} // http://localhost:1010/employees/{id}
		 * Replace {id} with savedEmployee.getEmployeeId()'
		 * http://localhost:1010/employees/5
		 */
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
					 .path("/{id}")
					 .buildAndExpand(savedEmployee.getEmployeeId())
					 .toUri();
		return ResponseEntity.created(location).build();
		
	}
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") int sid,@RequestBody Employee emp) {
		Employee updatedEmployee = service.updateEmployee(sid, emp);
		if(updatedEmployee==null) {
			//throw new EmployeeNotFound("Employee-->"+sid+" not found.");
			throw new NotFoundException("Employee-->"+sid+" not found.");
		}
		
		return updatedEmployee;
	}
	@DeleteMapping("/employees/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		Employee deletedEmployee = service.deleteEmployee(id);
		if(deletedEmployee==null) {
			//throw new EmployeeNotFound("Employee-->"+id+" not found.");
			throw new NotFoundException("Employee-->"+id+" not found.");
		}
		
		return deletedEmployee;
	}
	
	
	

}
