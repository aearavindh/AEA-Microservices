package com.restapi.RestAPIDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.restapi.RestAPIDemo.entity.Employee;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class RestApiDemoApplicationIntegerationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@Order(3)
	public void getEmployees() {
		Employee[] employees=this.restTemplate.getForObject("/employees", Employee[].class);
		
		for(int i=0;i<employees.length;i++) {
			System.out.println(employees[i].getEmployeeId()+"\t"+employees[i].getEmployeeName());
		}
	}
	
	@Test
	@Order(1)
	public void create_Employee_One() {
		Employee employee=new Employee();
		
		
		employee.setEmployeeName("Vijay");
		employee.setEmployeeAddress("Bangalore");
		
		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		HttpEntity<Employee> request=new HttpEntity<>(employee,headers);
		
		ResponseEntity<String> result = this.restTemplate.postForEntity("/employees", request, String.class);
	
		assertEquals(201, result.getStatusCodeValue());
	}
	
	@Test
	@Order(2)
	public void create_Employee_Two() {
		Employee employee=new Employee();
		
		
		employee.setEmployeeName("Vinay");
		employee.setEmployeeAddress("Chennai");
		
		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		HttpEntity<Employee> request=new HttpEntity<>(employee,headers);
		
		ResponseEntity<Employee> result = this.restTemplate.postForEntity("/employees", request, Employee.class);
	
		assertEquals(201, result.getStatusCodeValue());
	}
	
	

}
