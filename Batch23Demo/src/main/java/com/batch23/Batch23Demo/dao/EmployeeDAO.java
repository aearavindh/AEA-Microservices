package com.batch23.Batch23Demo.dao;

import java.util.List;

import com.batch23.Batch23Demo.entities.Employee;




public interface EmployeeDAO {
	
	public Employee getEmployee(int id);
	public List<Employee> getEmployees();
	public Employee createEmployee(Employee emp);
	public Employee updateEmployee(int id,Employee emp);
	public Employee deleteEmployee(int id);
	
	

}
