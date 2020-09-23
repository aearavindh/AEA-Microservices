package com.company.EmployeeDepartmentAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.EmployeeDepartmentAPI.dao.EmployeeDAO;
import com.company.EmployeeDepartmentAPI.entity.Employee;
import com.company.EmployeeDepartmentAPI.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees =(List<Employee>) repository.findAll();
		return employees;
	}
	
	public Employee getEmployee(int id) {
		Optional<Employee> employees = repository.findById(id);
		Employee employee = employees.get();
		return employee;
	}
	public Employee createEmployee(Employee emp) {
		return repository.save(emp);
	}
	public Employee updateEmployee(int id, Employee emp) {
		Optional<Employee> employees = repository.findById(id);
		Employee employee = employees.get();
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setEmail(emp.getEmail());
		
		return repository.save(employee);
	}
	public Employee deleteEmployee(int id) {
		Optional<Employee> employees = repository.findById(id);
		Employee employee = employees.get();
		repository.delete(employee);
		
		return employee;
	}

}
