package com.batch23.Batch23Demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch23.Batch23Demo.dao.EmployeeDAO;
import com.batch23.Batch23Demo.entities.Employee;
import com.batch23.Batch23Demo.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public Employee getEmployee(int id) {
		Optional<Employee> employees = repository.findById(id);
		return employees.get();
	}
	public List<Employee> getEmployees() {
		return (List<Employee>) repository.findAll();
	}
	public Employee createEmployee(Employee emp) {
		return repository.save(emp);
	}
	public Employee updateEmployee(int id,Employee emp) {
		Optional<Employee> employees = repository.findById(id);
		Employee employee = employees.get();
		employee.setEmployeeName(emp.getEmployeeName());
		employee.setEmployeeAddress(emp.getEmployeeAddress());
		
		return repository.save(emp);
	}
	public Employee deleteEmployee(int id) {
		Optional<Employee> employees = repository.findById(id);
		Employee employee = employees.get();
		if(employee!=null) {
			repository.deleteById(id);
		}
		return employee;
		
	}

}
