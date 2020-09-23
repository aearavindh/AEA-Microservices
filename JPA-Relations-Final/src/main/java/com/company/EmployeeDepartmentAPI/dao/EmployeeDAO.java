package com.company.EmployeeDepartmentAPI.dao;

import java.util.List;

import com.company.EmployeeDepartmentAPI.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
	public Employee createEmployee(Employee emp);
	public Employee updateEmployee(int id, Employee emp);
	public Employee deleteEmployee(int id);
	
	
	
	
	

}
