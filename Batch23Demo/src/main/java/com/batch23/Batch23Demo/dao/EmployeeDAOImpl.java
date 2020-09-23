package com.batch23.Batch23Demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.batch23.Batch23Demo.entities.Employee;




@Component
@Qualifier("testEmployee")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static List<Employee> employees=new ArrayList<Employee>();
	static int counter=0;
	
	static {
		employees.add(new Employee(++counter,"Vinay","Bangalore"));
		employees.add(new Employee(++counter,"Jack","London"));
		employees.add(new Employee(++counter,"Tim","NewYork"));
		employees.add(new Employee(++counter,"Vijay","Chennai"));
		
		
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		
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
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		Employee empSave=emp;
		empSave.setEmployeeId(++counter);
		
		employees.add(empSave);
		return empSave;

	}

	@Override
	public Employee updateEmployee(int id, Employee emp) {
		Employee updatedEmployee=null;
		
		for(Employee employee:employees) {
			if(employee.getEmployeeId()==id) {
				employee.setEmployeeName(emp.getEmployeeName());
				employee.setEmployeeAddress(emp.getEmployeeAddress());
				updatedEmployee=employee;
				break;
			}
			
		}
		return updatedEmployee;
		
	}

	@Override
	public Employee deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee deletedEmployee=null;
		Iterator<Employee> itr = employees.iterator();
		while(itr.hasNext()) {
			Employee emp = itr.next();
			if(emp.getEmployeeId()==id) {
				deletedEmployee=emp;
				itr.remove();
			}
		}
		return deletedEmployee;

	}

}
