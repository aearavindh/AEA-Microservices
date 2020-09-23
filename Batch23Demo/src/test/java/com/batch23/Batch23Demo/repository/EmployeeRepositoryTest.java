package com.batch23.Batch23Demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.batch23.Batch23Demo.entities.Employee;
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
//@SpringBootTest
class EmployeeRepositoryTest {
	@Autowired
	EmployeeRepository repository;

	public void createEmployees() {
		Employee emp1=new Employee();
		emp1.setEmployeeName("Jack");
		emp1.setEmployeeAddress("California");
		
		Employee emp2=new Employee("Vijay","Chennai");
		Employee emp3=new Employee("Arya","Chennai");
		Employee emp4=new Employee("Vijay","Bangalore");
		
		repository.save(emp1);
		repository.save(emp2);
		repository.save(emp3);
		repository.save(emp4);
		
	}
	@Test
	@Order(1)
	public void test_getEmployee() {
		createEmployees();
		Optional<Employee> employees = repository.findById(3);
		Employee employee=employees.get();

		System.out.println(employee.getEmployeeAddress()+"\t"+employee.getEmployeeName());


	}
	@Test
	@Order(2)
	public void test_getEmployees() {
		createEmployees();
		Iterable<Employee> employees = repository.findAll();
		for(Employee employee: employees) {
			System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName());
		}
		
	}
	@Test
	@Order(3)
	public void test_getEmployeeByName() {
		createEmployees();
		List<Employee> employees = repository.findByEmployeeName("Vijay");
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeAddress()+","+employee.getEmployeeId());
		}
		
	}
	
	@Test
	@Order(4)
	public void test_getEmployeeByAddress() {
		createEmployees();
		List<Employee> employees = repository.findByEmployeeAddress("Chennai");
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeName()+","+employee.getEmployeeId());
		}
		
	}
	
	@Test
	@Order(5)
	public void test_getEmployeeByNameAndAddress() {
		createEmployees();
		Employee employee = repository.findByEmployeeNameAndEmployeeAddress("Vijay", "Chennai");
		
		
		System.out.println(employee.getEmployeeName()+","+employee.getEmployeeId());
		
	}
	@Test
	@Order(6)
	public void test_getEmployeeByNameOrAddress() {
		createEmployees();
		List<Employee> employees = repository.findByEmployeeNameOrEmployeeAddress("Vijay", "Chennai");
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeName()+","+employee.getEmployeeId());
		}
		
	}
	@Test
	@Order(7)
	public void test_getEmployeeByNameJPQL() {
		createEmployees();
		List<Employee> employees = repository.getEmployeeByName("Vijay");
		for(Employee employee: employees) {
			System.out.println(employee.getEmployeeId()+","+employee.getEmployeeName());
		}
	}
	@Test
	@Order(8)
	public void test_getEmployeeByNameAndAddressJPQL() {
		createEmployees();
		List<Employee> employees = repository.getEmployeeNameAndEmployeeAddress("Vijay", "Chennai");
		
		for(Employee employee: employees) {
			System.out.println(employee.getEmployeeId()+","+employee.getEmployeeName());
		}
		
	}
	@Test
	@Order(9)
	public void test_getEmployeesJPQL() {
		createEmployees();
		List<Object[]> employees = repository.getEmployees();
		for(Object[] employee:employees) {
			System.out.println(employee[0]+"\t"+employee[1]);
		}
		
	}


}
