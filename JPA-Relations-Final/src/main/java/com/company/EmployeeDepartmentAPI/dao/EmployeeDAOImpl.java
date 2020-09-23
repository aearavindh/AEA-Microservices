package com.company.EmployeeDepartmentAPI.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.EmployeeDepartmentAPI.entity.Employee;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static List<Employee> employees=new ArrayList<Employee>();
	static int counter=0;
	
	static {
		employees.add(new Employee(++counter,"Vinay","Chouhan","v.c@wipro.com"));
		employees.add(new Employee(++counter,"Jack","Price","j.p@wipro.com"));
		employees.add(new Employee(++counter,"Tim","Gill","t.g@wipro.com"));
		
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee tempEmployee=null;
		for(Employee employee:employees) {
			if(employee.getEmployeeId()==id) {
				tempEmployee=employee;
				break;
				
			}
			
		}
		return tempEmployee;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		Employee saveEmployee=new Employee();
		saveEmployee.setEmployeeId(++counter);
		saveEmployee.setFirstName(emp.getFirstName());
		saveEmployee.setLastName(emp.getLastName());
		saveEmployee.setEmail(emp.getEmail());
		
		employees.add(saveEmployee);
		return saveEmployee;
		
	}

	@Override
	public Employee updateEmployee(int id, Employee emp) {
		Employee updateEmployee=null;
		
		for(Employee employee:employees) {
			if(employee.getEmployeeId()==id) {
				employee.setFirstName(emp.getFirstName());
				employee.setLastName(emp.getLastName());
				employee.setEmail(emp.getEmail());
				updateEmployee=employee;
				break;
				
			}
			
		}
		return updateEmployee;
		
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee deletedEmployee=null;
		Iterator<Employee> itr = employees.iterator();
		while(itr.hasNext()) {
			Employee emp=itr.next();
			if(emp.getEmployeeId()==id) {
				deletedEmployee=emp;				
				itr.remove();
			}
			
		}
		return deletedEmployee;
		
	}

}
