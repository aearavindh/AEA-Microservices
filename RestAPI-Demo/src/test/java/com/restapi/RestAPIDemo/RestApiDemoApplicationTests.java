package com.restapi.RestAPIDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restapi.RestAPIDemo.entity.Employee;
import com.restapi.RestAPIDemo.repository.EmployeeRepository;
import com.restapi.RestAPIDemo.service.EmployeeService;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class RestApiDemoApplicationTests {
	@Autowired
	EmployeeRepository repository;
	
	@Test
	@Order(3)
	public void test_getEmployees() {
		Iterable<Employee> employees = repository.findAll();
		System.out.println("Inside Get Employees");
		
		for(Employee employee:employees) {
			System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName());
		}
		
	}
	
	@Test
	@Order(2)
	public void test_getEmployee() {
		Optional<Employee> employees = repository.findById(2);
		Employee employee=employees.get();
		System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName());
		
	}
	
	@Test
	@Order(1)
	public void test_createEmployee() {
		Employee emp1;
		emp1=new Employee();
		emp1.setEmployeeId(1);
		emp1.setEmployeeName("Jack");
		emp1.setEmployeeAddress("California");
		repository.save(emp1);
		
		
		emp1.setEmployeeId(2);
		emp1.setEmployeeName("Tim");
		emp1.setEmployeeAddress("Belfast");
		
		
		repository.save(emp1);
		
		
	}
	

}
