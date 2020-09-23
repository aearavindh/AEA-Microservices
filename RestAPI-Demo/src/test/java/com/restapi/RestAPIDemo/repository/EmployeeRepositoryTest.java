package com.restapi.RestAPIDemo.repository;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.restapi.RestAPIDemo.entity.Employee;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
class EmployeeRepositoryTest {
	@Autowired
	EmployeeRepository repository;

	@Test
	@Order(1)
	void createEmployee() {
		System.out.println("Entering Create Employee");
		Employee employee1=new Employee();
		Employee employee2=new Employee();
		
		employee1.setEmployeeName("Vijay");
		employee1.setEmployeeAddress("Bangalore");
		
		employee2.setEmployeeName("Vinay");
		employee2.setEmployeeAddress("Chennai");
		
		repository.save(employee1);
		repository.save(employee2);
		
	}
	@Test
	@Order(2)
	void getEmployees() {
		createEmployee();
		Iterable<Employee> employees = repository.findAll();

		
		System.out.println("Employee Details");
		
		for(Employee employee: employees) {
			System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName());
		}
		
	}
	@Test
	@Order(3)
	void test_findEmployeeByName() {
		Employee employee1=new Employee();
		Employee employee2=new Employee();
		
		employee1.setEmployeeName("Vijay");
		employee1.setEmployeeAddress("Bangalore");
		
		employee2.setEmployeeName("Vinay");
		employee2.setEmployeeAddress("Chennai");
		
		repository.save(employee1);
		repository.save(employee2);
		
		Employee employee = repository.findByEmployeeName("Vinay");
		System.out.println("Employee Details"+employee);
		
		
		
	}
	@Test
	@Order(4)
	void test_findEmployeeByAddress() {
		Employee employee1=new Employee();
		Employee employee2=new Employee();
		
		employee1.setEmployeeName("Vijay");
		employee1.setEmployeeAddress("Bangalore");
		
		employee2.setEmployeeName("Vinay");
		employee2.setEmployeeAddress("Chennai");
		
		repository.save(employee1);
		repository.save(employee2);
		
		Employee employee = repository.findByEmployeeAddress("Bangalore");
		System.out.println("Employee Details"+employee);
		
		
		
	}
	@Test
	@Order(5)
	void test_findEmployeeByNameAndAddress() {
		Employee employee1=new Employee();
		Employee employee2=new Employee();
		
		employee1.setEmployeeName("Vijay");
		employee1.setEmployeeAddress("Bangalore");
		
		employee2.setEmployeeName("Vinay");
		employee2.setEmployeeAddress("Chennai");
		
		repository.save(employee1);
		repository.save(employee2);
		
		Employee employee = repository.findByEmployeeNameAndEmployeeAddress("Vinay", "Chennai");
		System.out.println("Employee Details"+employee);
		
		
		
	}
	@Test
	@Order(6)
	void test_getEmployeeByNameAndAddress() {
		Employee employee1=new Employee();
		Employee employee2=new Employee();
		Employee employee3=new Employee();
		
		employee1.setEmployeeName("Vijay");
		employee1.setEmployeeAddress("Bangalore");
		
		employee2.setEmployeeName("Vinay");
		employee2.setEmployeeAddress("Chennai");
		
		employee3.setEmployeeName("Vinay");
		employee3.setEmployeeAddress("Chennai");
		
		repository.save(employee1);
		repository.save(employee2);
		repository.save(employee3);
		
		List<Employee>employees = repository.getEmployeeNameAndEmployeeAddress("Vinay","Chennai");
		for(Employee employee: employees) {
			System.out.println("Employee Details"+employee);
		}
		
		
		
	}
	@Test
	@Order(7)
	void test_getEmployees() {
		Employee employee1=new Employee();
		Employee employee2=new Employee();
		
		employee1.setEmployeeName("Vijay");
		employee1.setEmployeeAddress("Bangalore");
		
		employee2.setEmployeeName("Vinay");
		employee2.setEmployeeAddress("Chennai");
		
		repository.save(employee1);
		repository.save(employee2);
		
		List<Object[]> objects = repository.getEmployees();
		
		System.out.println("In JPQL get Employees Method");
		for(Object[] object:objects) {
			System.out.println(object[0]+"\t"+object[1]);
		}
		
		
	}
	@Test
	@Order(8)
	void test_getEmployeesNQ() {
		Employee employee1=new Employee();
		Employee employee2=new Employee();
		
		employee1.setEmployeeName("Vijay");
		employee1.setEmployeeAddress("Bangalore");
		
		employee2.setEmployeeName("Vinay");
		employee2.setEmployeeAddress("Chennai");
		
		repository.save(employee1);
		repository.save(employee2);
		List<Employee> employees = repository.findAllEmployees();
		for(Employee employee:employees) {
			System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName());
		}
		
		
	}
	
	

}
