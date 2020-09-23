package com.company.EmployeeDepartmentAPI;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.EmployeeDepartmentAPI.entity.Employee;
import com.company.EmployeeDepartmentAPI.repository.EmployeeRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EmployeeDepartmentApiApplicationTests {
	@Autowired
	EmployeeRepository repository;
	
	
	@Test
	@Order(1)
	void createEmployee() {
		System.out.println("In Create Employees method");
		Employee e1=new Employee(1,"Vivek","Mishra","vivek.mishra@wipro.com");
		repository.save(e1);
		Employee e2=new Employee(2,"Louise","Clarke","louise.clarke@wipro.com");
		repository.save(e2);
		Employee e3=new Employee(3,"Alok","Seth","alok.seth@wipro.com");
		repository.save(e3);
		Employee e4=new Employee(4,"Vikram","Kumar","vikram.kumar@wipro.com");
		repository.save(e4);
		
		
	}
	
	@Test
	@Order(2)
	void getEmployees() {
		Iterable<Employee> employees = repository.findAll();
		
		Iterator<Employee> itr = employees.iterator();
		System.out.println("In Get all Employees Method");
		while(itr.hasNext()) {
			Employee temp=itr.next();
			System.out.println(temp.getEmployeeId()+"\t"+temp.getFirstName());
		}
		
	}
	@Test
	@Order(3)
	void getEmployee() {
		Optional<Employee> employees = repository.findById(3);
		System.out.println("In Get specific Employee Method");
		Employee employee = employees.get();
		System.out.println(employee.getEmployeeId()+"\t"+employee.getFirstName());
		
	}
	@Test
	@Order(4)
	void test_getEmployeeByFirstNameAndLastName() {
		Employee employee = repository.findByFirstNameAndLastName("Louise", "Clarke");
		System.out.println("In test method Find By First Name & Last Name");
		System.out.println(employee.getEmployeeId()+"\t"+employee.getEmail());
	}
	
	@Test
	@Order(5)
	void test_getEmployees() {
		List<Object[]> objects = repository.getEmployees();
		
		System.out.println("In JPQL get Employees Method");
		for(Object[] object:objects) {
			System.out.println(object[0]+"\t"+object[1]);
		}
		
		
	}
	
	@Test
	@Order(6)
	void test_getEmployeesByFirstNameAndLastName() {
		System.out.println("In JPQL getEmployeesByFirstNameAndLastName method");
		List<Employee> employees = repository.getEmployeeByFirstNameAndLastName("Alok", "Seth");
		
		for(Employee employee:employees) {
			System.out.println(employee.getEmployeeId()+"\t"+employee.getEmail());
		}
	}
	
	@Test
	@Order(7)
	void test_getEmployeesNQ() {
		List<Employee> employees = repository.findAllEmployees();
		for(Employee employee:employees) {
			System.out.println(employee.getEmployeeId()+"\t"+employee.getFirstName());
		}
		
		
	}
	

}
