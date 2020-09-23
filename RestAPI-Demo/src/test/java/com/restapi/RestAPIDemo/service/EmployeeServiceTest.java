package com.restapi.RestAPIDemo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restapi.RestAPIDemo.entity.Employee;
import com.restapi.RestAPIDemo.repository.EmployeeRepository;
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

class EmployeeServiceTest {
	@InjectMocks
	EmployeeService service;
	@Mock
	private EmployeeRepository repository; //repository=mock(EmployeeRepository);
	

	@Test
	@Order(2)
	void test_getEmployee() {
		Optional<Employee> employees = Optional.of(new Employee(1,"Tim","Cardiff"));
		when(repository.findById(1)).thenReturn(employees);
		Employee employee = service.getEmployee(1);
		
		Employee savedEmployee=employees.get();
		
		System.out.println(savedEmployee.getEmployeeId()+"\t"+savedEmployee.getEmployeeName());
		assertEquals(1, employee.getEmployeeId());
		
		
	}
	@Test
	@Order(3)
	void test_getAllEmployees() {
		List<Employee> employeesList=new ArrayList<Employee>();
		employeesList.add(new Employee(1,"Vinay","Bangalore"));
		employeesList.add(new Employee(2,"Vijay","Chennai"));
		when(repository.findAll()).thenReturn(employeesList);
		
		List<Employee> employees = service.getEmployees();
		
		for(Employee employee: employees) {
			System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName());
		}
		assertEquals(2,employees.get(1).getEmployeeId());

	}
	
	@Test
	@Order(1)
	void test_CreateEmployee() {
		Employee employee=new Employee();
		employee.setEmployeeId(4);
		employee.setEmployeeName("Neil");
		employee.setEmployeeAddress("Cardiff");
		
		
		Employee mockemployee=new Employee();
		mockemployee.setEmployeeId(6);
		mockemployee.setEmployeeName("Tim");
		mockemployee.setEmployeeAddress("London");
		
		when(repository.save(employee)).thenReturn(mockemployee);
		Employee emp=service.createEmployee(employee);
		System.out.println(emp.toString());
		verify(repository,atLeastOnce()).save(employee);
	}

}
