package com.company.EmployeeDepartmentAPI;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.EmployeeDepartmentAPI.entity.Department;
import com.company.EmployeeDepartmentAPI.entity.Employee;
import com.company.EmployeeDepartmentAPI.repository.DepartmentRepository;
import com.company.EmployeeDepartmentAPI.repository.EmployeeRepository;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class OneToManyTestDemo {
	@Autowired
	private DepartmentRepository repository;

	@Test
	@Order(1)
	void test_saveDepartment() {
		Department hrDepartment=new Department();		
		hrDepartment.setDepartmentName("HR");
		
		Department finDepartment=new Department();		
		finDepartment.setDepartmentName("Finance");
		
		Employee emp=new Employee();		
		emp.setFirstName("Vishal");
		emp.setLastName("Jain");
		emp.setEmail("vishal.jain@wipro.com");
		
		Employee emp1=new Employee();
		emp1.setFirstName("Vikas");
		emp1.setLastName("Luthra");
		emp1.setEmail("vikas.luthra@wipro.com");
		
		Employee emp2=new Employee();
		emp2.setFirstName("Mohan");
		emp2.setLastName("Sharma");
		emp2.setEmail("mohan.sharma@wipro.com");
		
		Employee emp3=new Employee();
		emp3.setFirstName("Tom");
		emp3.setLastName("Hamilton");
		emp3.setEmail("tom.hamilton@wipro.com");
		
		
		
		
		HashSet<Employee> employeesHR=new HashSet<Employee>();
		employeesHR.add(emp);
		employeesHR.add(emp1);
		
		hrDepartment.setEmployees(employeesHR);	
		
		
		emp1.setDepartment(hrDepartment);
		
		emp.setDepartment(hrDepartment);
		
		
		HashSet<Employee> employeesFin=new HashSet<Employee>();
		employeesFin.add(emp2);
		employeesFin.add(emp3);
		
		finDepartment.setEmployees(employeesFin);	
		
		
		emp2.setDepartment(finDepartment);
		
		emp3.setDepartment(finDepartment);
		
		
		
		
		
		
		
	
		repository.save(hrDepartment);
		repository.save(finDepartment);
		
		
	
		
		
		
	}
	@Test
	@Order(2)
	@Transactional
	void test_getDepartments() {
		
		Iterable<Department> deparments = repository.findAll();
		
		Iterator<Department> iterator = deparments.iterator();
		while(iterator.hasNext()) {
			Department department=iterator.next();
			System.out.println("Details of Department:"+department);
			
			Set<Employee> employees = department.getEmployees();
			System.out.println("Employee Details");
			for(Employee employee:employees) {
				System.out.println(employee);
			}
		
			
			
		}
		
	}

}
