package com.restapi.RestAPIDemo.dao;

import java.util.List;

import com.restapi.RestAPIDemo.entity.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployee(int id);
	public List<Employee> getEmployees();
	public Employee createEmployee(Employee emp);
	public Employee updateEmployee(int id,Employee emp);
	public Employee deleteEmployee(int id);
	
	

}
